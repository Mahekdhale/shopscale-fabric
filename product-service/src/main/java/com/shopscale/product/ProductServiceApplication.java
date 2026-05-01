package com.shopscale.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}

// ---- Product.java (model) ----
// package com.shopscale.product.model;
// import lombok.*;
// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;
// import java.math.BigDecimal;
//
// @Document(collection = "products")
// @Data @NoArgsConstructor @AllArgsConstructor @Builder
// public class Product {
//     @Id
//     private String id;
//     private String name;
//     private String description;
//     private BigDecimal price;
// }

// ---- ProductRepository.java ----
// package com.shopscale.product.repository;
// import com.shopscale.product.model.Product;
// import org.springframework.data.mongodb.repository.MongoRepository;
// public interface ProductRepository extends MongoRepository<Product, String> {}