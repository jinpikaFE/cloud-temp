package com.jinpika.temp.ums.ums.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Getter
@Setter
@ApiModel(value = "Resource对象", description = "资源表")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("资源URL")
    private String url;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("资源分类ID")
    private Long categoryId;

    private Date createdAt;

    private Date updatedAt;

    @TableLogic
    private Integer deleted;
}
