package com.campus.service;

import com.campus.dto.OrderDetailDTO;
import com.campus.entity.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long id);
    List<Order> getOrdersByBuyerId(Long buyerId);
    List<Order> getOrdersBySellerId(Long sellerId);
    List<OrderDetailDTO> getOrderDetailsByBuyerId(Long buyerId);
    List<OrderDetailDTO> getOrderDetailsBySellerId(Long sellerId);
    boolean createOrder(Order order);
    boolean updateOrderStatus(Long id, Integer status);
    boolean deleteOrder(Long id);
}