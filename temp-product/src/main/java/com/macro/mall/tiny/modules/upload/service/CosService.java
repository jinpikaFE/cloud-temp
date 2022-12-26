package com.macro.mall.tiny.modules.upload.service;

import com.macro.mall.tiny.modules.upload.dto.CosCallbackResult;
import org.springframework.web.multipart.MultipartFile;

public interface CosService {
    /**
     * cos上传对象
     */
    CosCallbackResult upload(MultipartFile file);
}
