package com.yeol.market.product.acceptance;

import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.stream.Collectors;

import com.yeol.market.product.application.dto.ProductResponse;
import com.yeol.market.product.utils.AcceptanceTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductAcceptanceTest extends AcceptanceTest {

    @Test
    @DisplayName("메뉴 목록을 조회한다")
    void getMenus() {
        final var response = 상품_목록_조회_요청();
        final var menus = response.jsonPath().getList(".", ProductResponse.class).stream()
                .map(ProductResponse::getName)
                .collect(Collectors.toList());

        assertAll(
                () -> Assertions.assertThat(response.statusCode()).isEqualTo(200),
                () -> Assertions.assertThat(menus)
                        .contains(
                                "감자",
                                "당근",
                                "대파",
                                "양배추",
                                "양파"
                        )
        );
    }

    @Test
    @DisplayName("최근 7일 동안의 인기 메뉴 3개 조회한다.")
    void getTop3MenuUntil7days() {
        final var response = 상위_3개_상품_조회_요청();
        final var menus = response.jsonPath().getList(".", ProductResponse.class).stream()
                .map(ProductResponse::getName)
                .collect(Collectors.toList());

        assertAll(
                () -> Assertions.assertThat(response.statusCode()).isEqualTo(200),
                () -> Assertions.assertThat(menus)
                        .contains(
                                "당근",
                                "대파",
                                "감자"
                        )
        );
    }
}
