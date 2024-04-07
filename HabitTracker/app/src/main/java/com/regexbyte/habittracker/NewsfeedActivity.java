package com.regexbyte.habittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.net.Uri;
import android.os.Bundle;
import com.regexbyte.habittracker.Adapters.PostAdapter;
import com.regexbyte.habittracker.Adapters.StoryAdapter;
import com.regexbyte.habittracker.Models.PostModel;
import com.regexbyte.habittracker.Models.StoryModel;
import java.util.ArrayList;
import java.util.List;





public class NewsfeedActivity extends AppCompatActivity {


    private static final int REQUEST_GALLERY_IMAGE = 1;
    List<StoryModel> storyList;
    StoryAdapter storyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        RecyclerView recyclerView = findViewById(R.id.newsfeedRecyclerView);

        List<StoryModel> storyList = new ArrayList<>();
        storyList.add(new StoryModel(R.drawable.profilepic, "Faisal Nabi",true,1));
        storyList.add(new StoryModel(R.drawable.profilepic, "Kaleem",true,2));
        storyList.add(new StoryModel(R.drawable.profilepic, "Anas",true,3));
        storyList.add(new StoryModel(R.drawable.profilepic, "majid",true,4));
        storyList.add(new StoryModel(R.drawable.profilepic, "bacha",true,5));
        storyList.add(new StoryModel(R.drawable.profilepic, "huzaifa",true,6));

        StoryAdapter storyAdapter = new StoryAdapter(storyList, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(storyAdapter);


        RecyclerView recyclerViewfopost = findViewById(R.id.newsfeedRecyclerViewforpost);
        ArrayList<PostModel> postList = generateDummyPostData();
        PostAdapter adapter = new PostAdapter(postList, this);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewfopost.setLayoutManager(layoutManager2);
        recyclerViewfopost.setAdapter(adapter);
    }

    public ArrayList<PostModel> generateDummyPostData() {
        ArrayList<PostModel> dummyData = new ArrayList<>();
        List<Uri> dummyImageUris = generateDummyImageUris();  // Implement this method to generate dummy URIs
        PostModel postModel = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);
        PostModel postModel1 = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);
        PostModel postModel2 = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);

        dummyData.add(postModel);
        dummyData.add(postModel1);
        dummyData.add(postModel2);


        return dummyData;
    }


    private List<Uri> generateDummyImageUris() {
        List<Uri> dummyImageUris = new ArrayList<>();

//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));



        return dummyImageUris;
    }

}



