package com.nzb.cn.sell.dao;

import com.nzb.cn.sell.entity.dbPojo.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by 廖师兄
 * 2017-06-11 17:24
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

   // Page<OrderMaster> findByBuyerrepository(String buyerOpenid, Pageable pageable);


    @Query(value = "select * from order_master where order_id = :orderId",nativeQuery=true)
    OrderMaster selectByPrimaryKey(@Param("orderId") String orderId);


}
