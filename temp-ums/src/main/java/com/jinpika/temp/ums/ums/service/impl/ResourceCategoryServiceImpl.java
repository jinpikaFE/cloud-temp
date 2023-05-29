package com.jinpika.temp.ums.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jinpika.temp.ums.ums.mapper.ResourceCategoryMapper;
import com.jinpika.temp.ums.ums.mapper.ResourceMapper;
import com.jinpika.temp.ums.ums.model.Resource;
import com.jinpika.temp.ums.ums.model.ResourceCategory;
import com.jinpika.temp.ums.ums.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源分类表 服务实现类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Service
public class ResourceCategoryServiceImpl extends ServiceImpl<ResourceCategoryMapper, ResourceCategory> implements ResourceCategoryService {
    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Page<ResourceCategory> list(String keyword, Integer pageSzie, Integer pageNum) {
        Page<ResourceCategory> page = new Page<>(pageNum, pageSzie);
        Page<ResourceCategory> result = resourceCategoryMapper.getResourceCategoryList(keyword, page);
        return result;
    }

    @Override
    public Boolean delete(Long id, ResourceCategory resourceCategory) {
        /**
         * 删除分类下的资源
         */
        LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Resource::getCategoryId, resourceCategory.getId());
        resourceMapper.delete(wrapper);
        boolean success = removeById(id);
        return success;
    }
}
