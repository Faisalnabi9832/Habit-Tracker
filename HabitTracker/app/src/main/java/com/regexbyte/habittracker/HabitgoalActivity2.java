package com.regexbyte.habittracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.regexbyte.habittracker.Adapters.CustomPagerAdapter;

public class HabitgoalActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_goal2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textViewNext = findViewById(R.id.textViewNext);
        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the Save button click event
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TabLayout tabLayout = findViewById(R.id.tab2);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager2);

        viewPager2.setAdapter(new CustomPagerAdapter(this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                View customView = LayoutInflater.from(tabLayout.getContext())
                        .inflate(R.layout.custom_tab_layout, null);
                ImageView tabIcon = customView.findViewById(R.id.tabIcon);
                TextView tabText = customView.findViewById(R.id.tabText);

                switch (position) {
                    case 0: {
                        tabIcon.setImageResource(R.drawable.logo_transparent);
                        tabText.setText("Rewards");
                        break;
                    }
                    case 1: {
                        tabIcon.setImageResource(R.drawable.star_icon);
                        tabText.setText("Notes");
                        break;
                    }
                }

                tab.setCustomView(customView);
            }
        });

        tabLayoutMediator.attach();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
