package com.ym.smartweb.holder;


import com.ym.smartweb.entity.User;

/**
 * @author qushutao
 * @since 2025/8/31 10:11
 **/
public class UserContextHolder {

    private static final ThreadLocal<User> USER_HOLDER = new ThreadLocal<>();

    public static void setUser(User username) {
        USER_HOLDER.set(username);
    }

    public static User getUser() {
        return USER_HOLDER.get();
    }

    public static void clear() {
        USER_HOLDER.remove();
    }

}
