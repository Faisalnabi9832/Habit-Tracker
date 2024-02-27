package com.regexbyte.habittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.regexbyte.habittracker.Adapters.PostAdapter;
import com.regexbyte.habittracker.Adapters.StoryAdapter;
import com.regexbyte.habittracker.Models.PostModel;
import com.regexbyte.habittracker.Models.StoryModel;
import java.util.ArrayList;
import java.util.List;




public class NewsfeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        RecyclerView recyclerView = findViewById(R.id.newsfeedRecyclerView);

        List<StoryModel> storyList = new ArrayList<>();
        storyList.add(new StoryModel(R.drawable.profilepic, "Faisal Nabi",true));
        storyList.add(new StoryModel(R.drawable.profilepic, "Kaleem",true));
        storyList.add(new StoryModel(R.drawable.profilepic, "anas",true));
        storyList.add(new StoryModel(R.drawable.profilepic, "majid",true));
        storyList.add(new StoryModel(R.drawable.profilepic, "bacha",true));
        storyList.add(new StoryModel(R.drawable.profilepic, "huzaifa",true));

        StoryAdapter storyAdapter = new StoryAdapter(storyList, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(storyAdapter);


        RecyclerView recyclerView2 = findViewById(R.id.newsfeedRecyclerViewforpost);
        ArrayList<PostModel> postList = generateDummyPostData();
        PostAdapter adapter = new PostAdapter(postList, this);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter);


    }
    public ArrayList<PostModel> generateDummyPostData() {
        ArrayList<PostModel> dummyData = new ArrayList<>();


        dummyData.add(new PostModel("Faisal Nabi","2 hours ago",R.drawable.profilepic,R.drawable.profilepic,false));
        dummyData.add(new PostModel("Faisal Nabi","2 hours ago",R.drawable.profilepic,R.drawable.profilepic,false));
        dummyData.add(new PostModel("Faisal Nabi","2 hours ago",R.drawable.profilepic,R.drawable.profilepic,false));
        dummyData.add(new PostModel("Faisal Nabi","2 hours ago",R.drawable.profilepic,R.drawable.profilepic,false));
        dummyData.add(new PostModel("Faisal Nabi","2 hours ago",R.drawable.profilepic,R.drawable.profilepic,false));
        dummyData.add(new PostModel("Faisal Nabi","2 hours ago",R.drawable.profilepic,R.drawable.profilepic,false));

        return dummyData;
    }
    }
