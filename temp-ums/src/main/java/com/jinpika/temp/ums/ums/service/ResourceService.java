package com.jinpika.temp.ums.ums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinpika.temp.ums.ums.dto.ResourceDto;
import com.jinpika.temp.ums.ums.model.Resource;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface ResourceService extends IService<Resource> {
    /**
     * 分页获取管理员用户列表
     *
     * @param keyword
     * @param pageSzie
     * @param pageNum
     * @return
     */
    Page<ResourceDto> list(Integer categoryId, String keyword, Integer pageSzie, Integer pageNum);
}
