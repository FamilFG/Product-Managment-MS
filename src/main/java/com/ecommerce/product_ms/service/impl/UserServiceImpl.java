package com.ecommerce.product_ms.service.impl;

import com.ecommerce.product_ms.dto.req.DecreaseCountReqDto;
import com.ecommerce.product_ms.dto.res.ProductResponseDto;
import com.ecommerce.product_ms.entity.ProductEntity;
import com.ecommerce.product_ms.exception.ProductNotFound;
import com.ecommerce.product_ms.mapper.UserMapper;
import com.ecommerce.product_ms.repository.ProductRepository;
import com.ecommerce.product_ms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ProductRepository productRepository;
    private final UserMapper userMapper;

    @Override
    public List<ProductResponseDto> getProducts() {
        List<ProductEntity> allProducts = productRepository.findAll();
        return userMapper.mapListEntityToListDto(allProducts);
    }

    @Override
    public String getProductCounts(String productId) {

        ProductEntity productEntity =
                productRepository.findByProductId(productId).orElseThrow(()
                        -> new ProductNotFound("Product not found"));

        return productEntity.getStock().toString();
    }

    @Override
    public void decreaseCount(DecreaseCountReqDto decreaseCountReqDto) {

        ProductEntity productEntity =
                productRepository.findByProductId(decreaseCountReqDto
                        .productId()).orElseThrow(()
                        -> new ProductNotFound("Product not found"));

        if (productEntity.getStock() < decreaseCountReqDto.count()) {
            throw new ProductNotFound("Product stock is less than count");
        }

        productEntity.setStock(productEntity.getStock() - decreaseCountReqDto.count());
        productRepository.save(productEntity);

    }
}

