package com.jinpika.temp.ums.ums.controller;


import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.ums.ums.dto.MenuNode;
import com.jinpika.temp.ums.ums.model.Menu;
import com.jinpika.temp.ums.ums.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Api(tags = "MenuController")
@Tag(name = "MenuController", description = "菜单管理")
@RestController
@RequestMapping("/ums/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ApiOperation("添加菜单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CommonResult<Object>> create(@RequestBody Menu menu) {
        boolean success = menuService.save(menu);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("删除菜单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResult<Object>> delete(@PathVariable Long id) {
        if (menuService.getById(id) == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        boolean success = menuService.removeById(id);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("更新菜单")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommonResult<Object>> update(@PathVariable Integer id, @RequestBody Menu menu) {
        menu.setId(id);
        boolean success = menuService.updateById(menu);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("获取所有菜单")
    @GetMapping("/listAll")
    public ResponseEntity<CommonResult<List<Menu>>> list() {
        List<Menu> menuList = menuService.list();
        return CommonResult.success(menuList);
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    public ResponseEntity<CommonResult<List<MenuNode>>> treeList() {
        List<MenuNode> list = menuService.treeList();
        return CommonResult.success(list);
    }
}

