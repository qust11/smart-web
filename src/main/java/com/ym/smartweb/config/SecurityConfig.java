package com.ym.smartweb.config;


import com.ym.smartweb.auth.handler.EntryPoint;
import com.ym.smartweb.auth.handler.FailHandler;
import com.ym.smartweb.auth.handler.SuccessHandler;
import com.ym.smartweb.encoder.CustomPasswordEncoder;
import com.ym.smartweb.filer.SmsAuthenticationFilter;
import com.ym.smartweb.filer.SmsAuthenticationProvider;
import com.ym.smartweb.filer.SmsConfigurer;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author qushutao
 * @since 2025/9/1 19:11
 **/
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           SuccessHandler successHandler,
                                           FailHandler failHandler, EntryPoint entryPoint) throws Exception {
        http
                .formLogin(c -> c.loginProcessingUrl("/login")
                        .successHandler(successHandler)
                        .failureHandler(failHandler))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(c -> c
                        .anyRequest().authenticated())
                .exceptionHandling(c -> c.authenticationEntryPoint(entryPoint));

        SmsConfigurer<HttpSecurity> httpSecuritySmsConfigurer = new SmsConfigurer<>();
        httpSecuritySmsConfigurer.loginProcessingUrl("/smsLogin").failureHandler(failHandler).successHandler(successHandler);
        http.apply(httpSecuritySmsConfigurer);
        http.authenticationProvider(new SmsAuthenticationProvider());
        http.addFilterAfter(httpSecuritySmsConfigurer.getFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
