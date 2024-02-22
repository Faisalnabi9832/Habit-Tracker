package com.regexbyte.habittracker.fragmnet.DailyFragmnet;

import android.widget.EditText;

import com.regexbyte.habittracker.Base.BaseFragmentView;

public interface DailyFragmentView extends BaseFragmentView{


        void onRecyclerButtonClick();

     
    void showDatePickerDialog(EditText editText);

    EditText getStartDateView();
    EditText getEndDateView();


    }


