package com.magic.basiccenter.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @description: MybatisPlus分页插件配置
 * @author: jianggq@belink.com
 * @create: 2020-08-20
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //最大条数
        paginationInterceptor.setLimit(100);
        return paginationInterceptor;
    }
}
