package com.ym.smartweb.service.user;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author qushutao
 * @since 2025/9/15 10:43
 **/
@Component
public class UserServiceImpl implements UserDetailsService {

    String passwrod = "123456";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, passwrod, new ArrayList<>());
    }
}
