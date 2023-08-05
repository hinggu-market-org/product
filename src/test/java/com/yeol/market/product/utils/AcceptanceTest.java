package com.yeol.market.product.utils;

import com.yeol.market.domain.Product;
import com.yeol.market.domain.repository.ProductRepository;
import com.yeol.market.product.config.DatabaseCleaner;
import com.yeol.market.product.fixture.ProductFixture;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class AcceptanceTest {

    @LocalServerPort
    int port;

    @Autowired
    protected ProductRepository productRepository;
    @Autowired
    protected DatabaseCleaner databaseCleaner;
    @Autowired
    protected PlatformTransactionManager transactionManager;
    protected TransactionTemplate transactionTemplate;

    protected String 당근_UUID;
    protected String 대파_UUID;
    protected String 감자_UUID;
    protected String 양배추_UUID;
    protected String 양파_UUID;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);

        당근_UUID = 상품_등록(ProductFixture.당근).getUuid();
        대파_UUID = 상품_등록(ProductFixture.대파).getUuid();
        감자_UUID = 상품_등록(ProductFixture.감자).getUuid();
        양배추_UUID = 상품_등록(ProductFixture.양배추).getUuid();
        양파_UUID = 상품_등록(ProductFixture.양파).getUuid();
    }

    protected Product 상품_등록(final Product product) {
        return productRepository.save(product);
    }

    protected ExtractableResponse<Response> 상품_목록_조회_요청() {
        return get("/products");
    }

    protected ExtractableResponse<Response> 상위_3개_상품_조회_요청() {
        return get("/products/ranking");
    }

    protected ExtractableResponse<Response> post(final String uri, final Object body) {
        return RestAssured.given().log().all().contentType(MediaType.APPLICATION_JSON_VALUE).body(body).when().post(uri).then().log().all().extract();
    }

    protected ExtractableResponse<Response> get(final String uri) {
        return RestAssured.given().log().all().when().get(uri).then().log().all().extract();
    }
    @AfterEach
    void tearDown() {
        databaseCleaner.clear();
    }

}
