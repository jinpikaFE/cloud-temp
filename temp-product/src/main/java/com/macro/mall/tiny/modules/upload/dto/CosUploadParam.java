package com.macro.mall.tiny.modules.upload.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CosUploadParam {
    @ApiModelProperty("文件")
    private MultipartFile file;
}
