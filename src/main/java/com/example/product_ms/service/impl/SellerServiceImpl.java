package com.example.product_ms.service.impl;

import com.example.product_ms.dto.req.CreateProductReqDto;
import com.example.product_ms.dto.req.UpdateProductReqDto;
import com.example.product_ms.entity.ProductEntity;
import com.example.product_ms.exception.ProductNotFound;
import com.example.product_ms.exception.SellerNotOwnerOfProductException;
import com.example.product_ms.mapper.SellerMapper;
import com.example.product_ms.repository.ProductRepository;
import com.example.product_ms.service.SellerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final ProductRepository productRepository;
    private final SellerMapper sellerMapper;

    @Override
    public void addProducts(CreateProductReqDto createProductReqDto) {

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        var mapper = sellerMapper
                .mapProductDtoToProductEntity(createProductReqDto, userName);
        productRepository.save(mapper);
    }

    @Override
    @Transactional
    public void deleteProducts(String id) {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        ProductEntity productEntity =
                productRepository.findByProductId(id).orElseThrow(() -> new ProductNotFound("Product not found"));
        if (productEntity.getUserName().equals(auth.getName())) {
            productRepository.delete(productEntity);
        } else {
            throw new SellerNotOwnerOfProductException("Seller cannot delete product");
        }

    }

    @Override
    public void updateProducts(UpdateProductReqDto updateProductReqDto,String id) {

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        ProductEntity productEntity =
                productRepository.findByProductId(id).orElseThrow(() -> new ProductNotFound("Product not found"));
        if (productEntity.getUserName().equals(userName)) {
            sellerMapper.mapUpdateProductDtoToProductEntity(updateProductReqDto, productEntity);
            productRepository.save(productEntity);
        } else {
            throw new SellerNotOwnerOfProductException("Seller not found");
        }


    }

    @Override
    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

}
