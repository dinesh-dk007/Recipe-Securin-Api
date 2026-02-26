package com.securin.recipe.controller;

import com.securin.recipe.model.Recipe;
import com.securin.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;


    @PostMapping({"/load"})
    public ResponseEntity<String> loadData() {
            if(recipeService.loadAllData()){
                return new ResponseEntity<>("The data loaded successfully", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Error occurred while loading data ", HttpStatus.BAD_REQUEST);
            }
    }

    @PostMapping
    public ResponseEntity<Recipe> postData(@RequestBody Recipe recipe){
        return new ResponseEntity<>(recipeService.loadRecipe(recipe), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return new ResponseEntity<>(recipeService.getAllRecipe(),HttpStatus.OK);
    }
    @GetMapping("/top")
    public ResponseEntity<List<Recipe>> getDataByPagination(@RequestParam(defaultValue = "5") int limit
    ){
        return new ResponseEntity<>(recipeService.getRecipe(limit), HttpStatus.OK);
    }




}
