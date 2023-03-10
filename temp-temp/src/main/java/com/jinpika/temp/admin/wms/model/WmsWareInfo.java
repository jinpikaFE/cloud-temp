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
 * 仓库信息
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("wms_ware_info")
@ApiModel(value = "WmsWareInfo对象", description = "仓库信息")
public class WmsWareInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("仓库名")
    private String name;

    @ApiModelProperty("仓库地址")
    private String address;

    @ApiModelProperty("区域编码")
    private String areacode;


}
