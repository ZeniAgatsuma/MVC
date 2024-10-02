package com.zeni.repository;

import com.zeni.entity.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private Map<Long, Product> productMap = new HashMap<>();

    @PostConstruct
    public void init() {
        productMap.put(1L, new Product(1L, "Product cucumber", BigDecimal.valueOf(10.0)));
        productMap.put(2L, new Product(2L, "Product potato", BigDecimal.valueOf(15.0)));
        productMap.put(3L, new Product(3L, "Product zelenina", BigDecimal.valueOf(20.0)));
        productMap.put(4L, new Product(4L, "Product ovocie", BigDecimal.valueOf(25.0)));
        productMap.put(5L, new Product(5L, "Product jabko", BigDecimal.valueOf(30.0)));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public Product findById(Long id) {
        return productMap.get(id);
    }

    public void saveOrUpdate(Product product) {
        productMap.put(product.getId(), product);
    }

    public void deleteById(Long id) {
        productMap.remove(id);
    }
}

