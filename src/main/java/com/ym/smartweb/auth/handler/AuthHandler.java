package com.ym.smartweb.auth.handler;


import com.ym.smartweb.entity.User;
import com.ym.smartweb.holder.UserContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author qushutao
 * @since 2025/8/31 10:00
 **/
@Component
public class AuthHandler extends AbstractHandler {
    @Override
    public boolean handle(HttpServletRequest request) {
//        User user = UserContextHolder.getUser();
//        boolean admin = user.getRole().equals("admin");
//        if (!admin){
//            return false;
//        }
//        // 认证成功，传递到下一个节点
//        if (next != null) {
//            return next.handle(request);
//        }
        return true;
    }
}
