package com.jinpika.temp.ums.ums.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.common.api.CommonPage;
import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.ums.ums.dto.AdminDto;
import com.jinpika.temp.ums.ums.dto.AdminLoginParam;
import com.jinpika.temp.ums.ums.model.Admin;
import com.jinpika.temp.ums.ums.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 管理员用户表 前端控制器
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Api(tags = "AdminController")
@Tag(name = "AdminController", description = "管理员用户管理")
@RestController
@RequestMapping("/ums/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation("添加用户")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CommonResult<Object>> create(@RequestBody AdminDto adminDto) {
        AdminDto results = adminService.create(adminDto);
        return results != null ? CommonResult.success(results) : CommonResult.failed();
    }

    @ApiOperation("更新用户")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CommonResult<Object>> update(@PathVariable Integer id, @RequestBody AdminDto adminDto) {
        Admin admin = adminService.getById(id);
        if (admin == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        boolean success = adminService.update(id, adminDto);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("删除用户")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResult<Object>> delete(@PathVariable Long id) {
        Admin admin = adminService.getById(id);
        if (admin == null) {
            return CommonResult.validateFailed("记录不存在");
        }
        boolean success = adminService.removeById(id);
        return success ? CommonResult.success(null) : CommonResult.failed();
    }

    @ApiOperation("分页用户")
    @GetMapping("/list")
    public ResponseEntity<CommonResult<CommonPage<Admin>>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<Admin> list = adminService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CommonResult> login(@Validated @RequestBody AdminLoginParam adminLoginParam) {
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword());
    }
}

