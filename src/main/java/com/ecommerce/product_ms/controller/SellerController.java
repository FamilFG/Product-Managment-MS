package com.ecommerce.product_ms.controller;

import com.ecommerce.product_ms.dto.req.CreateProductReqDto;
import com.ecommerce.product_ms.dto.req.UpdateProductReqDto;
import com.ecommerce.product_ms.entity.ProductEntity;
import com.ecommerce.product_ms.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;


    @PostMapping("/add-products")
    public void addProduct(@RequestBody @Valid CreateProductReqDto createProductReqDto) {
        sellerService.addProducts(createProductReqDto);
    }

    @DeleteMapping("/delete-products/{id}")
    public void deleteProduct(@PathVariable String id) {
        sellerService.deleteProducts(id);

    }

    @PostMapping("/update-products/{id}")
    public void updateProduct(@RequestBody @Valid UpdateProductReqDto updateProductReqDto, @PathVariable String id) {
        sellerService.updateProducts(updateProductReqDto, id);
    }
    @GetMapping("/products")
    public List<ProductEntity> getProducts() {
        return sellerService.getProducts();
    }
}
