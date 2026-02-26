package com.securin.recipe.service;


import com.securin.recipe.model.Recipe;
import com.securin.recipe.respository.RecipeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public boolean loadAllData() {
        try {
            File file = new File("src/main/resources/Recipe.json");
            List<Recipe> recipes = objectMapper.readValue(file, new TypeReference<List<Recipe>>() {});
            recipeRepository.saveAll(recipes);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public Recipe loadRecipe(Recipe recipe){
        recipe.setTotalTime();
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getRecipe(int limit){
        Pageable pageable = PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "rating"));
        Page<Recipe> recipePage = recipeRepository.findAll(pageable);
        return recipePage.getContent();
    }

    public List<Recipe> getAllRecipe(){
        return recipeRepository.findTop5ByOrderByRatingDesc();
    }
}
