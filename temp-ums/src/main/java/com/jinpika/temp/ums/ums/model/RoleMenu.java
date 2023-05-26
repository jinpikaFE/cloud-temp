package com.jinpika.temp.ums.ums.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色菜单关系表
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Getter
@Setter
@TableName("role_menu")
@ApiModel(value = "RoleMenu对象", description = "角色菜单关系表")
public class RoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("菜单ID")
    private Long menuId;

    private Date createdAt;

    private Date updatedAt;

    @TableLogic
    private Integer deleted;
}
