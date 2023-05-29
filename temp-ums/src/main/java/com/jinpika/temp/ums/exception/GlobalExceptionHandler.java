package com.jinpika.temp.ums.exception;

import cn.hutool.json.JSONObject;
import com.jinpika.common.api.CommonResult;
import com.jinpika.common.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 各个微服务自行处理异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<CommonResult<JSONObject>> handle(ApiException e) {
        if (e.getErrorCode() != null && e.getMessage() != null) {
            return CommonResult.codeFailed(e.getErrorCode(), e.getMessage());
        }
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    //    运行异常捕捉
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleRuntimeException(RuntimeException e) {
        logger.error("运行异常", e);
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleValidException(MethodArgumentNotValidException e) {
        return getCommonResultResponseEntity(e.getBindingResult());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleValidException(BindException e) {
        return getCommonResultResponseEntity(e.getBindingResult());
    }

    private ResponseEntity<CommonResult<JSONObject>> getCommonResultResponseEntity(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        String message = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(","));
        return CommonResult.validateFailed(message);
    }
}
