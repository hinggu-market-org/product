
package com.yeol.market.product.domain.exception;

import com.yeol.market.product.exception.CoffeeShopException;
import org.springframework.http.HttpStatus;

public class InvalidStockException extends CoffeeShopException {
    public InvalidStockException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
