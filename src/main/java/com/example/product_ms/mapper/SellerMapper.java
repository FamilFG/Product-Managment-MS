package com.example.product_ms.mapper;

import com.example.product_ms.dto.req.CreateProductReqDto;
import com.example.product_ms.dto.req.UpdateProductReqDto;
import com.example.product_ms.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SellerMapper {

    @Mapping(target = "userName", source = "userName")
    ProductEntity mapProductDtoToProductEntity(CreateProductReqDto createProductReqDto, String userName);


    void mapUpdateProductDtoToProductEntity(UpdateProductReqDto updateProductReqDto, @MappingTarget ProductEntity productEntity);
}



