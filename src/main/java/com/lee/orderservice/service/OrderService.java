package com.lee.orderservice.service;

import com.lee.orderservice.domain.OrderEntity;
import com.lee.orderservice.request.RequestOrder;

import java.util.List;

public interface OrderService {
    OrderEntity createOrder(RequestOrder requestOrder);
    OrderEntity getOrdersByOrderId(String orderId);
    List<OrderEntity> getOrdersByUserId(String userId);
}
