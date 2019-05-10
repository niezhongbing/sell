package com.nzb.cn.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 加载yaml配置文件的方法
 * Created by sun on 2017-1-15.
 * spring-boot更新到1.5.2版本后locations属性无法使用
 * @PropertySource注解只可以加载proprties文件,无法加载yaml文件
 * 故现在把数据放到application.yml文件中,spring-boot启动时会加载
 */
@Data
@Component
//@ConfigurationProperties(locations = {"classpath:config/myProps.yml"},prefix = "myProps")
@ConfigurationProperties(prefix = "ftp")
public class YmlConfig {
    private String ftpAddress;
    // 端口号
    private int ftpPort;
    // 用户名
    private String ftpName;
    // 密码
    private String ftpPassWord;
    // 图片路径
    private String ftpBasePath;
}
