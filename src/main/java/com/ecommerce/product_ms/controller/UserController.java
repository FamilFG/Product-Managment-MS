package com.ecommerce.product_ms.controller;

import com.ecommerce.product_ms.dto.SuccessDto;
import com.ecommerce.product_ms.dto.req.DecreaseCountReqDto;
import com.ecommerce.product_ms.dto.res.ProductResponseDto;
import com.ecommerce.product_ms.service.UserService;
import com.ecommerce.product_ms.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SuccessDto<List<ProductResponseDto>>> getAllProducts() {

        List<ProductResponseDto> productResponseDtos = userService.getProducts();

        SuccessDto successDto = new SuccessDto<>(Status.SUCCESS, productResponseDtos);

        return new ResponseEntity<>(successDto, HttpStatus.OK);
    }


    @GetMapping(value = "/users/counts/{productId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    String getCountsProducts(@PathVariable String productId) {
        return userService.getProductCounts(productId);

    }

    @PutMapping(value = "/users/decrease-count")
    void decreaseCount(@RequestBody DecreaseCountReqDto decreaseCountReqDto) {
        userService.decreaseCount(decreaseCountReqDto);
    }


}

