package com.ym.smartweb.auth.handler;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author qushutao
 * @since 2025/8/31 10:00
 **/
@Component
public class BlackHandler extends AbstractHandler{

    private List<String> blackIpList = Arrays.asList("129.445.42.888");
    @Override
    public boolean handle(HttpServletRequest request) {
        // 从request中获取ip地址
        String ip = request.getRemoteAddr();
        if (blackIpList.contains(ip)){
            return false;
        }
        // 认证成功，传递到下一个节点
        if (next != null) {
            return next.handle(request);
        }
        return true;
    }
}
