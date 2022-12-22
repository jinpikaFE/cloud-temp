package io.admin.modules.upload.service;

import io.admin.modules.upload.dto.CosCallbackResult;
import org.springframework.web.multipart.MultipartFile;

public interface CosService {
    /**
     * cos上传对象
     */
    CosCallbackResult upload(MultipartFile file);
}
