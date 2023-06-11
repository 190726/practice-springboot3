package com.sk.cafe.domain.product;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum ProductSellingType {

    SELLING("판매중"),
    HOLD("판매보류"),
    STOP_SELLING("판매중지");

    private final String text;

    /**
     * 진열 가능 상태 목록 반환
     */
    public static List<ProductSellingType> forDisplay(){
        return List.of(SELLING, HOLD);
    }
}