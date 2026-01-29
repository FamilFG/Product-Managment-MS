package com.example.product_ms.exception;

public class SellerNotOwnerOfProductException extends RuntimeException {
    public SellerNotOwnerOfProductException(String message) {
        super(message);
    }
}
