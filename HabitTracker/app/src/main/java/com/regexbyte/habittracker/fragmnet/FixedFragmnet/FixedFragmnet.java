package com.regexbyte.habittracker.fragmnet.FixedFragmnet;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class FixedFragmnet extends BaseFragment<FixedFragmnetView, FixedFragmentPresenter>
        implements FixedFragmnetView , View.OnClickListener{

    private EditText editTextStartDate;
    private EditText editTextEndDate;
    private Button btn_recycler;
    private ArrayList<TimerModel> listtimer;
    private RecyclerView recyclerView;
      private LinearLayout bottomLayout;
        private LinearLayout dateLayout;
    private TimerAdapter timerAdapter;
    Calendar calendar;
    Set<View> selectedDays = new HashSet<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixedfragmnet, container, false);

        btn_recycler = view.findViewById(R.id.btn_recyclerforfixed);
        editTextEndDate = view.findViewById(R.id.editTextEndDate);
        editTextStartDate = view.findViewById(R.id.editTextStartDate);
        recyclerView = view.findViewById(R.id.recyclertimerforfixed);



        TextView sundayButton = view.findViewById(R.id.sundayButton);

        TextView mondayButton = view.findViewById(R.id.mondayButton);
        TextView TuesdayButton = view.findViewById(R.id.tuesdayButton);
        TextView weddayButton = view.findViewById(R.id.wednesdayButton);
        TextView thursdayButton = view.findViewById(R.id.thursdayButton);
        TextView fridayButton = view.findViewById(R.id.fridayButton);
        TextView satdayButton = view.findViewById(R.id.saturdayButton);


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
        bottomLayout = view.findViewById(R.id.bottomLayout);
        dateLayout = view.findViewById(R.id.dateLayout);

        TextView dayTextView = view.findViewById(R.id.day);
        TextView dateTextView = view.findViewById(R.id.Date);

        dayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomLayout.setVisibility(View.GONE);
                dateLayout.setVisibility(View.VISIBLE);
            }
        });

        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomLayout.setVisibility(View.VISIBLE);
                dateLayout.setVisibility(View.GONE);
            }
        });

        sundayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayButtonClick(v);

            }
        });
        mondayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayButtonClick(v);

            }
        });
        TuesdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayButtonClick(v);

            }
        });
        weddayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayButtonClick(v);

            }
        });
        thursdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayButtonClick(v);

            }
        });
        fridayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayButtonClick(v);

            }
        });
        satdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDayButtonClick(v);

            }
        });













        setDefaultDates();
        return view;
    }
    public void onDayButtonClick(View view) {
        int accentColor = getResources().getColor(R.color.colorAccent);
        Drawable defaultColor = getResources().getDrawable(R.drawable.custom_switch_track);


        if (selectedDays.contains(view)) {

            view.setBackground(defaultColor);
            selectedDays.remove(view);
        } else {

            view.setBackgroundColor(accentColor);
            selectedDays.add(view);
        }
    }













    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.editTextStartDate){


            showDatePickerDialog(editTextStartDate);

        } else if (id==R.id.editTextEndDate) {
            showDatePickerDialog(editTextEndDate);


        } else if (id==R.id.btn_recyclerforfixed) {
            Toast.makeText(getContext(), "onclick", Toast.LENGTH_SHORT).show();


            TimerModel timerModel=new TimerModel();
            timerModel.setTime(setDefaultTime());
            timerModel.setTitle("Default");
            listtimer.add(timerModel);

            timerAdapter.notifyDataSetChanged();



        }


    }

    @NonNull
    @Override
    public FixedFragmentPresenter createPresenter() {
        if (presenter==null)
        {
            return new FixedFragmentPresenter(getContext());
        }
        return  presenter;
    }

    @Override
    public void showFancyDialog(String title, String descr, Drawable image) {

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

    @Override
    public void onRecyclerButtonClick() {

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




}
