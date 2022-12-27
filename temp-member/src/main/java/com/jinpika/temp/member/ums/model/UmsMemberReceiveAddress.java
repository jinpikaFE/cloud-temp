package com.jinpika.temp.member.ums.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 会员收货地址
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_member_receive_address")
@ApiModel(value = "UmsMemberReceiveAddress对象", description = "会员收货地址")
public class UmsMemberReceiveAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("收货人姓名")
    private String name;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("邮政编码")
    private String postCode;

    @ApiModelProperty("省份/直辖市")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("区")
    private String region;

    @ApiModelProperty("详细地址(街道)")
    private String detailAddress;

    @ApiModelProperty("省市区代码")
    private String areacode;

    @ApiModelProperty("是否默认")
    private Boolean defaultStatus;


}
