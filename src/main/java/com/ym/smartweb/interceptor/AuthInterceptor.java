package com.ym.smartweb.interceptor;


import com.ym.smartweb.auth.handler.AuthHandler;
import com.ym.smartweb.auth.handler.BlackHandler;
import com.ym.smartweb.auth.handler.IdentityHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author qushutao
 * @since 2025/8/31 9:52
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthHandler authHandler;
    @Autowired
    private IdentityHandler identityHandler;
    @Autowired
    private BlackHandler blackHandler;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 构建临时处理器链，不修改原始handler的状态
        // 链式调用: authHandler -> identityHandler -> blackHandler
        boolean isSuccess = authHandler.handleWithNext(request, identityHandler);
        if (isSuccess) {
            isSuccess = identityHandler.handleWithNext(request, blackHandler);
        }

        if (!isSuccess) {
            // 如果校验失败，终止请求，返回错误信息
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Auth Failed");
            return false;
        }
        // 3. 校验成功，放行到Controller
        return true;
    }
}