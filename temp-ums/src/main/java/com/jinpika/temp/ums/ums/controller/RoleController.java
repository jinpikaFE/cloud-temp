package com.jinpika.temp.ums.ums.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.common.api.CommonPage;
import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.ums.ums.dto.RoleDto;
import com.jinpika.temp.ums.ums.model.Role;
import com.jinpika.temp.ums.ums.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色列表 前端控制器
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Api(tags = "RoleController")
@Tag(name = "RoleController", description = "角色管理")
@RestController
@RequestMapping("/ums/role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @ApiOperation("添加角色")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CommonResult<Object>> create(@RequestBody RoleDto roleDto) {
        RoleDto results = roleService.create(roleDto);
        return results != null ? CommonResult.success(results) : CommonResult.failed();
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResult<Object>> delete(@PathVariable Long id) {
        Role role = roleService.getById(id);
        if (role == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        boolean success = roleService.delete(id, role);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("更新角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommonResult<Object>> update(@PathVariable Integer id, @RequestBody RoleDto roleDto) {
        Role role = roleService.getById(id);
        if (role == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        boolean success = roleService.update(id, roleDto);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("分页角色")
    @GetMapping("/list")
    public ResponseEntity<CommonResult<CommonPage<Role>>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Role> list = roleService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }
}

