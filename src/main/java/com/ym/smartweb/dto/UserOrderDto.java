package com.ym.smartweb.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qushutao
 * @since 2025/9/1 9:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {

    private Long userId;

    // 为每一个订Sku DTO单独生成一个订单
    private List<SkuDto> skuDtoList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SkuDto {

        // skuid
        private Long skuId;

        // 单价
        private Long price;

        // 数量
        private Integer count;

        // 总价
        private Long totalPrice;


        // 类型
        private Integer type;

        // 使用权益

        // 使用优惠
    }
}
