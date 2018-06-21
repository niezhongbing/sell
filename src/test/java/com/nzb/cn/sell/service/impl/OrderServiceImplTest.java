package com.nzb.cn.sell.service.impl;

import com.nzb.cn.sell.dto.OrderDTO;
import com.nzb.cn.sell.entity.dbPojo.OrderDetail;
import com.nzb.cn.sell.entity.dbPojo.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;


    private final String BUYER_OPENID = "1101110";

    private final String ORDER_ID = "12345678";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddress("幕课网");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
    }

    @Test
    public void findOne() {
        OrderDTO one = orderService.findOne(ORDER_ID);
        log.info("OrderServiceImplTest findOne : {}", one);
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> list = orderService.findList(BUYER_OPENID, request);
        log.info("OrderServiceImplTest findList : {}", list.getContent());

    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        log.info("OrderServiceImplTest result : {}", result.getOrderDetailList());
    }

    @Test
    public void findById(){
        OrderMaster orderMaster = orderService.selectByPrimaryKey("1234567");

        log.info("ProductInfoRepositoryTest orderMaster: {}" ,orderMaster);
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO finish = orderService.finish(orderDTO);
        log.info("ProductInfoRepositoryTest finish {}",finish);

    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO finish = orderService.paid(orderDTO);
        log.info("ProductInfoRepositoryTest paid {}",finish);
    }

    @Test
    public void findList1() {
    }
}