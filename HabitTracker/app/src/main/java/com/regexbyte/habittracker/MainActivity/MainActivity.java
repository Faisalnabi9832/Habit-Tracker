package com.regexbyte.habittracker.MainActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.regexbyte.habittracker.Adapters.HabitAdapter;
import com.regexbyte.habittracker.Adapters.HabitViewHolder.HabitViewHolder;

import com.regexbyte.habittracker.Addhabit.Addhabitactivity;
import com.regexbyte.habittracker.Base.BaseActivity;
import com.regexbyte.habittracker.Models.HabitData;
import com.regexbyte.habittracker.NavigationIconClickListener;
import com.regexbyte.habittracker.NewsfeedActivity;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.Utils.RecyclerItemTouchHelper;
import java.util.ArrayList;



public class MainActivity extends BaseActivity<HabitView, HabitPresenter> implements HabitView, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{

    RecyclerView recycler_view_habits;
    HabitAdapter habitAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View rootView = findViewById(android.R.id.content);
        setUpToolbar(rootView);

        initRecyclerView();
        presenter.loadHabits();
    }

    @NonNull
    @Override
    public HabitPresenter createPresenter() {
        if (presenter==null)
        {
            return new HabitPresenter(this);
        }
        return  presenter;
    }


    @Override
    public void showHabits(ArrayList<HabitData> habits) {
        habitAdapter.setList(habits);

    }


    public void initRecyclerView() {
        recycler_view_habits = findViewById(R.id.recycler_view_habits);
        habitAdapter = new HabitAdapter();

        habitAdapter.setCallback(new HabitAdapter.Callback() {
            @Override
            public void onLongItemClick(View view, int position, CheckBox checkBox) {

            }

            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onDownloadClick(String eic, View view, int position, TextView textView) {

            }

            @Override
            public void onCheckBoxClick(View view, int position, CheckBox checkBox) {

            }

            @Override
            public void onCancelClick(int itemId, View view, int position, ImageButton textView) {

            }


        });

        recycler_view_habits.setAdapter(habitAdapter);
        recycler_view_habits.setNestedScrollingEnabled(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recycler_view_habits.setLayoutManager(layoutManager);
        recycler_view_habits.addItemDecoration(new DividerItemDecoration(recycler_view_habits.getContext(),
                ((LinearLayoutManager) recycler_view_habits.getLayoutManager()).getOrientation()));

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recycler_view_habits);

    }
    @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
    return true;
  }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String selectedMenuIdString = (String) item.getTitleCondensed();

        if (selectedMenuIdString.equals("Search")) {
            doThis(item);
            openAddHabitActivity();
            return true;
        } else if (selectedMenuIdString.equals("Filter")) {
            doThis(item);
            Intent intent = new Intent(this, NewsfeedActivity.class);
            startActivity(intent);


        }
        return true;
    }

    public void doThis(MenuItem item) {
        Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
    }


    private void openAddHabitActivity() {

        Intent intent = new Intent(this, Addhabitactivity.class);
        startActivity(intent);
    }

    private void setUpToolbar(View view) {
        final Toolbar toolbar = view.findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
                this,
                view.findViewById(R.id.product_grid),
                new AccelerateDecelerateInterpolator(),
                getResources().getDrawable(R.drawable.shr_branded_menu),
                getResources().getDrawable(R.drawable.shr_close_menu)));
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

        if (viewHolder instanceof HabitViewHolder) {


            if (direction == 4) {
                habitAdapter.removeitem(position);
                showToast("complete");
            } else if (direction == 8) {
                habitAdapter.removeitem(position);
                showToast("Incomplete");
            }




        }
    }


}
