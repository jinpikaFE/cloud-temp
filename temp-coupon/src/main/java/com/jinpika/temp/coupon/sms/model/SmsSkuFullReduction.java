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

/**
 * <p>
 * 商品满减信息
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("sms_sku_full_reduction")
@ApiModel(value = "SmsSkuFullReduction对象", description = "商品满减信息")
public class SmsSkuFullReduction implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("spu_id")
    private Long skuId;

    @ApiModelProperty("满多少")
    private BigDecimal fullPrice;

    @ApiModelProperty("减多少")
    private BigDecimal reducePrice;

    @ApiModelProperty("是否参与其他优惠")
    private Boolean addOther;


}
