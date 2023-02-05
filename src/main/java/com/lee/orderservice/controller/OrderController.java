package com.lee.orderservice.controller;

import com.lee.orderservice.domain.OrderEntity;
import com.lee.orderservice.dto.OrderDto;
import com.lee.orderservice.messagequeue.KafkaProducer;
import com.lee.orderservice.vo.RequestOrder;
import com.lee.orderservice.service.OrderService;
import com.lee.orderservice.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final Environment env;
    private final KafkaProducer kafkaProducer;

    @GetMapping("/health-check")
    public String status(){
        return String.format("It's Working in Order Service on PORT %s", env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderDto> createOrder(@PathVariable("userId") String userId, @RequestBody RequestOrder requestOrder){
        OrderEntity orderEntity = orderService.createOrder(requestOrder, userId);

        OrderDto orderDto = OrderDto.builder()
                .orderEntity(orderEntity)
                .build();

        /* send this order to the kafka */
        kafkaProducer.send("example-catalog-topic", orderDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId){
        List<ResponseOrder> result = orderService.getOrdersByUserId(userId).stream().map(ResponseOrder::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
