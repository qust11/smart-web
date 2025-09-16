package com.ym.smartweb.encoder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author qushutao
 * @since 2025/9/15-22:15
 */
@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return String.valueOf(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return StringUtils.equals(rawPassword, encodedPassword);
    }
}
