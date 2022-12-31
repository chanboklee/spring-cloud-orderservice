package com.lee.orderservice.service;

import com.lee.orderservice.domain.OrderEntity;
import com.lee.orderservice.repository.OrderRepository;
import com.lee.orderservice.request.RequestOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public OrderEntity createOrder(RequestOrder requestOrder) {

        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(UUID.randomUUID().toString())
                .totalPrice(requestOrder.getQty() * requestOrder.getUnitPrice())
                .build();

        orderRepository.save(orderEntity);
        return orderEntity;
    }

    @Override
    public OrderEntity getOrdersByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public List<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
