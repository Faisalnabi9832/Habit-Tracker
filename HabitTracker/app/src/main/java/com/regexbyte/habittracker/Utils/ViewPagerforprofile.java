package com.regexbyte.habittracker.Utils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.regexbyte.habittracker.fragmnet.DailyFragmnet.Dailyfragment;

import com.regexbyte.habittracker.fragmnet.FixedFragmnet.FixedFragmnet;

import com.regexbyte.habittracker.fragmnet.Postfragmnet;
import com.regexbyte.habittracker.fragmnet.Tagsfragmnet;
import com.regexbyte.habittracker.fragmnet.Videosfragmnet;

public class ViewPagerforprofile extends FragmentPagerAdapter {
    public ViewPagerforprofile(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Postfragmnet();
        } else if (position == 1) {
            return new Videosfragmnet();
        } else if (position==2) {
            return new Tagsfragmnet();

        }


        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Post";
        } else if (position == 1) {
            return "Videos";
        } else if (position==2) {
            return "Tags";

        }

        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
