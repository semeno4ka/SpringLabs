package com.cydeo.service.impl;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;
    private final Faker faker;

    public RecipeServiceImpl(RecipeRepository recipeRepository, ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;//third party, should be defined as bean manually
    }

    @Override
    public boolean prepareRecipe() {
        for (int i = 0; i <20 ; i++) {// recipes will be created 20 times for each
            Arrays.stream(RecipeType.values()).forEach(recipeType -> {// for each recipe type perform the following steps
                Recipe recipe = new Recipe();
                recipe.setRecipeId(UUID.randomUUID());
                recipe.setName(faker.food().dish());
                recipe.setDuration(generateRandomValue());
                recipe.setPreparation(faker.lorem().paragraph(generateRandomValue()));
                recipe.setIngredientList(prepareIngredients());
                recipe.setRecipeType(recipeType);
                recipeRepository.save(recipe);
                shareService.share(recipe);
            });
        }
        return false;
    }

    private List<Ingredient> prepareIngredients() {
        List<QuantityType> quantityTypeList=List.of(QuantityType.values());//all the values from Enum class
        List<Ingredient> ingredientList=new ArrayList<>();
        for (int i = 0; i <generateRandomValue(); i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(quantityTypeList.get(new Random().nextInt(3)));
            ingredientList.add(ingredient);
        }
     return ingredientList;
    }

    private int generateRandomValue(){// will be used only within the class
        return new Random().nextInt(20);
    }
}
