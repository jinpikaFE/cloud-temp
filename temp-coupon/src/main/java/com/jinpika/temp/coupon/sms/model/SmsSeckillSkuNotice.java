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
 * 秒杀商品通知订阅
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("sms_seckill_sku_notice")
@ApiModel(value = "SmsSeckillSkuNotice对象", description = "秒杀商品通知订阅")
public class SmsSeckillSkuNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("sku_id")
    private Long skuId;

    @ApiModelProperty("活动场次id")
    private Long sessionId;

    @ApiModelProperty("订阅时间")
    private Date subcribeTime;

    @ApiModelProperty("发送时间")
    private Date sendTime;

    @ApiModelProperty("通知方式[0-短信，1-邮件]")
    private Boolean noticeType;


}
