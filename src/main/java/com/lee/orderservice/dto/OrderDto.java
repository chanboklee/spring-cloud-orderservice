package com.lee.orderservice.dto;

import com.lee.orderservice.domain.OrderEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderDto {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;
    private String userId;

    @Builder
    public OrderDto(OrderEntity orderEntity){
        this.productId = orderEntity.getProductId();
        this.qty = orderEntity.getQty();
        this.unitPrice = orderEntity.getUnitPrice();
        this.totalPrice = orderEntity.getTotalPrice();
        this.orderId = orderEntity.getOrderId();
        this.userId = orderEntity.getUserId();
    }
}
