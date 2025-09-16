package com.ym.smartweb.filer;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author qushutao
 * @since 2025/9/16 10:07
 **/
public class SmsAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = authentication.getPrincipal().toString();
        String credentials = authentication.getCredentials().toString();

        if (credentials.equals("123456")){
            return new SmsAuthenticationToken(principal, credentials, null);
        }
        throw new RuntimeException("验证码错误");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (SmsAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
