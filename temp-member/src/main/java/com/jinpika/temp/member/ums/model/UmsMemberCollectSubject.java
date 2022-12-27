package com.jinpika.temp.member.ums.model;

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
 * 会员收藏的专题活动
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("ums_member_collect_subject")
@ApiModel(value = "UmsMemberCollectSubject对象", description = "会员收藏的专题活动")
public class UmsMemberCollectSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("subject_id")
    private Long subjectId;

    @ApiModelProperty("subject_name")
    private String subjectName;

    @ApiModelProperty("subject_img")
    private String subjectImg;

    @ApiModelProperty("活动url")
    private String subjectUrll;


}
