package com.campus.mapper;

import com.campus.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product selectById(Long id);
    List<Product> selectAll();
    List<Product> selectByCategory(Integer category);
    List<Product> selectByStatus(Integer status);
    List<Product> selectBySellerId(Long sellerId);
    int insert(Product product);
    int update(Product product);
    int deleteById(Long id);
}