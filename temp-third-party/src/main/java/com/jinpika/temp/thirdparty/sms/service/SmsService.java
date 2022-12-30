package com.jinpika.temp.thirdparty.sms.service;

import com.jinpika.temp.thirdparty.sms.dto.SmsResult;

public interface SmsService {
    SmsResult sendSms(String phone);
}

