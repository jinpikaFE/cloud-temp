package com.jinpika.temp.ums.ums.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.common.api.CommonPage;
import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.ums.ums.dto.ResourceDto;
import com.jinpika.temp.ums.ums.model.Resource;
import com.jinpika.temp.ums.ums.service.ResourceCategoryService;
import com.jinpika.temp.ums.ums.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @ApiOperation("添加资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CommonResult<Object>> create(@RequestBody Resource resource) {
        if (resourceCategoryService.getById(resource.getCategoryId()) == null) {
            return CommonResult.validateFailed("分类不存在");
        }
        boolean success = resourceService.save(resource);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("删除资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResult<Object>> delete(@PathVariable Long id) {
        if (resourceService.getById(id) == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        boolean success = resourceService.removeById(id);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("更新资源")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommonResult<Object>> update(@PathVariable Integer id, @RequestBody Resource resource) {
        if (resourceService.getById(id) == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        resource.setId(id);
        boolean success = resourceService.updateById(resource);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("分页获取资源")
    @GetMapping("/list")
    public ResponseEntity<CommonResult<CommonPage<ResourceDto>>> list(
            @RequestParam(value = "categoryId") Integer categoryId,
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<ResourceDto> list = resourceService.list(categoryId, keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }
}

