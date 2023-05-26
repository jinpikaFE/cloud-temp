package com.jinpika.temp.ums.ums.controller;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

