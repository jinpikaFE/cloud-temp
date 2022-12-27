package com.jinpika.temp.coupon.sms.model;

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
 * 首页轮播广告
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("sms_home_adv")
@ApiModel(value = "SmsHomeAdv对象", description = "首页轮播广告")
public class SmsHomeAdv implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("图片地址")
    private String pic;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("状态")
    private Boolean status;

    @ApiModelProperty("点击数")
    private Integer clickCount;

    @ApiModelProperty("广告详情连接地址")
    private String url;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("发布者")
    private Long publisherId;

    @ApiModelProperty("审核者")
    private Long authId;


}
