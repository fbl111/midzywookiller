package com.campus.controller;

import com.campus.dto.OrderDetailDTO;
import com.campus.entity.Order;
import com.campus.service.OrderService;
import com.campus.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public Result<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return Result.success(order);
        }
        return Result.error("订单不存在");
    }

    @GetMapping("/buyer/{buyerId}")
    public Result<List<Order>> getOrdersByBuyerId(@PathVariable Long buyerId) {
        List<Order> orders = orderService.getOrdersByBuyerId(buyerId);
        return Result.success(orders);
    }

    @GetMapping("/buyer/{buyerId}/detail")
    public Result<List<OrderDetailDTO>> getOrderDetailsByBuyerId(@PathVariable Long buyerId) {
        List<OrderDetailDTO> orders = orderService.getOrderDetailsByBuyerId(buyerId);
        return Result.success(orders);
    }

    @GetMapping("/seller/{sellerId}")
    public Result<List<Order>> getOrdersBySellerId(@PathVariable Long sellerId) {
        List<Order> orders = orderService.getOrdersBySellerId(sellerId);
        return Result.success(orders);
    }

    @GetMapping("/seller/{sellerId}/detail")
    public Result<List<OrderDetailDTO>> getOrderDetailsBySellerId(@PathVariable Long sellerId) {
        List<OrderDetailDTO> orders = orderService.getOrderDetailsBySellerId(sellerId);
        return Result.success(orders);
    }

    @PostMapping
    public Result<Boolean> createOrder(@RequestBody Order order) {
        boolean success = orderService.createOrder(order);
        if (success) {
            return Result.success(true);
        }
        return Result.error("创建订单失败");
    }

    @PutMapping("/{id}/status")
    public Result<Boolean> updateOrderStatus(@PathVariable Long id, @RequestParam Integer status) {
        boolean success = orderService.updateOrderStatus(id, status);
        if (success) {
            return Result.success(true);
        }
        return Result.error("更新订单状态失败");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteOrder(@PathVariable Long id) {
        boolean success = orderService.deleteOrder(id);
        if (success) {
            return Result.success(true);
        }
        return Result.error("删除订单失败");
    }
}