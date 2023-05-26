package com.jinpika.temp.ums.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.temp.ums.ums.model.Menu;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 获取menu
     *
     * @return
     */
    Page<Menu> getMenuList(String keyword, Page page);
}
