package com.macro.mall.tiny.modules.pms.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品属性 前端控制器
 * </p>
 *
 * @author macro
 * @since 2022-12-26
 */
@RestController
@RequestMapping("/pms/pmsAttr")
public class PmsAttrController {
    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String treeList() {
        return "test";
    }
}

