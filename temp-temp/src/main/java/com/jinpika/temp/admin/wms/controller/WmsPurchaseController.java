package com.jinpika.temp.admin.wms.controller;


import com.jinpika.common.utils.R;
import com.jinpika.temp.admin.wms.model.WmsPurchase;
import com.jinpika.temp.admin.wms.service.WmsPurchaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 采购信息 前端控制器
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@RestController
@RequestMapping("/wms/wmsPurchase")
public class WmsPurchaseController {
    @Autowired
    private WmsPurchaseService wmsPurchaseService;

    @ApiOperation("返回列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R treeList() {
        List<WmsPurchase> result = wmsPurchaseService.list();
        return R.ok("test").put("page", "page_info").setData(result);
    }
}

