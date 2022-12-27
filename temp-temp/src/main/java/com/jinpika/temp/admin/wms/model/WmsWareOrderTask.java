package com.jinpika.temp.admin.wms.model;

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
 * 库存工作单
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("wms_ware_order_task")
@ApiModel(value = "WmsWareOrderTask对象", description = "库存工作单")
public class WmsWareOrderTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("order_id")
    private Long orderId;

    @ApiModelProperty("order_sn")
    private String orderSn;

    @ApiModelProperty("收货人")
    private String consignee;

    @ApiModelProperty("收货人电话")
    private String consigneeTel;

    @ApiModelProperty("配送地址")
    private String deliveryAddress;

    @ApiModelProperty("订单备注")
    private String orderComment;

    @ApiModelProperty("付款方式【 1:在线付款 2:货到付款】")
    private Boolean paymentWay;

    @ApiModelProperty("任务状态")
    private Integer taskStatus;

    @ApiModelProperty("订单描述")
    private String orderBody;

    @ApiModelProperty("物流单号")
    private String trackingNo;

    @ApiModelProperty("create_time")
    private Date createTime;

    @ApiModelProperty("仓库id")
    private Long wareId;

    @ApiModelProperty("工作单备注")
    private String taskComment;


}
