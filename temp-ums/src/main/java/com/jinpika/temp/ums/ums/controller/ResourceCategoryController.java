package com.jinpika.temp.ums.ums.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.common.api.CommonPage;
import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.ums.ums.model.ResourceCategory;
import com.jinpika.temp.ums.ums.service.ResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 资源分类表 前端控制器
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Api(tags = "ResourceCategoryController")
@Tag(name = "ResourceCategoryController", description = "资源分类管理")
@RestController
@RequestMapping("/ums/resourceCategory")
public class ResourceCategoryController {
    @Autowired
    private ResourceCategoryService resourceCategoryService;


    @ApiOperation("添加资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CommonResult<Object>> create(@RequestBody ResourceCategory resourceCategory) {
        boolean success = resourceCategoryService.save(resourceCategory);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("删除资源分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResult<Object>> delete(@PathVariable Long id) {
        ResourceCategory resourceCategory = resourceCategoryService.getById(id);
        if (resourceCategory == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        Boolean success = resourceCategoryService.delete(id, resourceCategory);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("更新资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommonResult<Object>> update(@PathVariable Integer id, @RequestBody ResourceCategory resourceCategory) {
        if (resourceCategoryService.getById(id) == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        resourceCategory.setId(id);
        boolean success = resourceCategoryService.updateById(resourceCategory);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("分页获取资源分类")
    @GetMapping("/list")
    public ResponseEntity<CommonResult<CommonPage<ResourceCategory>>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<ResourceCategory> list = resourceCategoryService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }
}

