package com.jinpika.temp.ums.ums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinpika.temp.ums.ums.model.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author macro
 * @since 2023-05-04
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户名或邮箱分页查询用户
     */
    Page<User> list(String keyword, Integer pageSize, Integer pageNum);
}
