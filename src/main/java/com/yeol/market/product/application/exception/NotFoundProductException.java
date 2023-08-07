package com.yeol.market.product.application.exception;

import com.yeol.market.product.exception.CoffeeShopException;
import org.springframework.http.HttpStatus;

public class NotFoundProductException extends CoffeeShopException {
    public NotFoundProductException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
