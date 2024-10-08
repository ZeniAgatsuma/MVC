package com.zeni.service.impl;

import com.zeni.entity.Cart;
import com.zeni.entity.Product;
import com.zeni.repository.ProductRepository;
import com.zeni.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Cart getNewCart() {
        return new Cart();
    }

    @Override
    public void addProduct(Cart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(Cart cart, Long prodId, Integer quantity) {
        Product product = productRepository.findById(prodId);
        if (product != null) {
            cart.addProduct(product, quantity);
        }
    }

    @Override
    public void delProduct(Cart cart, Product product, Integer quantity) {
        cart.delProduct(product, quantity);
    }

    @Override
    public BigDecimal getSum(Cart cart) {
        return cart.getSum();
    }

    @Override
    public void printCart(Cart cart) {
        cart.getCartMap().forEach((product, quantity) ->
                System.out.println("Product: " + product.getName() + ", Quantity: " + quantity));
    }

    @Override
    public int getProductQuantity(Cart cart, Product product) {
        return cart.getCartMap().getOrDefault(product, 0);
    }

    @Override
    public int getProductQuantity(Cart cart, Long prodId) {
        Product product = productRepository.findById(prodId);
        return product != null ? getProductQuantity(cart, product) : 0;
    }
}

