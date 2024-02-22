package com.regexbyte.habittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;


import com.google.android.material.tabs.TabLayout;
import com.regexbyte.habittracker.Utils.ViewPager;
import com.regexbyte.habittracker.fragmnet.DailyFragmnet.Dailyfragment;

public class HabitgoalActivity extends AppCompatActivity {

    TabLayout tab;
    androidx.viewpager.widget.ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitgoal);
        Toolbar toolbar = findViewById(R.id.app_bar2);
        setSupportActionBar(toolbar);
        TextView textViewNext = findViewById(R.id.textViewNext);
        textViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HabitgoalActivity.this, HabitGoalActivity2.class);
                startActivity(intent);
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // Retrieve category ID from the Intent
        String categoryId = getIntent().getStringExtra("categoryId");

        // Check if the categoryId is not null
        if (categoryId != null) {
            // Pass the category ID to the Dailyfragment
            Dailyfragment dailyfragment = new Dailyfragment();
            Bundle bundle = new Bundle();
            bundle.putString("categoryId", categoryId);
            dailyfragment.setArguments(bundle);


            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, dailyfragment)
                    .commit();
        }


        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);

        ViewPager adapter = new ViewPager(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
    }
}
