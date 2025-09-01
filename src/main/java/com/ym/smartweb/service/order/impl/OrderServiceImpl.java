package com.ym.smartweb.service.order.impl;


import com.ym.smartweb.dto.UserOrderDto;
import com.ym.smartweb.service.order.IOrderService;
import com.ym.smartweb.service.order.price.AbstractOrderDecorator;
import com.ym.smartweb.service.order.price.impl.BasicOrder;
import com.ym.smartweb.service.order.price.impl.DiscountOrder;
import com.ym.smartweb.service.order.price.impl.ThresholdOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qushutao
 * @since 2025/9/1 11:32
 **/
@Component
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private BasicOrder basicOrder;

    @Override
    public void order(UserOrderDto userOrderDto) {
        // 获取当前用户的权益、优惠券 、是否有满减活动等
        AbstractOrderDecorator orderDecorator = new DiscountOrder(new ThresholdOrder(null));

        Long l = orderDecorator.calculatePrice(userOrderDto.getUserId(), userOrderDto.getSkuDtoList().get(0));
        System.out.println(l);

    }
}
