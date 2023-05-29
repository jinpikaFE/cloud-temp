package com.jinpika.temp.ums.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinpika.common.exception.Asserts;
import com.jinpika.temp.ums.ums.dto.RoleDto;
import com.jinpika.temp.ums.ums.mapper.RoleMapper;
import com.jinpika.temp.ums.ums.model.Role;
import com.jinpika.temp.ums.ums.model.RoleMenu;
import com.jinpika.temp.ums.ums.model.RoleResource;
import com.jinpika.temp.ums.ums.service.RoleMenuService;
import com.jinpika.temp.ums.ums.service.RoleResourceService;
import com.jinpika.temp.ums.ums.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色列表 服务实现类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private RoleResourceService roleResourceService;

    @Override
    public RoleDto create(RoleDto roleDto) {
        // 业务上处理不添加唯一索引问题
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Role::getRoleName, roleDto.getRoleName());

        if (roleMapper.exists(wrapper)) {
            Asserts.fail("角色名已经存在");
        }

        Boolean success = save(roleDto);
        if (!success) {
            Asserts.fail("添加角色基本信息失败");
        }
        if (roleDto.getMenuIds() != null) {
            this.allocMenu(Long.valueOf(roleDto.getId()), roleDto.getMenuIds());
        }

        if (roleDto.getResourceIds() != null) {
            this.allocResource(Long.valueOf(roleDto.getId()), roleDto.getResourceIds());
        }
        return roleDto;
    }

    @Override
    public Boolean delete(Long id, Role role) {
        /**
         * 删除分类下的资源
         */
        LambdaQueryWrapper<RoleMenu> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(RoleMenu::getRoleId, id);
        roleMenuService.remove(wrapper);
        LambdaQueryWrapper<RoleResource> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.in(RoleResource::getRoleId, id);
        roleResourceService.remove(wrapper2);
        boolean success = removeById(id);
        return success;
    }

    @Override
    public boolean update(Integer id, RoleDto roleDto) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.lambda().notIn(Role::getId, id).eq(Role::getRoleName, roleDto.getRoleName());

        if (roleMapper.exists(wrapper)) {
            Asserts.fail("角色名已经存在");
        }

        roleDto.setId(id);
        boolean success = updateById(roleDto);
        if (!success) {
            Asserts.fail("修改角色基本信息失败");
        }
//        if (roleDto.getMenuIds() != null) {
            this.allocMenu(Long.valueOf(roleDto.getId()), roleDto.getMenuIds());
//        }

        if (roleDto.getResourceIds() != null) {
            this.allocResource(Long.valueOf(roleDto.getId()), roleDto.getResourceIds());
        }
        return true;
    }

    @Override
    public Page<Role> list(String keyword, Integer pageSzie, Integer pageNum) {
        Page<Role> page = new Page<>(pageNum, pageSzie);
        Page<Role> result = roleMapper.getRoleList(keyword, page);
        return result;
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        // 先删除原有关系
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(RoleMenu::getRoleId, roleId);
        roleMenuService.remove(wrapper);
        // 批量插入关系
        List<RoleMenu> relationList = new ArrayList<>();
        for (Long menuId : menuIds) {
            RoleMenu relation = new RoleMenu();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            relationList.add(relation);
        }
        roleMenuService.saveBatch(relationList);
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        // 先删除原有关系
        QueryWrapper<RoleResource> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(RoleResource::getRoleId, roleId);
        roleResourceService.remove(wrapper);
        // 批量插入关系
        List<RoleResource> relationList = new ArrayList<>();
        for (Long resourceId : resourceIds) {
            RoleResource relation = new RoleResource();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            relationList.add(relation);
        }
        roleResourceService.saveBatch(relationList);
        return resourceIds.size();
    }
}
