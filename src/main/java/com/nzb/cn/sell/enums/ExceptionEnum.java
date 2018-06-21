package com.nzb.cn.sell.enums;

public enum ExceptionEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    ;
    private Integer code;

    private String message;

    ExceptionEnum(Integer code ,String message){
        this.code = code;
        this.message = message;
    }
}
