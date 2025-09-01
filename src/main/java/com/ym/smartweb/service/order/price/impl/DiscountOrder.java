package com.ym.smartweb.service.order.price.impl;


import com.ym.smartweb.dto.UserOrderDto;
import com.ym.smartweb.service.order.price.AbstractOrderDecorator;

/**
 * @author qushutao
 * @since 2025/8/31 19:16
 * 折扣
 **/
public class DiscountOrder extends AbstractOrderDecorator {

    public DiscountOrder(AbstractOrderDecorator orderDecorator) {
        super(orderDecorator);
    }

    @Override
    public Long calculatePrice(Long userId, UserOrderDto.SkuDto skuDto) {
        Long price = skuDto.getPrice();
        if (null != orderDecorator){
            price = orderDecorator.calculatePrice(userId, skuDto);
        }
        return price * 9 / 10;
    }

    @Override
    public String getDesc() {
        return "";
    }

}
