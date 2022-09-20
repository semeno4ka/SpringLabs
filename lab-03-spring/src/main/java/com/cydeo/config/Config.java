package com.cydeo.config;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("com.cydeo")
public class Config {

    @Bean
    Faker faker(){
        return new Faker();
    }
}
