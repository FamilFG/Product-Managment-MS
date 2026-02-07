package com.ecommerce.product_ms.dto.res;


import java.math.BigDecimal;

public record ProductResponseDto(String productId,
                                 String productName,
                                 String description,
                                 Integer stock,
                                 BigDecimal price,
                                 String categoryId) {
}

