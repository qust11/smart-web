package com.ym.smartweb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qushutao
 * @since 2025/8/31 10:11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;

    private int age;

    private String role;
}
