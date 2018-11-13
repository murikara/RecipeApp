package com.example.recipeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeHead {

    @SerializedName("recipe")
    @Expose
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}