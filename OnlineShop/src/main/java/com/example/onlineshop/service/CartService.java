package com.example.onlineshop.service;

import com.example.onlineshop.entity.Cart;
import com.example.onlineshop.entity.User;
import com.example.onlineshop.security.CurrentUser;

import java.util.List;

public interface CartService {
    void save(Cart cart, int prodcutId, CurrentUser currentUser);

    List<Cart> findAll();
}
