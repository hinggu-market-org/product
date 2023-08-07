package com.yeol.market.product.domain.exception;

import com.yeol.market.product.exception.CoffeeShopException;
import org.springframework.http.HttpStatus;

public class InvalidPriceException extends CoffeeShopException {

    public InvalidPriceException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
