package com.campus.service.impl;

import com.campus.dto.OrderDetailDTO;
import com.campus.entity.Order;
import com.campus.entity.Product;
import com.campus.mapper.OrderMapper;
import com.campus.mapper.ProductMapper;
import com.campus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Order getOrderById(Long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<Order> getOrdersByBuyerId(Long buyerId) {
        return orderMapper.selectByBuyerId(buyerId);
    }

    @Override
    public List<Order> getOrdersBySellerId(Long sellerId) {
        return orderMapper.selectBySellerId(sellerId);
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailsByBuyerId(Long buyerId) {
        List<OrderDetailDTO> orders = orderMapper.selectOrderDetailsByBuyerId(buyerId);
        return orders.stream().peek(this::setOrderStatusText).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailsBySellerId(Long sellerId) {
        List<OrderDetailDTO> orders = orderMapper.selectOrderDetailsBySellerId(sellerId);
        return orders.stream().peek(this::setOrderStatusText).collect(Collectors.toList());
    }

    private void setOrderStatusText(OrderDetailDTO order) {
        switch (order.getStatus()) {
            case 0:
                order.setStatusText("待付款");
                break;
            case 1:
                order.setStatusText("待发货");
                break;
            case 2:
                order.setStatusText("待收货");
                break;
            case 3:
                order.setStatusText("已完成");
                break;
            case 4:
                order.setStatusText("已取消");
                break;
            default:
                order.setStatusText("未知");
        }
    }

    @Override
    @Transactional
    public boolean createOrder(Order order) {
        order.setStatus(0);
        boolean success = orderMapper.insert(order) > 0;
        if (success) {
            Product product = new Product();
            product.setId(order.getProductId());
            product.setStatus(3);
            productMapper.update(product);
        }
        return success;
    }

    @Override
    public boolean updateOrderStatus(Long id, Integer status) {
        Order order = new Order();
        order.setId(id);
        order.setStatus(status);
        return orderMapper.update(order) > 0;
    }

    @Override
    public boolean deleteOrder(Long id) {
        return orderMapper.deleteById(id) > 0;
    }
}