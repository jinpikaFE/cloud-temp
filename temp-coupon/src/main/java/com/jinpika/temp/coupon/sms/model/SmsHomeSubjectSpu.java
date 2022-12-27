package com.jinpika.temp.coupon.sms.model;

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
 * 专题商品
 * </p>
 *
 * @author macro
 * @since 2022-12-27
 */
@Getter
@Setter
@TableName("sms_home_subject_spu")
@ApiModel(value = "SmsHomeSubjectSpu对象", description = "专题商品")
public class SmsHomeSubjectSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("专题名字")
    private String name;

    @ApiModelProperty("专题id")
    private Long subjectId;

    @ApiModelProperty("spu_id")
    private Long spuId;

    @ApiModelProperty("排序")
    private Integer sort;


}
