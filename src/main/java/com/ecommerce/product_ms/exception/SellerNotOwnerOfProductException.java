package com.ecommerce.product_ms.exception;

public class SellerNotOwnerOfProductException extends RuntimeException {
    public SellerNotOwnerOfProductException(String message) {
        super(message);
    }
}
