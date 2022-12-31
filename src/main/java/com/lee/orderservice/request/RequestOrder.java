package com.lee.orderservice.request;

import lombok.Data;

@Data
public class RequestOrder {

    private String orderId;
    private Integer qty;
    private Integer unitPrice;
}
