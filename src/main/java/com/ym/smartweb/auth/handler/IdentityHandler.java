package com.ym.smartweb.auth.handler;


import com.ym.smartweb.entity.User;
import com.ym.smartweb.holder.UserContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author qushutao
 * @since 2025/8/31 9:59
 **/
@Component
public class IdentityHandler extends AbstractHandler {
    @Override
    public boolean handle(HttpServletRequest request) {
//        User user = UserContextHolder.getUser();
//        if (!user.getUsername().equals("admin")) {
//            return false;
//        }
//        // 认证成功，传递到下一个节点
//        if (next != null) {
//            return next.handle(request);
//        }
        return true;
    }
}
