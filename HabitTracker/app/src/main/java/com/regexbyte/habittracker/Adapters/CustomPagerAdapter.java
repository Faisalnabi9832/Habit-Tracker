package com.regexbyte.habittracker.Adapters;
import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.regexbyte.habittracker.fragmnet.NotesFragment;
import com.regexbyte.habittracker.fragmnet.RewardFragment;


public class CustomPagerAdapter extends FragmentStateAdapter {
    public CustomPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 0:
               return new RewardFragment();
           case 1:
               return new NotesFragment();
           default:
               return new RewardFragment();

       }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
