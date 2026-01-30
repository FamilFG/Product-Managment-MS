package com.example.product_ms.dto;

import ch.qos.logback.core.status.Status;
import com.example.product_ms.dto.res.ProductResponseDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class SuccessDto<T> {

    private Status status;
    private T data;

    public SuccessDto(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    public SuccessDto(com.example.product_ms.utils.Status status, List<ProductResponseDto> productResponseDtos) {
    }
}

