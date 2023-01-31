package com.jinpika.temp.thirdparty.sms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsResult {
    @ApiModelProperty("手机号")
    private String PhoneNumber;

    @ApiModelProperty("code")
    private String Code;

    @ApiModelProperty("信息")
    private String Message;

    @ApiModelProperty("请求id")
    private String RequestId;

    // 验证码
    @JsonIgnore
    private String verifyCodes;
}
