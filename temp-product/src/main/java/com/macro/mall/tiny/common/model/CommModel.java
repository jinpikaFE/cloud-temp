package com.macro.mall.tiny.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommModel {
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT) // 插入时自动填充
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE) // 更新时自动填充
    private Date updateTime;

    @JsonIgnore
    private Integer deleted;
}
