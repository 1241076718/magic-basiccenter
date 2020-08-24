package com.magic.basiccenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/20 9:54
 * @description：   基础中心启动类
 * @modified By：
 * @version: $1.0.0
 */

@SpringBootApplication
@ImportResource(locations = {"classpath*:rpc-provider.xml", "classpath*:rpc-consumer.xml"})
@ComponentScan(basePackages = {"com.gift", "com.magic.basiccenter"})
@MapperScan("com.**.model.mapper")
@EnableDiscoveryClient
@EnableTransactionManagement
public class BasicCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicCenterApplication.class,args);
    }
}
