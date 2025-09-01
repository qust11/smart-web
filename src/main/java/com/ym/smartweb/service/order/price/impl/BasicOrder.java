package com.ym.smartweb.service.order.price.impl;


import com.ym.smartweb.dto.UserOrderDto;
import com.ym.smartweb.service.order.price.Order;
import org.springframework.stereotype.Component;

/**
 * @author qushutao
 * @since 2025/8/31 19:00
 **/
@Component
public class BasicOrder implements Order {

    @Override
    public Long calculatePrice(Long userId, UserOrderDto.SkuDto skuDto) {
        return skuDto.getTotalPrice();
    }

    @Override
    public String getDesc() {
        return "基础订单";
    }
}
