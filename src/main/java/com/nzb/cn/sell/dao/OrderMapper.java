package com.nzb.cn.sell.dao;

import com.nzb.cn.sell.entity.dbPojo.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


//Repository
@Mapper
public interface OrderMapper {
    OrderMaster selectByPrimaryKey(String orderId);

    Integer deleteByPrimaryKey(String orderId);
}
