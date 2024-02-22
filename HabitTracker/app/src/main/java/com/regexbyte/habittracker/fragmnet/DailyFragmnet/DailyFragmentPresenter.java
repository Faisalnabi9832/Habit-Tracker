package com.regexbyte.habittracker.fragmnet.DailyFragmnet;
import android.content.Context;
import com.regexbyte.habittracker.Base.BasePresenter;




public class DailyFragmentPresenter extends BasePresenter<DailyFragmentView> {


    public DailyFragmentPresenter(Context context) {
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
