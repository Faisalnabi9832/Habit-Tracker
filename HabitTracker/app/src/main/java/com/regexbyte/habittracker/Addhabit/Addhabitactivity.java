package com.regexbyte.habittracker.Addhabit;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.regexbyte.habittracker.Adapters.AddhabitAdapter;
import com.regexbyte.habittracker.Base.BaseActivity;
import com.regexbyte.habittracker.HabitgoalActivity;
import com.regexbyte.habittracker.Models.AddhabitModel;
import com.regexbyte.habittracker.R;
import java.util.ArrayList;



public class Addhabitactivity extends BaseActivity<AddHabitView, AddhabitPresenter> implements AddHabitView ,AddhabitAdapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private AddhabitAdapter adapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhabit);



        Toolbar toolbar = findViewById(R.id.app_bar2);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycleforaddhabit);
        adapter = new AddhabitAdapter(new ArrayList<>(), this,this);

// Now 'categoryIds' contains all unique category IDs

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);



        presenter.loadHabits();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuforraddhabit, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search2).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (adapter != null) {
                    adapter.filterList(newText);
                }
                return true;
            }

        });

        return true;
    }



    @NonNull
    @Override
    public AddhabitPresenter createPresenter() {
        if (presenter==null)
        {
            return new AddhabitPresenter(this);
        }
        return  presenter;
    }



    @Override
    public void showHabits(ArrayList<AddhabitModel> habitList) {
        adapter.setHabits(habitList);
    }

    @Override
    public void onHabitItemClick(AddhabitModel habitModel) {
        Toast.makeText(this, "Clicked: " + habitModel.getText(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemClick(AddhabitModel item) {
        String categoryId = String.valueOf(item.getCategoryId());
        Toast.makeText(this, "Category ID: " + categoryId, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Addhabitactivity.this, HabitgoalActivity.class);
        intent.putExtra("categoryId", categoryId);
        startActivity(intent);
    }




//
//    public void initRecyclerView() {
//        recyclerView = findViewById(R.id.recycleforaddhabit);
//        List<AddhabitModel> dummyData = getDummyData();
//        adapter = new AddhabitAdapter(dummyData, this);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        recyclerView.setAdapter(adapter);
//    }
//
//
//    private List<AddhabitModel> getDummyData() {
//        List<AddhabitModel> dataList = new ArrayList<>();
//        dataList.add(new AddhabitModel(R.drawable.star_icon, "football"));
//        dataList.add(new AddhabitModel(R.drawable.star_icon, "basketball"));
//        dataList.add(new AddhabitModel(R.drawable.star_icon, "chat"));
//        dataList.add(new AddhabitModel(R.drawable.star_icon, "Reminder"));
//        dataList.add(new AddhabitModel(R.drawable.star_icon, "book reading"));
//        dataList.add(new AddhabitModel(R.drawable.star_icon, "playing cricket"));
//        dataList.add(new AddhabitModel(R.drawable.star_icon, "prayer time"));
//
//        return dataList;
//    }







}
