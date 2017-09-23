package com.example.paulapariselias.thirdtest.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.paulapariselias.thirdtest.views.FavoriteFragment;
import com.example.paulapariselias.thirdtest.views.PokemonsFragment;


public class PagerAdapter extends FragmentPagerAdapter {



    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PokemonsFragment.newInstance();
            case 1:
                return FavoriteFragment.newIntance();

            default:
                return PokemonsFragment.newInstance();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "POKEMONS";
            case 1:
                return "FAVORITE POKEMONS";

        }
        return null;
    }

}

