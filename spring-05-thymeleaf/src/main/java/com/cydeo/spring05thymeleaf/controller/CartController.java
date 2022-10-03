package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

@RequestMapping("/addToCart/{id}/{quantity}")
    public String addProduct(@PathVariable UUID id, @PathVariable Integer quantity){
 return "/cart/show-cart";
}

}
