package com.ym.smartweb.config;


import com.ym.smartweb.auth.handler.EntryPoint;
import com.ym.smartweb.auth.handler.FailHandler;
import com.ym.smartweb.auth.handler.SuccessHandler;
import com.ym.smartweb.encoder.CustomPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
                                           FailHandler failHandler, EntryPoint entryPoint,
                                           CustomPasswordEncoder customPasswordEncoder) throws Exception {
        http
                .formLogin(c -> c.loginProcessingUrl("/login")
                        .successHandler(successHandler)
                        .failureHandler(failHandler))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(c -> c.anyRequest().authenticated())
                .exceptionHandling(c -> c.authenticationEntryPoint(entryPoint));
        return http.build();
    }
    // 配置认证提供者使用自定义密码编码器
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
                                                            CustomPasswordEncoder customPasswordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
        authProvider.setPasswordEncoder(customPasswordEncoder);
        return authProvider;
    }
}
