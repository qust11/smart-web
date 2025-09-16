package com.ym.smartweb.auth.handler;


import com.ym.smartweb.pojo.CommonResponse;
import com.ym.smartweb.util.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author qushutao
 * @since 2025/9/15 16:44
 **/
@Component
public class EntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtil.response(response, CommonResponse.error(101,"未授权"));
    }
}
