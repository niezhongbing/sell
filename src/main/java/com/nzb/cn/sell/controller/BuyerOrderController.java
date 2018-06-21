package com.nzb.cn.sell.controller;

import com.nzb.cn.sell.converter.OrderForm2OrderDTOConverter;
import com.nzb.cn.sell.dto.OrderDTO;
import com.nzb.cn.sell.entity.voPojo.ResultVO;
import com.nzb.cn.sell.enums.ResultEnum;
import com.nzb.cn.sell.exception.SellException;
import com.nzb.cn.sell.from.OrderForm;
import com.nzb.cn.sell.service.OrderService;
import com.nzb.cn.sell.utils.ResultVOUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 廖师兄
 * 2017-06-18 23:27
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/junit", method = RequestMethod.POST)
    public ResultVO junitValid(@Valid @RequestBody(required = false) OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return ResultVOUtil.error(101, bindingResult.getFieldError().getDefaultMessage());

        }
        return ResultVOUtil.success();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ApiModelProperty(value = "创建订单1", notes = "创建订单")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单不正确】 参数不正确 orderFrom = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
   
    @RequestMapping("/list")
    @ApiModelProperty(value = "查询订单列表", notes = "查询订单列表")
    public ResultVO<Page<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        return ResultVOUtil.success(orderDTOPage);
    }

    @RequestMapping("/detail")
    @ApiModelProperty(value = "查询订单详情", notes = "查询订单详情")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderid) {
        OrderDTO orderDTO = orderService.findOrderOne(openid, orderid);
        return ResultVOUtil.success(orderDTO);
    }

    @RequestMapping("/cancel")
    @ApiModelProperty(value = "订单取消", notes = "订单取消")
    public ResultVO<OrderDTO> cancel(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderid) {
        orderService.cancelOrder(openid,orderid);
        return ResultVOUtil.success("订单取消成功 orderid = " + orderid);
    }
}
