package com.jinpika.temp.ums.ums.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinpika.temp.ums.ums.dto.ResourceDto;
import com.jinpika.temp.ums.ums.mapper.ResourceMapper;
import com.jinpika.temp.ums.ums.model.Resource;
import com.jinpika.temp.ums.ums.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Page<ResourceDto> list(Integer categoryId, String keyword, Integer pageSzie, Integer pageNum) {
        Page<ResourceDto> page = new Page<>(pageNum, pageSzie);
        Page<ResourceDto> result = resourceMapper.getResourceList(categoryId, keyword, page);
        return result;
    }
}
