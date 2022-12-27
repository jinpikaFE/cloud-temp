package com.jinpika.temp.coupon.sms.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 优惠券信息
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("sms_coupon")
@ApiModel(value = "SmsCoupon对象", description = "优惠券信息")
public class SmsCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]")
    private Boolean couponType;

    @ApiModelProperty("优惠券图片")
    private String couponImg;

    @ApiModelProperty("优惠卷名字")
    private String couponName;

    @ApiModelProperty("数量")
    private Integer num;

    @ApiModelProperty("金额")
    private BigDecimal amount;

    @ApiModelProperty("每人限领张数")
    private Integer perLimit;

    @ApiModelProperty("使用门槛")
    private BigDecimal minPoint;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("使用类型[0->全场通用；1->指定分类；2->指定商品]")
    private Boolean useType;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("发行数量")
    private Integer publishCount;

    @ApiModelProperty("已使用数量")
    private Integer useCount;

    @ApiModelProperty("领取数量")
    private Integer receiveCount;

    @ApiModelProperty("可以领取的开始日期")
    private Date enableStartTime;

    @ApiModelProperty("可以领取的结束日期")
    private Date enableEndTime;

    @ApiModelProperty("优惠码")
    private String code;

    @ApiModelProperty("可以领取的会员等级[0->不限等级，其他-对应等级]")
    private Boolean memberLevel;

    @ApiModelProperty("发布状态[0-未发布，1-已发布]")
    private Boolean publish;


}
