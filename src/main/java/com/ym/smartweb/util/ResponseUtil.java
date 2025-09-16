package com.ym.smartweb.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ym.smartweb.pojo.CommonResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author qushutao
 * @since 2025/9/12 13:59
 **/
@Component
@AllArgsConstructor
public class ResponseUtil {

    private static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        ResponseUtil.objectMapper = objectMapper;
    }


    public static void response(HttpServletResponse response, CommonResponse<?> commonResponse) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(commonResponse));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
