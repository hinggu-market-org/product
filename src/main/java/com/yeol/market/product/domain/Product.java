package com.yeol.market.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product")
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String name;

    @Embedded
    private Price price;

    @Embedded
    private Stock stock;

    public Product(final String name, final Long price) {
        this.name = name;
        this.price = new Price(price);
    }

    public Product(final String uuid, final String name, final Long price) {
        this.uuid = uuid;
        this.name = name;
        this.price = new Price(price);
    }

    public Long getPrice() {
        return price.getValue();
    }
}
