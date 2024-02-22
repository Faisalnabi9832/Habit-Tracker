package com.regexbyte.habittracker.fragmnet.DailyFragmnet;
import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.regexbyte.habittracker.Adapters.TimerAdapter;
import com.regexbyte.habittracker.Base.BaseFragment;
import com.regexbyte.habittracker.Models.TimerModel;
import com.regexbyte.habittracker.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Dailyfragment extends BaseFragment<DailyFragmentView, DailyFragmentPresenter>
        implements DailyFragmentView ,View.OnClickListener{

    private EditText editTextStartDate;
    private EditText editTextEndDate;
    private Button btn_recycler;
    private ArrayList<TimerModel> listtimer;
    private RecyclerView recyclerView;
    private TimerAdapter timerAdapter;
    Calendar calendar;
    private String categoryId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dailyfragment, container, false);

        btn_recycler = view.findViewById(R.id.btn_recycler);
        editTextEndDate = view.findViewById(R.id.editTextEndDate);
        editTextStartDate = view.findViewById(R.id.editTextStartDate);
        recyclerView = view.findViewById(R.id.recyclertimer);
        calendar = Calendar.getInstance();

        listtimer = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        TimerModel timerModel = new TimerModel();
        timerModel.setTime(setDefaultTime());
        timerModel.setTitle("Default");
        listtimer.add(timerModel);

        timerAdapter = new TimerAdapter(getContext(), listtimer);

        recyclerView.setAdapter(timerAdapter);


        btn_recycler.setOnClickListener(this);
        editTextStartDate.setOnClickListener(this);
        editTextEndDate.setOnClickListener(this);
        btn_recycler.setOnClickListener(this);

        // Retrieve categoryId from arguments
        Bundle arguments = getArguments();
        if (arguments != null) {
            categoryId = arguments.getString("categoryId", "default_value");
        }




        setDefaultDates();
        return view;
    }


    @Override
    public void onRecyclerButtonClick() {

    }

    @Override
   public void showDatePickerDialog(EditText editText) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        editText.setText(String.format(Locale.US, "%04d-%02d-%02d", year, month + 1, dayOfMonth));
                    }
                },
                year, month, day
        );


        datePickerDialog.show();
    }

    @Override
    public EditText getStartDateView() {
        return editTextStartDate;
    }

    @Override
    public EditText getEndDateView() {
        return editTextEndDate;
    }

    private String setDefaultTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.US);
        return timeFormat.format(calendar.getTime());
    }
    private void setDefaultDates() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);


        editTextStartDate.setText(dateFormat.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH, 8);
        editTextEndDate.setText(dateFormat.format(calendar.getTime()));
    }






    @NonNull
    @Override
    public DailyFragmentPresenter createPresenter() {
        if (presenter==null)
        {
            return new DailyFragmentPresenter(getContext());
        }
        return  presenter;
    }


    @Override
    public void showFancyDialog(String title, String descr, Drawable image) {

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.editTextStartDate){


            showDatePickerDialog(editTextStartDate);

        } else if (id==R.id.editTextEndDate) {
            showDatePickerDialog(editTextEndDate);


        } else if (id==R.id.btn_recycler) {



            TimerModel timerModel=new TimerModel();
                timerModel.setTime(setDefaultTime());
                timerModel.setTitle("Default");
                listtimer.add(timerModel);

                timerAdapter.notifyDataSetChanged();



        }


    }
}
