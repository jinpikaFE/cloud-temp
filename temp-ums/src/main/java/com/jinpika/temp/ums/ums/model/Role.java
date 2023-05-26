package com.jinpika.temp.ums.ums.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色列表
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Getter
@Setter
@ApiModel(value = "Role对象", description = "角色列表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String roleName;

    private Date createdAt;

    private Date updatedAt;

    @TableLogic
    private Integer deleted;
}
