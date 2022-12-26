package com.jinpika.temp.product.modules.upload.service;

import com.jinpika.temp.product.modules.upload.dto.CosCallbackResult;
import org.springframework.web.multipart.MultipartFile;

public interface CosService {
    /**
     * cos上传对象
     */
    CosCallbackResult upload(MultipartFile file);
}
