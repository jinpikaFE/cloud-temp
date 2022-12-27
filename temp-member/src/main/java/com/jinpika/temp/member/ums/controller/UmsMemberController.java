package com.jinpika.temp.member.ums.controller;


import com.jinpika.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R list() {
        return R.ok();
    }

}

