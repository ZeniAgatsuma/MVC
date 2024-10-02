package com.zeni.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void addProduct(Product product, Integer quantity) {
        cartMap.merge(product, quantity, Integer::sum);
    }

    public void delProduct(Product product, Integer quantity) {
        cartMap.computeIfPresent(product, (p, qty) -> qty - quantity > 0 ? qty - quantity : null);
    }

    public BigDecimal getSum() {
        return cartMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getProductQuantity(Product product) {
        return cartMap.getOrDefault(product, 0);
    }
}

