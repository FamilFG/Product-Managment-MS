package com.example.product_ms.service;

import com.example.product_ms.dto.req.CreateProductReqDto;

public interface SellerService {
    void addProducts(CreateProductReqDto createProductReqDto);

//    void updateProducts(String id, UpdateProductReqDto updateProductReqDto);
//
    void deleteProducts(String id);

}
