package com.regexbyte.habittracker.MainActivity;

import com.regexbyte.habittracker.Base.BaseView;
import com.regexbyte.habittracker.Models.HabitData;

import java.util.ArrayList;

public interface HabitView extends BaseView {

    void showHabits(ArrayList<HabitData> habits);
    void showToast(String message);


}
