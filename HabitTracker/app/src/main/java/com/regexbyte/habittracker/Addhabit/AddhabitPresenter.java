package com.regexbyte.habittracker.Addhabit;
import android.content.Context;
import com.regexbyte.habittracker.Base.BasePresenter;
import com.regexbyte.habittracker.Models.AddhabitModel;
import com.regexbyte.habittracker.R;
import java.util.ArrayList;

public class AddhabitPresenter extends BasePresenter<AddHabitView> {


    public AddhabitPresenter(Context context) {
        super(context);
    }


    public void loadHabits() {
        ArrayList<AddhabitModel> dummyData = getDummyData();
        ifViewAttached(view -> view.showHabits(dummyData));
    }



    private ArrayList<AddhabitModel> getDummyData() {
        ArrayList<AddhabitModel> dataList = new ArrayList<>();
        dataList.add(new AddhabitModel(R.drawable.profilepic, "football",0));
        dataList.add(new AddhabitModel(R.drawable.profilepic, "basketball",1));
        dataList.add(new AddhabitModel(R.drawable.profilepic, "chat",2));
        dataList.add(new AddhabitModel(R.drawable.profilepic, "Reminder",3));
        dataList.add(new AddhabitModel(R.drawable.profilepic, "book reading",4));
        dataList.add(new AddhabitModel(R.drawable.profilepic, "playing cricket",5));
        dataList.add(new AddhabitModel(R.drawable.profilepic, "prayer time",6));

        return dataList;
    }
}
