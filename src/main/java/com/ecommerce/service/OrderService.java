package com.ecommerce.service;

import com.ecommerce.entity.Order;
import com.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
}
