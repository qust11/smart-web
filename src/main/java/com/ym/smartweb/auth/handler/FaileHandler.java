package com.ym.smartweb.auth.handler;


import com.ym.smartweb.pojo.CommonResponse;
import com.ym.smartweb.util.ResponseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author qushutao
 * @since 2025/9/13 12:02
 **/
@Component
public class FaileHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResponseUtil.response(response, CommonResponse.error("登录失败"));
    }
}
