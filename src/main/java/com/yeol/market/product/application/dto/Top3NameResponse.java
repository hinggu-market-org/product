package com.yeol.market.product.application.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Top3NameResponse {

    List<String> productNames;

    public static Top3NameResponse of(List<String> productNames){
        return new Top3NameResponse(productNames);
    }
}
