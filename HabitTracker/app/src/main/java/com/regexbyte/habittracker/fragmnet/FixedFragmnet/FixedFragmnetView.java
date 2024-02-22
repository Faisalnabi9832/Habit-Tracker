package com.regexbyte.habittracker.fragmnet.FixedFragmnet;

import android.widget.EditText;

import com.regexbyte.habittracker.Base.BaseFragmentView;

public interface FixedFragmnetView extends BaseFragmentView {

    void showDatePickerDialog(EditText editText);

    EditText getStartDateView();
    EditText getEndDateView();
    void onRecyclerButtonClick();

}
