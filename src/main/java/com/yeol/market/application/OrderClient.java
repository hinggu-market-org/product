package com.yeol.market.application;

import com.yeol.market.application.dto.Top3NameResponse;

import java.util.List;

public interface OrderClient {

   Top3NameResponse getTop3ProductNameByCount();
}
