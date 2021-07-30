package com.czy.study;

import com.alibaba.fastjson.JSONObject;
import com.czy.study.core.ResponseVo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        /*排除不想要的配置，这里不加载数据源配置（也就是数据库链接配置）*/
//        exclude = {DataSourceAutoConfiguration.class}
        )
@MapperScan("com.czy.study.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
