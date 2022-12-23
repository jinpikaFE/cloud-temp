package com.jinpika.common.enume;

public enum SubmitOrderStatusEnum {
    SUCCESS(0, "正常状态"),
    CREATING(1, "在创建中"),
    STOCK(2, "库存不足"),
    CHECKPRICE(3, "验价失败"),
    TOKENERROR(4, "已取消"),
    SERVICING(5, "售后中"),
    ;

    private Integer code;
    private String msg;

    SubmitOrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
