package com.example.recipeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipe implements Parcelable {

    @SerializedName("publisher")
    @Expose
    public String publisher;
    @SerializedName("f2f_url")
    @Expose
    public String f2fUrl;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("source_url")
    @Expose
    public String sourceUrl;
    @SerializedName("recipe_id")
    @Expose
    public String recipeId;
    @SerializedName("image_url")
    @Expose
    public String imageUrl;
    @SerializedName("social_rank")
    @Expose
    public Double socialRank;
    @SerializedName("publisher_url")
    @Expose
    public String publisherUrl;
    @SerializedName("ingredients")
    @Expose
    public List<String> ingredients;

    public Recipe() {
    }

    protected Recipe(Parcel in) {
        publisher = in.readString();
        f2fUrl = in.readString();
        title = in.readString();
        sourceUrl = in.readString();
        recipeId = in.readString();
        imageUrl = in.readString();
        if (in.readByte() == 0) {
            socialRank = null;
        } else {
            socialRank = in.readDouble();
        }
        publisherUrl = in.readString();
        ingredients = in.createStringArrayList();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "publisher='" + publisher + '\'' +
                ", f2fUrl='" + f2fUrl + '\'' +
                ", title='" + title + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", recipeId='" + recipeId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", socialRank=" + socialRank +
                ", publisherUrl='" + publisherUrl + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(publisher);
        dest.writeString(f2fUrl);
        dest.writeString(title);
        dest.writeString(sourceUrl);
        dest.writeString(recipeId);
        dest.writeString(imageUrl);
        if (socialRank == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(socialRank);
        }
        dest.writeString(publisherUrl);
        dest.writeStringList(ingredients);
    }
}
