package com.lee.orderservice.dto;

import lombok.Getter;

@Getter
public class OrderDto {

    private String productId;
    private String qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;
    private String userId
}
