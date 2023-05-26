package com.jinpika.temp.ums.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinpika.temp.ums.ums.mapper.AdminMapper;
import com.jinpika.temp.ums.ums.model.Admin;
import com.jinpika.temp.ums.ums.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Admin> list(String keyword, Integer pageSzie, Integer pageNum) {

        return null;
    }
}
