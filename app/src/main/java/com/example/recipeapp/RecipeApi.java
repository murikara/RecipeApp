package com.example.recipeapp;

import com.example.recipeapp.model.RecipeHead;
import com.example.recipeapp.model.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.*;

public interface RecipeApi {

    String KEY = "8c18cd2a48750efab56e23a108a01423";

    @GET("search?key=" + KEY + "&count=3")
    Call<RecipeResponse> getThreeTopRecipes();

    @GET("get?key=" + KEY)
    Call<RecipeHead> getRecipeInfo(@Query("rId") String recipeId);
}
