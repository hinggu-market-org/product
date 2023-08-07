package com.yeol.market.product.domain.repository;

import com.yeol.market.product.domain.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByUuid(String menuUuid);
    Optional<Product> findByName(String name);

}
