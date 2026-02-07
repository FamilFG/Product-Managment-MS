package com.ecommerce.product_ms.service;

import com.ecommerce.product_ms.dto.req.DecreaseCountReqDto;
import com.ecommerce.product_ms.dto.res.ProductResponseDto;

import java.util.List;

public interface UserService {

    List<ProductResponseDto> getProducts();

    String getProductCounts(String productId);

    void decreaseCount(DecreaseCountReqDto decreaseCountReqDto);
}
