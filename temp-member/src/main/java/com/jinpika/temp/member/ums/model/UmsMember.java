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
 * 会员
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_member")
@ApiModel(value = "UmsMember对象", description = "会员")
public class UmsMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("会员等级id")
    private Long levelId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("头像")
    private String header;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("生日")
    private Date birth;

    @ApiModelProperty("所在城市")
    private String city;

    @ApiModelProperty("职业")
    private String job;

    @ApiModelProperty("个性签名")
    private String sign;

    @ApiModelProperty("用户来源")
    private Integer sourceType;

    @ApiModelProperty("积分")
    private Integer integration;

    @ApiModelProperty("成长值")
    private Integer growth;

    @ApiModelProperty("启用状态")
    private Integer status;

    @ApiModelProperty("注册时间")
    private Date createTime;

    @ApiModelProperty("社交账号ID")
    private String socialUid;

    @ApiModelProperty("社交账号Token")
    private String accessToken;

    @ApiModelProperty("社交账号Token过期时间")
    private String expiresIn;


}
