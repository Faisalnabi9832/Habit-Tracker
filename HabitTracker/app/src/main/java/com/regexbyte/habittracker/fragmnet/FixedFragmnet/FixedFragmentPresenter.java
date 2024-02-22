package com.regexbyte.habittracker.fragmnet.FixedFragmnet;

import android.content.Context;
import com.regexbyte.habittracker.Base.BasePresenter;

public class FixedFragmentPresenter extends BasePresenter<FixedFragmnetView> {
    public FixedFragmentPresenter(Context context) {
        super(context);

    }
    protected void setStartDate(){
        ifViewAttached(view -> {

            view.showDatePickerDialog(view.getStartDateView());
        });
    }
    protected void setEndDate(){
        ifViewAttached(view -> {
            view.showDatePickerDialog(view.getEndDateView());
        });
    }
    protected  void recyclerview(){
        ifViewAttached(view -> {
            view.onRecyclerButtonClick();
        });

    }
}
