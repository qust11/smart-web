package com.ym.smartweb.service.order.impl;

import com.ym.smartweb.dto.UserOrderDto;
import com.ym.smartweb.service.order.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author qushutao
 * @since 2025/9/1 12:33
 **/
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private IOrderService orderService;
    @Test
    void order() {
        UserOrderDto.SkuDto skuDto = new UserOrderDto.SkuDto(1L, 100L, 10, 1000L, 1);
        List<UserOrderDto.SkuDto> skuDtoList = List.of(
                skuDto
        );
        orderService.order(new UserOrderDto(1L,skuDtoList ));
    }
}