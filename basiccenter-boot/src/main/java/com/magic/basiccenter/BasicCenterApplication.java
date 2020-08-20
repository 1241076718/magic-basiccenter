package com.magic.basiccenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>基础中心-启动类</P>
 *
 * @author zhuzh@belink.com
 * @version 0.0.1
 * @className basicCenterApplication
 * @sine 2020/8/17 9:15
 */

@SpringBootApplication
@ImportResource(locations = {"classpath*:rpc-provider.xml", "classpath*:rpc-consumer.xml"})
@ComponentScan(basePackages = {"com.gift", "com.magic.basiccenter"})
@MapperScan("com.**.**.model.mapper")
@EnableDiscoveryClient
public class BasicCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicCenterApplication.class,args);
    }
}
