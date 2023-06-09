package com.sk.cafe.domain.product;

import com.sk.cafe.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@SequenceGenerator(
        name="SEQ_GENERATOR",
        sequenceName = "PRODUCT_SEQ",
        initialValue = 1,
        allocationSize = 10
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERATOR")
    private Long id;

    private String productNumber;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private ProductSellingStatus sellingStatus;

    private String name;

    private int price;

    @Builder
    public Product(String productNumber, ProductType type, ProductSellingStatus sellingStatus, String name, int price) {
        this.productNumber = productNumber;
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }
}