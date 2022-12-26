package com.jinpika.temp.product.modules.pms.controller;


import com.jinpika.temp.product.common.api.CommonResult;
import com.jinpika.temp.product.modules.pms.model.PmsAttr;
import com.jinpika.temp.product.modules.pms.service.PmsAttrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private PmsAttrService pmsAttrService;

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsAttr>> treeList() {
        List<PmsAttr> result = pmsAttrService.list();
        return CommonResult.success(result);
    }
}

