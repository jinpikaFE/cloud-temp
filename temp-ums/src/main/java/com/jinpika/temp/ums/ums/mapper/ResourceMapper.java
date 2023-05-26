package com.jinpika.temp.ums.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.temp.ums.ums.dto.ResourceDto;
import com.jinpika.temp.ums.ums.model.Resource;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface ResourceMapper extends BaseMapper<Resource> {
    /**
     * 根据分类获取资源
     *
     * @return
     */
    Page<ResourceDto> getResourceList(Integer categoryId, String keyword, Page page);
}
