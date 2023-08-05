package com.yeol.market.application.exception;

import com.yeol.market.exception.CoffeeShopException;
import org.springframework.http.HttpStatus;

public class NotFoundProductException extends CoffeeShopException {
    public NotFoundProductException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
