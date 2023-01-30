package com.jinpika.temp.thirdparty.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SmsTemplateEnum {
    /**
     * 短信登录
     */
    LOGIN("1437207", "短信登录模板");

    private final String TemplateID;
    private final String TemplateDesc;
}

