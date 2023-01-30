package com.jinpika.temp.thirdparty.sms.service.impl;

import com.jinpika.temp.thirdparty.common.utils.VerifyCodeUntil;
import com.jinpika.temp.thirdparty.enums.SmsTemplateEnum;
import com.jinpika.temp.thirdparty.sms.dto.SmsResult;
import com.jinpika.temp.thirdparty.sms.service.SmsService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SmsServiceImpl implements SmsService {
    @Value("${tencentyun.sms.region}")
    private String TENCENTYUN_COS_REGION;
    @Value("${tencentyun.secretId}")
    private String TENCENTYUN_SECRETID;
    @Value("${tencentyun.secretKey}")
    private String TENCENTYUN_SECRETKEY;
    @Value("${tencentyun.sms.smsAppId}")
    private String TENCENTYUN_SMS_APPID;
    @Value("${tencentyun.sms.signName}")
    private String TENCENTYUN_SMS_SIGN_NAME;

    @Override
    public SmsResult sendSms(String phone, String expire) {
        /* 必要步骤：
         * 实例化一个认证对象，入参需要传入腾讯云账户密钥对secretId，secretKey。
         * 这里采用的是从环境变量读取的方式，需要在环境变量中先设置这两个值。
         * 你也可以直接在代码中写死密钥对，但是小心不要将代码复制、上传或者分享给他人，
         * 以免泄露密钥对危及你的财产安全。
         * CAM密匙查询: https://console.cloud.tencent.com/cam/capi*/
        Credential cred = new Credential(TENCENTYUN_SECRETID, TENCENTYUN_SECRETKEY);
        SendSmsRequest req = new SendSmsRequest();
        SmsClient client = new SmsClient(cred, TENCENTYUN_COS_REGION);

        /* 填充请求参数,这里request对象的成员变量即对应接口的入参
         * 你可以通过官网接口文档或跳转到request对象的定义处查看请求参数的定义
         * 基本类型的设置:
         * 帮助链接：
         * sms helper: https://cloud.tencent.com/document/product/382/3773 */
        req.setSmsSdkAppId(TENCENTYUN_SMS_APPID);

        /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名，签名信息可登录 [短信控制台] 查看 */
        req.setSignName(TENCENTYUN_SMS_SIGN_NAME);

        req.setTemplateId(SmsTemplateEnum.LOGIN.getTemplateID());
        req.setPhoneNumberSet(new String[]{"+86" + phone});
        /* 模板参数: 若无模板参数，则设置为空 */
        // 该模板第一参数验证码，第二参数需要传时间 5分钟
        String verifyCodes = VerifyCodeUntil.getVerifyCodes(6);
        String[] templateParamSet = {verifyCodes, expire};
        req.setTemplateParamSet(templateParamSet);
        /* 通过 client 对象调用 SendSms 方法发起请求。注意请求方法名与请求对象是对应的
         * 返回的 res 是一个 SendSmsResponse 类的实例，与请求对象对应 */
        SendSmsResponse res = null;
        SmsResult smsResult = new SmsResult();
        // 默认ok
        smsResult.setCode("Ok");
        smsResult.setPhoneNumber(phone);
        smsResult.setVerifyCodes(verifyCodes);
        try {
            res = client.SendSms(req);
        } catch (TencentCloudSDKException ex) {
            ex.printStackTrace();
            return smsResult;
        }

        smsResult.setRequestId(res.getRequestId());
        // 输出json格式的字符串回包
        System.out.println(SendSmsResponse.toJsonString(res));
        for (int i = 0; i < res.getSendStatusSet().length; i++) {
            if (!Objects.equals(res.getSendStatusSet()[i].getCode(), "Ok")) {
                smsResult.setCode(res.getSendStatusSet()[i].getCode());
                smsResult.setMessage(res.getSendStatusSet()[i].getMessage());
                smsResult.setPhoneNumber(res.getSendStatusSet()[i].getPhoneNumber());
                // 打日志
                //  res.getSendStatusSet()[i].getCode(),res.getSendStatusSet()[i].getMessage()
                return smsResult;
            }
        }
        return smsResult;
    }
}
