package com.jinpika.temp.ums.ums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jinpika.temp.ums.ums.model.ResourceCategory;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 资源分类表 服务类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface ResourceCategoryService extends IService<ResourceCategory> {
    /**
     * 分页获取管理员用户列表
     *
     * @param keyword
     * @param pageSzie
     * @param pageNum
     * @return
     */
    Page<ResourceCategory> list(String keyword, Integer pageSzie, Integer pageNum);

    /**
     * 删除资源分类
     *
     * @param id
     * @param resourceCategory
     * @return
     */
    @Transactional
    Boolean delete(Long id, ResourceCategory resourceCategory);
}
