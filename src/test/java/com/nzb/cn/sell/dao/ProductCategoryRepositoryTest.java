package com.nzb.cn.sell.dao;

import com.nzb.cn.sell.entity.dbPojo.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {

    @Test
    public void findOneTest(){
        //ProductCategory productCategory = product.findById(1).get();
        List<ProductCategory> productAll = product.findAll();
        log.error(productAll.toString());
        log.info(productAll.toString());
    }

    @Autowired
    private ProductCategoryRepository product;

    @Test
    //@Transactional
    public void saveTest(){
        ProductCategory pc = new ProductCategory("张三",1);
        ProductCategory result = product.save(pc);
    }

    @Test
    public void updateTest(){
        ProductCategory pc = product.findOne(7);
        pc.setCategoryType(6);

        product.save(pc);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<ProductCategory> byCategoryTypeIn = product.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,byCategoryTypeIn.size());
    }

}