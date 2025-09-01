package com.ym.smartweb.service.order.price;

import com.ym.smartweb.dto.UserOrderDto;

import java.math.BigDecimal;

/**
 * @author qushutao
 * @since 2025/8/31 18:45
 **/
public interface Order {

    /**
     * 计算订单价格
     * @param userId 用户ID
     * @param skuDto 商品信息
     * @return 计算后的价格
     */
    Long calculatePrice(Long userId, UserOrderDto.SkuDto skuDto);

    /**
     * 获取订单描述信息
     * @return 描述信息
     */
    String getDesc();
}