package com.zeni;

import com.zeni.entity.Cart;
import com.zeni.entity.Product;
import com.zeni.repository.ProductRepository;
import com.zeni.service.impl.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CartServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    private Cart cart;
    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cart = cartService.getNewCart();
        product = new Product(1L, "Test Product", BigDecimal.valueOf(10.0));

        when(productRepository.findById(1L)).thenReturn(product);
    }

    @Test
    @Order(1)
    @DisplayName("Add product to cart")
    public void testAddProduct() {
        cartService.addProduct(cart, product, 2);
        assertEquals(2, cart.getProductQuantity(product));
    }

    @Test
    @Order(2)
    @DisplayName("Calculate total sum of cart")
    public void testGetSum() {
        cartService.addProduct(cart, product, 2);
        assertEquals(BigDecimal.valueOf(20.0), cartService.getSum(cart));
    }

    @Test
    @Order(3)
    @DisplayName("Remove product from cart")
    public void testDelProduct() {
        cartService.addProduct(cart, product, 2);
        cartService.delProduct(cart, product, 1);
        assertEquals(1, cart.getProductQuantity(product));
    }

    @Test
    @Order(4)
    @DisplayName("Get new empty cart")
    public void testGetNewCart() {
        Cart newCart = cartService.getNewCart();
        assertEquals(0, newCart.getCartMap().size());
    }
}
