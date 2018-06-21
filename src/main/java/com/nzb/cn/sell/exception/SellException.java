package com.nzb.cn.sell.exception;

import com.nzb.cn.sell.enums.ResultEnum;
import lombok.Data;

@Data
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code ,String message) {
        super(message);
        this.code = code;
    }

}
