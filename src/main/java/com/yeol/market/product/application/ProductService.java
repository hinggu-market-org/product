package com.yeol.market.product.application;

import java.util.List;
import java.util.stream.Collectors;

import com.yeol.market.product.application.dto.ProductResponse;
import com.yeol.market.product.domain.Product;
import com.yeol.market.product.application.exception.NotFoundProductException;
import com.yeol.market.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public ProductResponse getProduct(final String uuid) {
        final Product product = productRepository.findByUuid(uuid)
                .orElseThrow(() -> new NotFoundProductException("해당 상품을 찾을 수 없습니다."));
        return ProductResponse.of(product);
    }
}
