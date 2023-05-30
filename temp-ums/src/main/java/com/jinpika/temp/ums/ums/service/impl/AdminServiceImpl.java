package com.jinpika.temp.ums.ums.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinpika.common.api.CommonResult;
import com.jinpika.common.exception.Asserts;
import com.jinpika.temp.ums.feign.AuthFeignService;
import com.jinpika.temp.ums.ums.dto.AdminDto;
import com.jinpika.temp.ums.ums.mapper.AdminMapper;
import com.jinpika.temp.ums.ums.model.Admin;
import com.jinpika.temp.ums.ums.model.AdminRole;
import com.jinpika.temp.ums.ums.service.AdminRoleService;
import com.jinpika.temp.ums.ums.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员用户表 服务实现类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AuthFeignService authFeignService;

    @Value("${auth-info.client-id}")
    private String CLIENT_ID;

    @Value("${auth-info.client-secret}")
    private String CLIENT_SECRET;

    @Value("${auth-info.grant-type}")
    private String GRANT_TYPE;

    @Override
    public Page<Admin> list(String keyword, Integer pageSzie, Integer pageNum) {
        Page<Admin> page = new Page<>(pageNum, pageSzie);
        Page<Admin> result = adminMapper.getAdminList(keyword, page);
        return result;
    }

    @Override
    public AdminDto create(AdminDto adminDto) {
        // 业务上处理不添加唯一索引问题
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Admin::getUsername, adminDto.getUsername());

        if (adminMapper.exists(wrapper)) {
            Asserts.fail("用户名已经存在");
        }

        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(adminDto.getPassword());
        adminDto.setPassword(encodePassword);

        Boolean success = save(adminDto);
        if (!success) {
            Asserts.fail("添加用户失败");
        }
        if (adminDto.getRoleIds() != null) {
            this.allocRole(adminDto.getId(), adminDto.getRoleIds());
        }

        return adminDto;
    }

    @Override
    public boolean update(Integer id, AdminDto adminDto) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.lambda().notIn(Admin::getId, id).eq(Admin::getUsername, adminDto.getUsername());

        if (adminMapper.exists(wrapper)) {
            Asserts.fail("角色名已经存在");
        }

        adminDto.setId(id);
        boolean success = updateById(adminDto);
        if (!success) {
            Asserts.fail("修改角色基本信息失败");
        }
        if (adminDto.getRoleIds() != null) {
            this.allocRole(adminDto.getId(), adminDto.getRoleIds());
        }
        return true;
    }

    @Override
    public int allocRole(Integer adminId, List<Integer> roleIds) {
        // 先删除原有关系
        QueryWrapper<AdminRole> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(AdminRole::getUserId, adminId);
        adminRoleService.remove(wrapper);
        // 批量插入关系
        List<AdminRole> relationList = new ArrayList<>();
        for (Integer roleId : roleIds) {
            AdminRole relation = new AdminRole();
            relation.setUserId(adminId);
            relation.setRoleId(roleId);
            relationList.add(relation);
        }
        adminRoleService.saveBatch(relationList);
        return roleIds.size();
    }

    @Override
    public ResponseEntity<CommonResult> login(String username, String password) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
            Asserts.fail("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", CLIENT_ID);
        params.put("client_secret", CLIENT_SECRET);
        params.put("grant_type", GRANT_TYPE);
        params.put("username", username);
        params.put("password", password);
        ResponseEntity<CommonResult> restResult = authFeignService.postAccessToken(params);
        return restResult;
    }
}
