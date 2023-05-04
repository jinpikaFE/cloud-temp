package com.jinpika.temp.ums.ums.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinpika.temp.ums.ums.mapper.UserMapper;
import com.jinpika.temp.ums.ums.model.User;
import com.jinpika.temp.ums.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author macro
 * @since 2023-05-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<User> page = new Page(pageNum, pageSize);
        Page<User> result = userMapper.getUserList(keyword, page);
        return result;
    }
}
