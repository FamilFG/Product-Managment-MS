package com.example.product_ms.controller;

import com.example.product_ms.dto.req.CreateProductReqDto;
import com.example.product_ms.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;


    @PostMapping("/add-products")
    public void addProduct(@RequestBody @Valid CreateProductReqDto createProductReqDto) {
        sellerService.addProducts(createProductReqDto);
    }
}
