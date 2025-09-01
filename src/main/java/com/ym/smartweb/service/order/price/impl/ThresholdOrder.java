package com.ym.smartweb.service.order.price.impl;


import com.ym.smartweb.dto.UserOrderDto;
import com.ym.smartweb.service.order.price.AbstractOrderDecorator;

import java.math.BigDecimal;

/**
 * @author qushutao
 * @since 2025/8/31 19:22
 * 满减
 **/
public class ThresholdOrder extends AbstractOrderDecorator {

    public ThresholdOrder(AbstractOrderDecorator orderDecorator) {
        super(orderDecorator);
    }

    @Override
    public Long calculatePrice(Long userId, UserOrderDto.SkuDto skuDto) {
        Long price = skuDto.getPrice();
        if (null != orderDecorator){
            price = orderDecorator.calculatePrice(userId, skuDto);
        }
        return price >= 100 ? price - 10 : price;
    }

    @Override
    public String getDesc() {
        return "";
    }
}
