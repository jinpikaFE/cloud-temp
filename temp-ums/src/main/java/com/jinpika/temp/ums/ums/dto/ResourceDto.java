package com.jinpika.temp.ums.ums.dto;

import com.jinpika.temp.ums.ums.model.Resource;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ResourceDto extends Resource {
    @ApiModelProperty("资源分类名称")
    private String categoryName;
}
