package com.jinpika.temp.product.pms.model;

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
 * 商品评价回复关系
 * </p>
 *
 * @author macro
 * @since 2022-12-23
 */
@Getter
@Setter
@TableName("pms_comment_replay")
@ApiModel(value = "PmsCommentReplay对象", description = "商品评价回复关系")
public class PmsCommentReplay implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("评论id")
    private Long commentId;

    @ApiModelProperty("回复id")
    private Long replyId;


}
