package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import com.cydeo.spring05thymeleaf.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {


 private final ProductService productService;
 private final CartService cartService;

    public ProductController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @GetMapping("/create-product")
    public String createProduct(Model model){
    model.addAttribute("product", new Product());
    return "/product/create-product";
}

   @PostMapping("/create-product")
    public String addProduct(@ModelAttribute("product") Product product){
       productService.productCreate(product);
        return "redirect:/product/list";
}

   @GetMapping("/list")
    public String productList(Model model){
        model.addAttribute("list", productService.listProduct());
        return "/product/list";
}



}
