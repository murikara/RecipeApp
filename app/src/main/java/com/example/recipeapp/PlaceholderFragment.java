package com.example.recipeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.model.RecipeHead;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_RECIPE = "recipe";
    private View view;
    private TextView ingredientsView;
    private static final String TAG = "PlaceholderFragment";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber, Recipe recipe) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_RECIPE, recipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        this.view = rootView;
        // Get recipe from bundle
        Recipe recipe = getArguments().getParcelable(ARG_RECIPE);
        // Set image
        ImageView imageView = rootView.findViewById(R.id.recipeImageView);
        Glide.with(rootView).load(recipe.getImageUrl()).into(imageView);
        // Set title
        TextView titelView = rootView.findViewById(R.id.titleTextView);
        titelView.setText(recipe.getTitle());
        // Set ingredients
        ingredientsView = rootView.findViewById(R.id.ingredientsTextView);
        // Get Recipe information for ingredients
        getRecipeIngredients(recipe);

        return rootView;
    }

    @Override
    public View getView(){
        return this.view;
    }

    public void getRecipeIngredients(Recipe recipe) {
        RecipeApi api = ApiClient.getClient().create(RecipeApi.class);
        Call<RecipeHead> call = api.getRecipeInfo(recipe.getRecipeId());
        call.enqueue(new Callback<RecipeHead>() {
            @Override
            public void onResponse(Call<RecipeHead> call, Response<RecipeHead> response) {
                if(response.isSuccessful() && response.body() != null){
                    setRecipeIngredients(response.body().getRecipe());
                    Log.e(TAG, "onResponse: GOT INGREDIENTS!! " );
                }
            }

            @Override
            public void onFailure(Call<RecipeHead> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void setRecipeIngredients(Recipe recipe){
        String ingredientsText = TextUtils.join("\n", recipe.getIngredients());
        ingredientsView.setText(ingredientsText);
    }
}
