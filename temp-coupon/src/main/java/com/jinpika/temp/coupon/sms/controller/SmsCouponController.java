package com.jinpika.temp.coupon.sms.controller;


import com.jinpika.common.utils.R;
import com.jinpika.temp.coupon.sms.model.SmsCoupon;
import com.jinpika.temp.coupon.sms.service.SmsCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@RestController
@RequestMapping("/sms/smsCoupon")
public class SmsCouponController {
    @Autowired
    private SmsCouponService smsCouponService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public R list() {
        List<SmsCoupon> res = smsCouponService.list();
        return R.ok().setData(res);
    }
}

