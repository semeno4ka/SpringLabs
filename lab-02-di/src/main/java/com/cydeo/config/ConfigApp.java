package com.cydeo.config;

import com.cydeo.model.Cart;
import com.cydeo.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com.cydeo")
public class ConfigApp {
    @Bean
    public Product product(){
        Product a= new Product();
        a.setName("Watch");
        a.setPrice(new BigDecimal("577"));
        a.setQuantity(1);
        a.setRemainingQuantity(9);
        return a;
    }

}
