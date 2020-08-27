
package com.magic.basiccenter.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author ：goupc1@belink.com
 * @date ：Created in 2020/8/620 9:54
 * @description：   基础中心启动类
 * @modified By：
 * @version: $1.0.0
 */

@Configuration
public class MessageSourceConfigure {

    @Bean
    @Qualifier("validateMessageSource")
    public MessageSource validateMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setBasename("classpath:i18n/ValidationMessages");
        return ms;
    }

}