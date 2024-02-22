package com.regexbyte.habittracker;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.regexbyte.habittracker.Adapters.CustomPagerAdapter;

public class HabitGoalActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_goal2);

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

}
