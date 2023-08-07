package com.yeol.market.product.application;

import com.yeol.market.product.application.dto.Top3NameResponse;

public interface OrderClient {

    Top3NameResponse getTop3ProductNameByCount();
}
