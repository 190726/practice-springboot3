package com.sk.cafe;

import com.sk.cafe.domain.product.ProductType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CafeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CafeApplication.class, args);
    }
}
