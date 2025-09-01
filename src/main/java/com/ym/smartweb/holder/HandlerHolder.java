package com.ym.smartweb.holder;


import com.ym.smartweb.auth.handler.AbstractHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qushutao
 * @since 2025/8/31 17:57
 **/
@Component
@Scope("prototype")
public class HandlerHolder {

    @Autowired
    private List<AbstractHandler> handlers;

    public boolean handle(HttpServletRequest request) {

        for (AbstractHandler handler : handlers) {
            boolean handle = handler.handle(request);
            if (!handle) {
                return false;
            }
        }
        return true;

    }
}
