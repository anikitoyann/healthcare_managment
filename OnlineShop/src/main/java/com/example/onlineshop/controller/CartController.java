package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Cart;
import com.example.onlineshop.entity.User;
import com.example.onlineshop.security.CurrentUser;
import com.example.onlineshop.service.CartService;
import com.example.onlineshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable int productId, Cart cart, CurrentUser currentUser) {
     cartService.save(cart,productId,currentUser);
        return "redirect:/cart";
    }

    @GetMapping("/add/{productId}")
    public String viewCart(Model model) {
        model.addAttribute("carts", cartService.findAll());
        model.addAttribute("products",productService.findAll());
        return "cart";
    }
}
