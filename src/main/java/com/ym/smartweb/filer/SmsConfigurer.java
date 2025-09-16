package com.ym.smartweb.filer;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author qushutao
 * @since 2025/9/16 10:12
 **/
public class SmsConfigurer<H extends HttpSecurityBuilder<H>> extends
        AbstractAuthenticationFilterConfigurer<H, SmsConfigurer<H>, SmsAuthenticationFilter> {
    private SmsAuthenticationFilter smsAuthenticationFilter;

    public SmsConfigurer() {
        super(new SmsAuthenticationFilter(), null);
        this.smsAuthenticationFilter = getAuthenticationFilter();
    }

    @Override
    protected RequestMatcher createLoginProcessingUrlMatcher(String loginProcessingUrl) {
        return PathPatternRequestMatcher.withDefaults().matcher(HttpMethod.POST, loginProcessingUrl);
    }

    public SmsConfigurer<H> loginProcessingUrl(String loginProcessingUrl) {
        return super.loginProcessingUrl(loginProcessingUrl);
    }

    public SmsAuthenticationFilter getFilter(){
        return smsAuthenticationFilter;
    }
}
