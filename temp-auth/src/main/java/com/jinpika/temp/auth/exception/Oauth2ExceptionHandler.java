package com.jinpika.temp.auth.exception;

import com.jinpika.common.api.CommonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 定义OAuth2异常处理器，用于捕获和处理OAuth2相关的异常
@ControllerAdvice
public class Oauth2ExceptionHandler {
    // 处理OAuth2异常，返回统一格式的响应数据
    @ResponseBody
    @ExceptionHandler(value = OAuth2Exception.class)
    public ResponseEntity<CommonResult<String>> handleOauth2(OAuth2Exception e) {
        return CommonResult.failed(e.getMessage());
    }
}
