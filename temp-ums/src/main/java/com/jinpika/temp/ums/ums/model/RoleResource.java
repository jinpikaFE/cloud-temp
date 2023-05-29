package com.jinpika.temp.ums.ums.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色资源关系表
 * </p>
 *
 * @author jinpika
 * @since 2023-05-29
 */
@Getter
@Setter
@TableName("role_resource")
@ApiModel(value = "RoleResource对象", description = "角色资源关系表")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("资源ID")
    private Long resourceId;

    private Date createdAt;

    private Date updatedAt;
}
