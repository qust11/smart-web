package com.ym.smartweb.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ym.smartweb.pojo.CommonResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author qushutao
 * @since 2025/9/12 13:59
 **/
@Component
@AllArgsConstructor
@Slf4j
public class ResponseUtil {

    private static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        ResponseUtil.objectMapper = objectMapper;
    }

    public static void response(HttpServletResponse response, CommonResponse<?> commonResponse)  {
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().write(objectMapper.writeValueAsString(commonResponse));
        } catch (IOException e) {
            log.error("response error");
        }
    }
}
