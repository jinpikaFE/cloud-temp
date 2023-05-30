package com.jinpika.temp.ums.ums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinpika.temp.ums.ums.dto.AdminDto;
import com.jinpika.temp.ums.ums.model.Admin;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 管理员用户表 服务类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface AdminService extends IService<Admin> {
    /**
     * 分页获取管理员用户列表
     *
     * @param keyword
     * @param pageSzie
     * @param pageNum
     * @return
     */
    Page<Admin> list(String keyword, Integer pageSzie, Integer pageNum);

    @Transactional
    int allocRole(Integer adminId, List<Integer> roleIds);

    @Transactional
    AdminDto create(AdminDto adminDto);

    @Transactional
    boolean update(Integer id, AdminDto adminDto);
}
