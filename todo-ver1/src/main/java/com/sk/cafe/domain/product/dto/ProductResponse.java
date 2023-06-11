package com.sk.cafe.domain.product.dto;


import com.sk.cafe.domain.product.Product;
import com.sk.cafe.domain.product.ProductSellingType;
import com.sk.cafe.domain.product.ProductType;
import lombok.Builder;
import lombok.Getter;

@Getter
public record ProductResponse(Long id, String productNumber, ProductType productType,
                              ProductSellingType productSellingType, String name, int price) {

    @Builder
    public ProductResponse {
    }

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productNumber(product.getProductNumber())
                .productType(product.getProductType())
                .productSellingType(product.getProductSellingType())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}