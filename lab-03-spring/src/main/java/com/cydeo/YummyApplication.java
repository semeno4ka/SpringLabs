package com.cydeo;

import com.cydeo.config.AuthorConfig;
import com.cydeo.service.RecipeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class YummyApplication {

    public static void main(String[] args) {


        ApplicationContext context =SpringApplication.run(YummyApplication.class, args);
        RecipeService recipeService = context.getBean(RecipeService.class);
        recipeService.prepareRecipe();

        AuthorConfig author= context.getBean(AuthorConfig.class);


        System.out.println("Here you are! Author information of the recipe");
        System.out.println("Name " + author.getName() + " Surname " + author.getSurname()
                + "\n" + "Phone Number "  + author.getPhone() + "\n" + "Social Media Links "
                + author.getSocialMedia() + "\n" + "Email " + author.getEmail());
    }

    }



