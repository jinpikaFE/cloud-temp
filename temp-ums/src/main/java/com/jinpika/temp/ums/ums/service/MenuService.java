package com.jinpika.temp.ums.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jinpika.temp.ums.ums.dto.MenuNode;
import com.jinpika.temp.ums.ums.model.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
public interface MenuService extends IService<Menu> {
    /**
     * 树形结构返回所有菜单列表
     */
    List<MenuNode> treeList();
}
