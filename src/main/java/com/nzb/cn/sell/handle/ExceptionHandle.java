package com.nzb.cn.sell.handle;

import com.nzb.cn.sell.entity.voPojo.ResultVO;
import com.nzb.cn.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler
    @ResponseBody
    public ResultVO handle(Exception e){
        if(e instanceof SellException){
            SellException sell = (SellException) e;
            return  new ResultVO(sell.getCode(),sell.getMessage());
        }else{
            log.error("【系统异常】:{}",e);
            return new ResultVO(-1,"未知错误");
        }

    }
}
