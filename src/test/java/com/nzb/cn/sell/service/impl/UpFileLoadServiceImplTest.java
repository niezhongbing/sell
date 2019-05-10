package com.nzb.cn.sell.service.impl;

import com.nzb.cn.sell.service.UpFileLoadService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UpFileLoadServiceImplTest {

    @Autowired
    private UpFileLoadService upFileLoadService;

    private  static final String FILEPATH="/mnt/upload";

    @Test
    public void Test(){
        try {
            upFileLoadService.upLoadImg("F:\\1.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}