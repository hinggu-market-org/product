package com.yeol.market.product.infrastructure;

import com.yeol.market.product.application.OrderClient;
import com.yeol.market.product.application.dto.Top3NameResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OrderClientImpl implements OrderClient {

    private final String orderUrl;

    public OrderClientImpl(@Value("${external.api.placeHolder}") final String orderUrl) {
        this.orderUrl = orderUrl;
    }

    @Override
    public Top3NameResponse getTop3ProductNameByCount() {
        final WebClient webClient = initWebclient();
        return webClient.get()
                .uri("/orders/top3")
                .retrieve()
                .bodyToMono(Top3NameResponse.class)
                .block();
    }

    private WebClient initWebclient() {
        return WebClient.builder()
                .baseUrl(orderUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
