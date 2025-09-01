package com.ym.smartweb.filer;


import com.ym.smartweb.entity.User;
import com.ym.smartweb.holder.UserContextHolder;
import jakarta.servlet.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author qushutao
 * @since 2025/8/31 10:09
 **/
@Component("authenticationFilter")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 从servletRequest中获取token
        // 并从token中获取用户信息
        UserContextHolder.setUser(new User("admin", 18, "admin"));
        filterChain.doFilter(servletRequest, servletResponse);
        UserContextHolder.clear();
    }
}
