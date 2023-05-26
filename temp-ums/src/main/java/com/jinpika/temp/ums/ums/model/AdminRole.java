package com.jinpika.temp.ums.ums.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 管理员用户角色关联关系表
 * </p>
 *
 * @author jinpika
 * @since 2023-05-26
 */
@Getter
@Setter
@TableName("admin_role")
@ApiModel(value = "AdminRole对象", description = "管理员用户角色关联关系表")
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer roleId;

    private Date createdAt;

    private Date updatedAt;

    @TableLogic
    private Integer deleted;
}
