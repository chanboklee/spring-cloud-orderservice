package com.lee.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lee.orderservice.domain.OrderEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdAt;

    private String orderId;

    public ResponseOrder(OrderEntity orderEntity){
        this.productId = orderEntity.getProductId();
        this.qty = orderEntity.getQty();
        this.unitPrice = orderEntity.getUnitPrice();
        this.totalPrice = orderEntity.getTotalPrice();
        this.orderId = orderEntity.getOrderId();
    }
}
