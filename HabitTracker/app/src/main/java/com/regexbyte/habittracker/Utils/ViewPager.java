package com.regexbyte.habittracker.Utils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.regexbyte.habittracker.fragmnet.DailyFragmnet.Dailyfragment;

import com.regexbyte.habittracker.fragmnet.FixedFragmnet.FixedFragmnet;

public class ViewPager extends FragmentPagerAdapter {
    public ViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Dailyfragment();
        } else if (position == 1) {
            return new FixedFragmnet();
        }


        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Daily";
        } else if (position == 1) {
            return "Fixed";
        }

        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
