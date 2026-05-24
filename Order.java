package com.campus.entity;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private Long productId;
    private Long buyerId;
    private Long sellerId;
    private Double price;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Order() {
    }

    public Order(Long id, Long productId, Long buyerId, Long sellerId, Double price, Integer status, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.productId = productId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.price = price;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
