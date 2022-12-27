package com.jinpika.temp.member.ums.controller;


import com.jinpika.common.utils.R;
import com.jinpika.temp.member.feign.CouponFeignService;
import com.jinpika.temp.member.ums.model.UmsMember;
import com.jinpika.temp.member.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    private CouponFeignService couponFeignService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list() {
        List<UmsMember> results = umsMemberService.list();
        return R.ok().setData(results);
    }

    @RequestMapping(value = "/coupon_list", method = RequestMethod.GET)
    @ResponseBody
    public R feignCouponList() {
        R results = couponFeignService.membercoupons();
        return R.ok().setData(results);
    }

}

