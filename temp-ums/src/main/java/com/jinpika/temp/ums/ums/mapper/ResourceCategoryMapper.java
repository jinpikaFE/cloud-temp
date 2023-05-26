package com.jinpika.temp.ums.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.temp.ums.ums.model.ResourceCategory;

/**
 * <p>
 * 资源分类表 Mapper 接口
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface ResourceCategoryMapper extends BaseMapper<ResourceCategory> {
    /**
     * 获取admin 带roles
     *
     * @return
     */
    Page<ResourceCategory> getResourceCategoryList(String keyword, Page page);
}
