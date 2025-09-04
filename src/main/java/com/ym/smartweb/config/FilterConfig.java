package com.ym.smartweb.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @author qushutao
 * @since 2025/8/31 10:05
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> delegatingFilterProxyRegistration(){
        FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<>();
        registration.setFilter(new DelegatingFilterProxy());
        registration.addInitParameter("targetBeanName", "authenticationFilter");
        registration.setName("delegatingFilterProxy");
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;

    }

}
