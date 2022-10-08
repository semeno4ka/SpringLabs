package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import static com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl.CART;

@Controller
public class CartController {

    private final CartService cartService;
    private final ProductService productService;



    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;

    }

    @GetMapping("/cart")
    public String cartList(Model model){
        model.addAttribute("cart",CART);
        return "/cart/show-cart";
}
@GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable("productId") UUID productId,@PathVariable("quantity") Integer quantity){
        cartService.addToCart(productId,quantity);
        return "redirect:/cart";
}
@GetMapping("/delete/{productId}")
    public String deleteItem(@PathVariable("productId") UUID productId){
        cartService.deleteFromCart(productId);
        return "redirect:/cart";
}





}
