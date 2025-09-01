package com.ym.smartweb.service.order.price;


import java.math.BigDecimal;

/**
 * @author qushutao
 * @since 2025/8/31 19:11
 **/
public abstract class AbstractOrderDecorator implements Order {
    protected AbstractOrderDecorator orderDecorator;

    public AbstractOrderDecorator(AbstractOrderDecorator orderDecorator) {
        this.orderDecorator = orderDecorator;
    }
}
