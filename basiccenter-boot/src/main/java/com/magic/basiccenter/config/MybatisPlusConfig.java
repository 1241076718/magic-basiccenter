package com.magic.basiccenter.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @description: MybatisPlus分页插件配置
 * @author: yangquan
 * @create: 2020-03-16
 */
//@Configuration
//@Component
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    @Qualifier("RolePaginationInterceptor")
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //最大条数
        paginationInterceptor.setLimit(3);
        return paginationInterceptor;
    }
}