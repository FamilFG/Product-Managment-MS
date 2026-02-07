package com.ecommerce.product_ms.repository;

import com.ecommerce.product_ms.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    Optional<ProductEntity> findByProductId(String productId);
}

