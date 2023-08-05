
package com.yeol.market.domain.exception;

import com.yeol.market.exception.CoffeeShopException;
import org.springframework.http.HttpStatus;

public class InvalidStockException extends CoffeeShopException {
    public InvalidStockException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
