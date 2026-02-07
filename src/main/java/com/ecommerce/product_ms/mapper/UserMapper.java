package com.ecommerce.product_ms.mapper;

import com.ecommerce.product_ms.dto.res.ProductResponseDto;
import com.ecommerce.product_ms.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    List<ProductResponseDto> mapListEntityToListDto(List<ProductEntity> productEntities);
}

