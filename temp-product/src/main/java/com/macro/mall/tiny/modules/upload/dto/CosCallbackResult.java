package com.macro.mall.tiny.modules.upload.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CosCallbackResult {
    @ApiModelProperty("文件名称")
    private String filename;
    @ApiModelProperty("文件url")
    private String url;
    @ApiModelProperty("文件大小")
    private Long size;
    @ApiModelProperty("文件的mimeType")
    private String mimeType;
}
