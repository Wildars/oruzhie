package com.example.android.miwok;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by katherinekuan on 4/14/16.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter( FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PistolFragment();
        } else if (position == 1) {
            return new AssaultRifleFragment();
        } else if (position == 2) {
            return new AmmpFragment();
        } else {
            return new SniperRifleFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Pistols";
        } else if (position == 1) {
            return "Rifles";
        } else if (position == 2) {
            return "Ammunation";
        } else {
            return "Sniper";
        }
    }
}