package com.lee.orderservice.service;

import com.lee.orderservice.domain.OrderEntity;
import com.lee.orderservice.vo.RequestOrder;

import java.util.List;

public interface OrderService {
    OrderEntity createOrder(RequestOrder requestOrder, String userId);
    OrderEntity getOrdersByOrderId(String orderId);
    List<OrderEntity> getOrdersByUserId(String userId);
}
