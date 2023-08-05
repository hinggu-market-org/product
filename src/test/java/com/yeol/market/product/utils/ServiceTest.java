package com.yeol.market.product.utils;

import com.yeol.market.application.ProductService;
import com.yeol.market.domain.Product;
import com.yeol.market.domain.repository.ProductRepository;
import com.yeol.market.domain.service.RankingService;
import com.yeol.market.product.config.DatabaseCleaner;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceTest {

    @Autowired
    protected ProductService productService;

    @Autowired
    protected RankingService rankingService;

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    protected DatabaseCleaner databaseCleaner;

    protected Product 상품_등록(final Product product) {
        return productRepository.save(product);
    }

    @AfterEach
    void tearDown() {
        databaseCleaner.clear();
    }
}
