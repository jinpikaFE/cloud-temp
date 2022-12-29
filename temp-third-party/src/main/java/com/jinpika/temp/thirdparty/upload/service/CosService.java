package com.jinpika.temp.thirdparty.upload.service;

import com.jinpika.temp.thirdparty.upload.dto.CosCallbackResult;
import org.springframework.web.multipart.MultipartFile;

public interface CosService {
    /**
     * cos上传对象
     */
    CosCallbackResult upload(MultipartFile file);
}
