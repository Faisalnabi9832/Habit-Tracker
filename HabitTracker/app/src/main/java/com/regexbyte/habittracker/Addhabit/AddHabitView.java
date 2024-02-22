package com.regexbyte.habittracker.Addhabit;

import com.regexbyte.habittracker.Base.BaseView;
import com.regexbyte.habittracker.Models.AddhabitModel;

import java.util.ArrayList;
import java.util.List;

public interface AddHabitView extends BaseView {

        void showHabits(ArrayList<AddhabitModel> habitList);
    void onHabitItemClick(AddhabitModel habitModel);

    }


