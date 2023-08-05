package com.yeol.market.domain.service;

import com.yeol.market.application.OrderClient;
import com.yeol.market.application.dto.ProductResponse;
import com.yeol.market.application.dto.Top3NameResponse;
import com.yeol.market.domain.Product;
import com.yeol.market.domain.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RankingService {

    private static final long NO_MORE_SELL_PRODUCT_PRICE = -1L;
    private final ProductRepository productRepository;
    private final OrderClient orderClient;


    public List<ProductResponse> findTop3Menu() {
        final Top3NameResponse top3ByCount = orderClient.getTop3ProductNameByCount();
        return top3ByCount.getProductNames().stream()
                .map(this::findProductByName)
                .collect(Collectors.toList());
    }

    private ProductResponse findProductByName(final String name){
        final Product product = productRepository.findByName(name)
                .orElse(new Product("판매 중단된 상품", NO_MORE_SELL_PRODUCT_PRICE));
        return ProductResponse.of(product);
    }
}
