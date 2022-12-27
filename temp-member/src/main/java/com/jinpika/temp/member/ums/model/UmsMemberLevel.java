package com.jinpika.temp.member.ums.model;

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
 * 会员等级
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_member_level")
@ApiModel(value = "UmsMemberLevel对象", description = "会员等级")
public class UmsMemberLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("等级名称")
    private String name;

    @ApiModelProperty("等级需要的成长值")
    private Integer growthPoint;

    @ApiModelProperty("是否为默认等级[0->不是；1->是]")
    private Integer defaultStatus;

    @ApiModelProperty("免运费标准")
    private BigDecimal freeFreightPoint;

    @ApiModelProperty("每次评价获取的成长值")
    private Integer commentGrowthPoint;

    @ApiModelProperty("是否有免邮特权")
    private Integer priviledgeFreeFreight;

    @ApiModelProperty("是否有会员价格特权")
    private Integer priviledgeMemberPrice;

    @ApiModelProperty("是否有生日特权")
    private Integer priviledgeBirthday;

    @ApiModelProperty("备注")
    private String note;


}
