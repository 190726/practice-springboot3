package com.sk.cafe.domain.product;

import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.sk.cafe.domain.product.ProductSellingStatus.*;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;


    @DisplayName("원하는 판매상태를 가진 상품을 조회한다.")
    @Test
    void findAllBySellingStatusIn(){
        //given
        var product1 = Product.builder()
                .productNumber("001")
                .type(ProductType.HANDMADE)
                .sellingStatus(SELLING)
                .name("아메리카노")
                .price(4000)
                .build();

        var product2 = Product.builder()
                .productNumber("002")
                .type(ProductType.HANDMADE)
                .sellingStatus(HOLD)
                .name("까페라테")
                .price(4500)
                .build();

        var product3 = Product.builder()
                .productNumber("003")
                .type(ProductType.HANDMADE)
                .sellingStatus(STOP_SELLING)
                .name("팥빙수")
                .price(7000)
                .build();

        productRepository.saveAll(List.of(product1, product2, product3));

        //when
        var products = productRepository.findAllBySellingStatusIn(forDisplay());

        //then
        Assertions.assertThat(products).hasSize(2)
                .extracting("productNumber", "name", "sellingStatus")
                .containsExactlyInAnyOrder(
                        Tuple.tuple("001","아메리카노",SELLING),
                        Tuple.tuple("002","까페라테",HOLD)
                );
    }
}