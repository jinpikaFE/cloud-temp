package com.jinpika.temp.member.ums.model;

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
 * 会员登录记录
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_member_login_log")
@ApiModel(value = "UmsMemberLoginLog对象", description = "会员登录记录")
public class UmsMemberLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("ip")
    private String ip;

    @ApiModelProperty("city")
    private String city;

    @ApiModelProperty("登录类型[1-web，2-app]")
    private Boolean loginType;


}
