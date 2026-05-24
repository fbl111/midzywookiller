package com.campus.mapper;

import com.campus.dto.OrderDetailDTO;
import com.campus.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    Order selectById(Long id);
    List<Order> selectAll();
    List<Order> selectByBuyerId(Long buyerId);
    List<Order> selectBySellerId(Long sellerId);
    List<Order> selectByProductId(Long productId);
    List<Order> selectByStatus(Integer status);
    List<OrderDetailDTO> selectOrderDetailsByBuyerId(Long buyerId);
    List<OrderDetailDTO> selectOrderDetailsBySellerId(Long sellerId);
    int insert(Order order);
    int update(Order order);
    int deleteById(Long id);
}