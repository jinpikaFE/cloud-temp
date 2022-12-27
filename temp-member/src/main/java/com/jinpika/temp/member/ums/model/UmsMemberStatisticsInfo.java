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
 * 会员统计信息
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_member_statistics_info")
@ApiModel(value = "UmsMemberStatisticsInfo对象", description = "会员统计信息")
public class UmsMemberStatisticsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("会员id")
    private Long memberId;

    @ApiModelProperty("累计消费金额")
    private BigDecimal consumeAmount;

    @ApiModelProperty("累计优惠金额")
    private BigDecimal couponAmount;

    @ApiModelProperty("订单数量")
    private Integer orderCount;

    @ApiModelProperty("优惠券数量")
    private Integer couponCount;

    @ApiModelProperty("评价数")
    private Integer commentCount;

    @ApiModelProperty("退货数量")
    private Integer returnOrderCount;

    @ApiModelProperty("登录次数")
    private Integer loginCount;

    @ApiModelProperty("关注数量")
    private Integer attendCount;

    @ApiModelProperty("粉丝数量")
    private Integer fansCount;

    @ApiModelProperty("收藏的商品数量")
    private Integer collectProductCount;

    @ApiModelProperty("收藏的专题活动数量")
    private Integer collectSubjectCount;

    @ApiModelProperty("收藏的评论数量")
    private Integer collectCommentCount;

    @ApiModelProperty("邀请的朋友数量")
    private Integer inviteFriendCount;


}
