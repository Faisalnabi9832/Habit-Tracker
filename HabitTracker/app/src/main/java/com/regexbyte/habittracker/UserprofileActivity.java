package com.regexbyte.habittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.regexbyte.habittracker.Models.PostModel;
import com.regexbyte.habittracker.Utils.ViewPagerforprofile;

import java.util.ArrayList;
import java.util.List;

public class UserprofileActivity extends AppCompatActivity {
    TabLayout tabforprofile;
    ViewPager viewPagerforprofile;
    private ImageView userProfileImageView;
    private TextView usernameTextView;
    PostModel postModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        tabforprofile = findViewById(R.id.tabforprofile);
        viewPagerforprofile = findViewById(R.id.viewpagerforprofile);


        userProfileImageView = findViewById(R.id.userProfileImageView);
        usernameTextView = findViewById(R.id.usernameTextView);

        // Get user ID and name from intent extras
        int userId = getIntent().getIntExtra("userId", 1);
        String userName = getIntent().getStringExtra("userName");
        usernameTextView.setText(userName);

        ViewPagerforprofile adapter = new ViewPagerforprofile(getSupportFragmentManager());
        viewPagerforprofile.setAdapter(adapter);
        tabforprofile.setupWithViewPager(viewPagerforprofile);

        // Convert the postList to JSON string


        // Create a new instance of the Postfragmnet fragment and pass the postList as arguments


//        // Add the fragment to the container
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
////        Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic);
////        Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic);
////
////        List<Uri> dummyImageUris = new ArrayList<>();
////        dummyImageUris.add(uri1);
////        dummyImageUris.add(uri2);
//    }
//
//    private List<Uri> generateDummyImageUris() {
//        List<Uri> dummyImageUris = new ArrayList<>();
//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.profilepic));
//        return dummyImageUris;
//    }
//
//
//    public ArrayList<PostModel> generateDummyPostData() {
//        ArrayList<PostModel> dummyData = new ArrayList<>();
//        List<Uri> dummyImageUris = generateDummyImageUris();
//        PostModel postModel1 = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);
//        PostModel postModel2 = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);
//        dummyData.add(postModel1);
//        dummyData.add(postModel2);
//        return dummyData;
//    }
    }
}
