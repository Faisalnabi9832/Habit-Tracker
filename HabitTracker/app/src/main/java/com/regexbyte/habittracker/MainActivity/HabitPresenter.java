package com.regexbyte.habittracker.MainActivity;

import android.content.Context;


import com.regexbyte.habittracker.Base.BasePresenter;
import com.regexbyte.habittracker.Models.HabitData;
import com.regexbyte.habittracker.R;

import java.util.ArrayList;

public class HabitPresenter extends BasePresenter<HabitView> {


    public HabitPresenter(Context context) {
        super(context);
    }




    public void loadHabits() {
        ArrayList<HabitData> dummyData = generateDummyData();
        ifViewAttached(view -> view.showHabits(dummyData));
    }



    public ArrayList<HabitData> generateDummyData() {
        ArrayList<HabitData> dummyData = new ArrayList<>();


        dummyData.add(new HabitData("Habit 1", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 2", "2024-01-02", "2", "12:00", "2", "2", "2", "2", "2", "2", "4", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 3", "2024-01-03", "3", "15:00", "1", "2", "1", "2", "1", "2", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 4", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 5", "2024-01-02", "2", "12:00", "2", "2", "2", "2", "2", "2", "2", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 6", "2024-01-03", "3", "15:00", "1", "2", "1", "2", "1", "2", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 7", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 8", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 9", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 10", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 11", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 12", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));
        dummyData.add(new HabitData("Habit 13", "2024-01-01", "1", "10:00", "1", "1", "1", "1", "1", "1", "1", R.drawable.logo_transparent));


        return dummyData;
    }
}
