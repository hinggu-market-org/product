package com.yeol.market.domain.repository;

import com.yeol.market.domain.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByUuid(String menuUuid);
    Optional<Product> findByName(String name);

}
