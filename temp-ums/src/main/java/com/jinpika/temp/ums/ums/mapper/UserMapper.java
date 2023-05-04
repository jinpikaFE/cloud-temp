package com.jinpika.temp.ums.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.temp.ums.ums.model.User;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author macro
 * @since 2023-05-04
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 获取userList
     *
     * @return
     */
    Page<User> getUserList(String keyword, Page page);
}
