package com.example.recipeapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.recipeapp.model.Recipe;

import java.util.List;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private List<Recipe> recipeList;
    Fragment createdFragment;
    private static final String TAG = "SectionsPagerAdapter";

    public SectionsPagerAdapter(FragmentManager fm, List<Recipe> recipes) {
        super(fm);
        this.recipeList = recipes;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position, recipeList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        this.createdFragment = (Fragment) super.instantiateItem(container, position);
        return createdFragment;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return recipeList.size();
    }
}
