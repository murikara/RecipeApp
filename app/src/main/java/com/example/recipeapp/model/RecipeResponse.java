package com.example.recipeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeResponse {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("recipes")
    @Expose
    public List<Recipe> recipeList = null;

    public RecipeResponse() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
