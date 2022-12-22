package io.admin.modules.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.admin.common.exception.Asserts;
import io.admin.modules.ums.dto.UmsRoleDto;
import io.admin.modules.ums.dto.UmsRoleParams;
import io.admin.modules.ums.mapper.UmsMenuMapper;
import io.admin.modules.ums.mapper.UmsResourceMapper;
import io.admin.modules.ums.mapper.UmsRoleMapper;
import io.admin.modules.ums.model.*;
import io.admin.modules.ums.service.UmsAdminCacheService;
import io.admin.modules.ums.service.UmsRoleMenuRelationService;
import io.admin.modules.ums.service.UmsRoleResourceRelationService;
import io.admin.modules.ums.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台角色管理Service实现类
 * Created by macro on 2018/9/30.
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {
    @Autowired
    private UmsAdminCacheService adminCacheService;
    @Autowired
    private UmsRoleMenuRelationService roleMenuRelationService;
    @Autowired
    private UmsRoleResourceRelationService roleResourceRelationService;
    @Autowired
    private UmsMenuMapper menuMapper;
    @Autowired
    private UmsResourceMapper resourceMapper;
    @Autowired
    private UmsRoleMapper umsRoleMapper;

    @Override
    public UmsRoleParams create(UmsRoleParams role) {
        Boolean success = save(role);
        if (!success) {
            Asserts.fail("添加角色基本信息失败");
        }
        this.allocMenu(role.getId(), role.getMenus());
        this.allocResource(role.getId(), role.getResources());
        return role;
    }

    @Override
    public boolean update(Long id, UmsRoleParams role) {
        role.setId(id);
        boolean success = updateById(role);
        if (!success) {
            Asserts.fail("修改角色基本信息失败");
        }
        this.allocMenu(role.getId(), role.getMenus());
        this.allocResource(role.getId(), role.getResources());
        return true;
    }

    @Override
    public boolean delete(List<Long> ids) {
        boolean success = removeByIds(ids);
        adminCacheService.delResourceListByRoleIds(ids);
        return success;
    }

    @Override
    public Page<UmsRoleDto> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<UmsRoleDto> page = new Page<>(pageNum, pageSize);
        Page<UmsRoleDto> results = umsRoleMapper.getRoleListAndMS(keyword, page);
        return results;
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return menuMapper.getMenuList(adminId);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return menuMapper.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return resourceMapper.getResourceListByRoleId(roleId);
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        QueryWrapper<UmsRoleMenuRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UmsRoleMenuRelation::getRoleId, roleId);
        roleMenuRelationService.remove(wrapper);
        //批量插入新关系
        List<UmsRoleMenuRelation> relationList = new ArrayList<>();
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            relationList.add(relation);
        }
        roleMenuRelationService.saveBatch(relationList);
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        QueryWrapper<UmsRoleResourceRelation> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UmsRoleResourceRelation::getRoleId, roleId);
        roleResourceRelationService.remove(wrapper);
        //批量插入新关系
        List<UmsRoleResourceRelation> relationList = new ArrayList<>();
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            relationList.add(relation);
        }
        roleResourceRelationService.saveBatch(relationList);
        adminCacheService.delResourceListByRole(roleId);
        return resourceIds.size();
    }
}
