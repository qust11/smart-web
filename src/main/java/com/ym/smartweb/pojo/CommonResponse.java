package com.ym.smartweb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qushutao
 * @since 2025/9/12 13:09
 **/
@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class CommonResponse<T> {

    private int code;
    private String message;
    private T data;

    public static <T> CommonResponse<T> success(T data) {
        return create(200, "success", data);
    }

    public static <T> CommonResponse<T> success(String message) {
        return create(200, message, null);
    }

    public static <T> CommonResponse<T> error(String desc) {
        return create(500, desc, null);
    }

    public static <T> CommonResponse<T> error(int code, String desc) {
        return create(code, desc, null);
    }


}
