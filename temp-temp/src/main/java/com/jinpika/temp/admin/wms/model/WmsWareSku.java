package com.jinpika.temp.admin.wms.model;

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
 * 商品库存
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("wms_ware_sku")
@ApiModel(value = "WmsWareSku对象", description = "商品库存")
public class WmsWareSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("sku_id")
    private Long skuId;

    @ApiModelProperty("仓库id")
    private Long wareId;

    @ApiModelProperty("库存数")
    private Integer stock;

    @ApiModelProperty("sku_name")
    private String skuName;

    @ApiModelProperty("锁定库存")
    private Integer stockLocked;


}
