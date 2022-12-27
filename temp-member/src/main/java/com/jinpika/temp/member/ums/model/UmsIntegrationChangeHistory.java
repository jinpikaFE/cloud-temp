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
 * 积分变化历史记录
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_integration_change_history")
@ApiModel(value = "UmsIntegrationChangeHistory对象", description = "积分变化历史记录")
public class UmsIntegrationChangeHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("member_id")
    private Long memberId;

    @ApiModelProperty("create_time")
    private Date createTime;

    @ApiModelProperty("变化的值")
    private Integer changeCount;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("来源[0->购物；1->管理员修改;2->活动]")
    private Integer sourceTyoe;


}
