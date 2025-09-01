package com.ym.smartweb.service.order.price.impl;


import com.ym.smartweb.dto.UserOrderDto;
import com.ym.smartweb.service.order.price.AbstractOrderDecorator;

import java.math.BigDecimal;

/**
 * @author qushutao
 * @since 2025/8/31 19:31
 * 秒杀
 **/
public class FlashSaleOrder extends AbstractOrderDecorator {

    public FlashSaleOrder(AbstractOrderDecorator orderDecorator) {
        super(orderDecorator);
    }

    @Override
    public Long calculatePrice(Long userId, UserOrderDto.SkuDto skuDto) {
        return null;
    }

    @Override
    public String getDesc() {
        return super.orderDecorator.getDesc() + " + 限时优惠";
    }
}
