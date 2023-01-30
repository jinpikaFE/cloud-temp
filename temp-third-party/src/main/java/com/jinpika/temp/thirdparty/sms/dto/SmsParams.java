package com.jinpika.temp.thirdparty.sms.dto;

import com.jinpika.temp.thirdparty.enums.SmsTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class SmsParams {
    @NotEmpty
    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("类型")
    private SmsTypeEnum type = SmsTypeEnum.COMMON;
}
