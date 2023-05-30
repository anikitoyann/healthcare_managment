package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Cart;
import com.example.onlineshop.entity.Product;
import com.example.onlineshop.entity.User;
import com.example.onlineshop.repository.CartRepository;
import com.example.onlineshop.repository.ProductRepository;
import com.example.onlineshop.security.CurrentUser;
import com.example.onlineshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final ProductRepository productRepository;
    private  final CartRepository cartRepository;
    @Override
    public void save(Cart cart, int productId, CurrentUser currentUser) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            cart.getProductList().add(productId,product.get());
            cartRepository.save(cart);
        }
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
}
