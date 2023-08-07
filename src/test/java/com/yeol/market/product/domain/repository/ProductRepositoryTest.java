package com.yeol.market.product.domain.repository;

import com.yeol.market.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.yeol.market.product.fixture.ProductFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@Transactional
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("id를 통해 상품을 찾아 반환한다.")
    void findById() {
        final var savedProduct = productRepository.save(당근);
        final var product = productRepository.findById(savedProduct.getId()).get();

        assertAll(
                () -> assertThat(product.getName()).isEqualTo("당근"),
                () -> assertThat(product.getPrice()).isEqualTo(3_000)
        );
    }

    @Test
    @DisplayName("상품 전체 목록을 반환한다.")
    void findAll() {
        productRepository.save(당근);
        productRepository.save(대파);
        productRepository.save(감자);

        final List<Product> actual = productRepository.findAll();

        assertAll(
                () -> assertThat(actual).hasSize(3),
                () -> assertThat(actual)
                        .extracting("name")
                        .contains("당근", "대파", "감자")
        );
    }
}
