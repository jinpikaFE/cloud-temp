package com.jinpika.temp.member.ums.controller;


import com.jinpika.common.utils.R;
import com.jinpika.temp.member.feign.CouponFeignService;
import com.jinpika.temp.member.ums.model.UmsMember;
import com.jinpika.temp.member.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 会员 前端控制器
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@RestController
@RequestMapping("/ums/umsMember")
@RefreshScope
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    private CouponFeignService couponFeignService;

    // 使用 Spring 的 @Value 注解来获取配置信息，${} 中对应 Nacos 配置中心配置内容的 key，:后跟默认值。
    // 并且通过 Spring Cloud 原生注解 @RefreshScope 实现配置自动更新。
    @Value("${project.name:567}")
    private String project_name;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list() {
        List<UmsMember> results = umsMemberService.list();
        return R.ok().setData(results).put("project_name", project_name);
    }

    @RequestMapping(value = "/coupon_list", method = RequestMethod.GET)
    @ResponseBody
    public R feignCouponList() {
        R results = couponFeignService.membercoupons();
        return R.ok().setData(results).put("project_name", project_name);
    }

}

