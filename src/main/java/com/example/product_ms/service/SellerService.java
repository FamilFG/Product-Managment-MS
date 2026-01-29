package com.example.product_ms.service;

import com.example.product_ms.dto.req.CreateProductReqDto;
import com.example.product_ms.dto.req.UpdateProductReqDto;
import com.example.product_ms.entity.ProductEntity;
import jakarta.validation.Valid;

import java.util.List;

public interface SellerService {
    void addProducts(CreateProductReqDto createProductReqDto);

    void deleteProducts(String id);

    void updateProducts(@Valid UpdateProductReqDto updateProductReqDto, String id);

    List<ProductEntity> getProducts();
}
