package com.api.application.service.impl;

import com.api.application.domain.model.Order;
import com.api.application.domain.repositoy.OrderRepository;
import com.api.application.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements CrudService<Order, Long> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        Order existingOrder = findById(id);
        if (existingOrder != null) {
            existingOrder.setProduct(order.getProduct());
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
