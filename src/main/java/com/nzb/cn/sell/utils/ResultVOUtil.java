package com.nzb.cn.sell.utils;

import com.nzb.cn.sell.entity.voPojo.ResultVO;

/**
 * Created by 廖师兄
 * 2017-05-15 00:22
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO(0,"成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO(code,msg);
        return resultVO;
    }
}
