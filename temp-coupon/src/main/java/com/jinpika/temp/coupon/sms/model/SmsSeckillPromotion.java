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
 * 秒杀活动
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("sms_seckill_promotion")
@ApiModel(value = "SmsSeckillPromotion对象", description = "秒杀活动")
public class SmsSeckillPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("活动标题")
    private String title;

    @ApiModelProperty("开始日期")
    private Date startTime;

    @ApiModelProperty("结束日期")
    private Date endTime;

    @ApiModelProperty("上下线状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("创建人")
    private Long userId;


}
