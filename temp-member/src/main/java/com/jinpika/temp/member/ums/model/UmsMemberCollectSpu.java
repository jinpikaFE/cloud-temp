package com.jinpika.temp.member.ums.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 会员收藏的商品
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_member_collect_spu")
@ApiModel(value = "UmsMemberCollectSpu对象", description = "会员收藏的商品")
public class UmsMemberCollectSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("会员id")
    private Long memberId;

    @ApiModelProperty("spu_id")
    private Long spuId;

    @ApiModelProperty("spu_name")
    private String spuName;

    @ApiModelProperty("spu_img")
    private String spuImg;

    @ApiModelProperty("create_time")
    private Date createTime;


}
