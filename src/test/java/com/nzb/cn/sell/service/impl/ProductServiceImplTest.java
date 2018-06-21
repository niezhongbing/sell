package com.nzb.cn.sell.service.impl;

import com.nzb.cn.sell.entity.dbPojo.ProductInfo;
import com.nzb.cn.sell.enums.ProductStatusEnum;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        log.info("productInfo: {}" ,  productInfo);

    }

    @Test
    public void findUpAll()  {
        List<ProductInfo> productInfoList = productService.findUpAll();
        //Assert.assertNotEquals(0, productInfoList.size());
        log.info("productInfoList:{}" ,  productInfoList);
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        log.info("productInfoList: {}" , productInfoPage.getContent());
//        System.out.println(productInfoPage.getTotalElements());
       // Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1231123");
        productInfo.setProductName("葱油饼");
        productInfo.setProductPrice(new BigDecimal(3.5));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("很好吃的饼");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

}