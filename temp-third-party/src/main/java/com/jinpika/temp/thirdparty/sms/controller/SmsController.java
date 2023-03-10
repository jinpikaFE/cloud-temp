package com.jinpika.temp.thirdparty.sms.controller;

import com.jinpika.common.service.RedisService;
import com.jinpika.common.utils.R;
import com.jinpika.temp.thirdparty.sms.dto.SmsParams;
import com.jinpika.temp.thirdparty.sms.dto.SmsResult;
import com.jinpika.temp.thirdparty.sms.service.SmsService;
import com.jinpika.temp.thirdparty.upload.controller.CosController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "SmsController")
@Tag(name = "SmsController", description = "Cos管理")
@RequestMapping("/sms")
public class SmsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CosController.class);
    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisService redisService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.sms}")
    private String REDIS_KEY_MAIN;

    /**
     * 将当前时间与code一起存储
     * 60s调用限制60s内再次调用返回错误信息
     * 60s以后再次调用，需要删除之前存储的phone-code
     * code过期时间 5分钟
     */
    @ApiOperation(value = "sms发送短信")
    @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
    @ResponseBody
    public R sendSms(@Validated @RequestBody SmsParams smsParams) {
        String key = new StringBuilder()
                .append(REDIS_DATABASE)
                .append(":")
                .append(REDIS_KEY_MAIN)
                .append(":")
                .append(smsParams.getType())
                .append(":")
                .append(smsParams.getPhone())
                .toString();

        String redisCode = (String) redisService.get(key);
        // 如果不为空，返回错误信息
        if (null != redisCode && redisCode.length() > 0) {
            long CuuTime = Long.parseLong(redisCode.split("_")[1]);
            if ((System.currentTimeMillis() - CuuTime) < 60 * 1000) { // 60s
                return R.error("再次发送时间小于60s");
            }
        }

        String smsExpire = "5";
        SmsResult result = smsService.sendSms(smsParams.getPhone(), smsExpire);

        // 时间5分钟取秒
        redisService.set(key, result.getVerifyCodes() + "_" + System.currentTimeMillis(), new Integer(smsExpire) * 60);

        result.setVerifyCodes(null);
        if (result.getCode().equals("Ok")) {
            return R.ok().setData(result);
        }
        return R.error("短信发送失败").setData(result);
    }
}
