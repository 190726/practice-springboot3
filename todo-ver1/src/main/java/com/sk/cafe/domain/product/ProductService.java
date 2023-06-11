package com.sk.cafe.domain.product;

import com.sk.cafe.domain.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts(){
        final List<Product> products = productRepository.findAllBySellingTypeIn(ProductSellingType.forDisplay());
        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());

    }
}