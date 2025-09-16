package com.ym.smartweb.filer;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author qushutao
 * @since 2025/9/16 9:29
 **/
@Order(100)
public class SmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String usernameParameter = "phone";

    private String codeParameter = "code";


    private static final RequestMatcher DEFAULT_SMS_PATH_REQUEST_MATCHER = PathPatternRequestMatcher.withDefaults()
            .matcher(HttpMethod.POST, "/smsLogin");

    public SmsAuthenticationFilter() {
        super(DEFAULT_SMS_PATH_REQUEST_MATCHER);
    }
    public SmsAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(DEFAULT_SMS_PATH_REQUEST_MATCHER, authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String phone = obtainPhone(request);
        String code = obtainCode(request);
        SmsAuthenticationToken smsRequest = SmsAuthenticationToken.unauthenticated(phone, code);
        // Allow subclasses to set the "details" property
        smsRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
        return this.getAuthenticationManager().authenticate(smsRequest);
    }

    @Nullable
    protected String obtainPhone(HttpServletRequest request) {
        return request.getParameter(this.usernameParameter);
    }

    @Nullable
    protected String obtainCode(HttpServletRequest request) {
        return request.getParameter(this.codeParameter);
    }
}
