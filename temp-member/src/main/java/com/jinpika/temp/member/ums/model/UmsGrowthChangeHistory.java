package com.jinpika.temp.member.ums.model;

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
 * 成长值变化历史记录
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_growth_change_history")
@ApiModel(value = "UmsGrowthChangeHistory对象", description = "成长值变化历史记录")
public class UmsGrowthChangeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("create_time")
    private Date createTime;

    @ApiModelProperty("改变的值（正负计数）")
    private Integer changeCount;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("积分来源[0-购物，1-管理员修改]")
    private Integer sourceType;


}
