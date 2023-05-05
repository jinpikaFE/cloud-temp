package com.jinpika.temp.ums.ums.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jinpika.common.api.CommonPage;
import com.jinpika.common.api.CommonResult;
import com.jinpika.temp.ums.ums.model.User;
import com.jinpika.temp.ums.ums.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author macro
 * @since 2023-05-04
 */
@RestController
@RequestMapping("/ums/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation("根据用户名或邮箱分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CommonResult<CommonPage<User>>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<User> userList = userService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }
}

