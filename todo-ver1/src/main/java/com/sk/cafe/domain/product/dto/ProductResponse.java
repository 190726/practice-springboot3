package com.sk.cafe.domain.product.dto;


import com.sk.cafe.domain.product.Product;
import com.sk.cafe.domain.product.ProductSellingStatus;
import com.sk.cafe.domain.product.ProductType;
import lombok.Builder;


public record ProductResponse(Long id, String productNumber, ProductType type,
                              ProductSellingStatus sellingStatus, String name, int price) {

    @Builder
    public ProductResponse {
    }

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productNumber(product.getProductNumber())
                .type(product.getType())
                .sellingStatus(product.getSellingStatus())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}