package com.jinpika.temp.ums.ums.controller;


import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.ums.ums.model.Resource;
import com.jinpika.temp.ums.ums.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Api(tags = "ResourceController")
@Tag(name = "ResourceController", description = "资源管理")
@RestController
@RequestMapping("/ums/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @ApiOperation("添加资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CommonResult<Object>> create(@RequestBody Resource resource) {
        boolean success = resourceService.save(resource);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }
}

