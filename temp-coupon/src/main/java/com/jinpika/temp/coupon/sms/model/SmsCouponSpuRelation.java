package com.jinpika.temp.coupon.sms.model;

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
 * 优惠券与产品关联
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("sms_coupon_spu_relation")
@ApiModel(value = "SmsCouponSpuRelation对象", description = "优惠券与产品关联")
public class SmsCouponSpuRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("优惠券id")
    private Long couponId;

    @ApiModelProperty("spu_id")
    private Long spuId;

    @ApiModelProperty("spu_name")
    private String spuName;


}
