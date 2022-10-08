package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());
// it is static because there is just ONE cart object for the entire app(one for all, memory allocation)
    private final ProductServiceImpl productService;

    public CartServiceImpl(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
      Product product= productService.findProductById(productId);

      CartItem cartItem = new CartItem();
      cartItem.setProduct(product);
      cartItem.setQuantity(quantity);
      cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

      CART.getCartItemList().add(cartItem);
      CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));//DOUBLE CHECK LOGIC

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        CartItem cartItem = CART.getCartItemList().stream().filter(p-> p.getProduct().getId().equals(productId)).findFirst().orElseThrow();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(cartItem.getTotalAmount()));
        Product product=productService.findProductById(productId);
        product.setRemainingQuantity(product.getRemainingQuantity()+cartItem.getQuantity());
        return  CART.getCartItemList().removeIf(c->c.equals(cartItem));
    }
}
 /*     ADD TO CART
        if(CART.getCartItemList().stream().anyMatch(cartItem -> cartItem.getProduct().getId().equals(product.getId()))){

          CartItem cartItem2 = CART.getCartItemList().stream().filter(cartItem -> cartItem.getProduct().getId().equals(product.getId())).findFirst().orElseThrow();
          cartItem2.setQuantity(cartItem2.getQuantity()+quantity);
          cartItem2.setTotalAmount(cartItem2.getTotalAmount().add(product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()))));
          CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem2.getTotalAmount()));
          return CART;
        }

       CartItem cartItem= new CartItem();
       cartItem.setProduct(product);
       cartItem.setQuantity(quantity);
       cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        //todo calculate cart total amount
       CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        //todo add to cart
      CART.getCartItemList().add(cartItem);



      DELETE FROM CART
      */