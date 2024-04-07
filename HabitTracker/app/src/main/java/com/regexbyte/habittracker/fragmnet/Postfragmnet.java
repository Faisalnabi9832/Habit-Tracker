package com.regexbyte.habittracker.fragmnet;







import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.regexbyte.habittracker.Adapters.ImageAdapter;

import com.regexbyte.habittracker.Adapters.PostAdapter;
import com.regexbyte.habittracker.Models.ImageModel;
import com.regexbyte.habittracker.Models.PostModel;
import com.regexbyte.habittracker.R;

import java.util.ArrayList;
import java.util.List;
public class Postfragmnet extends Fragment {
    private RecyclerView recyclerView;

    private List<Uri> imageUris;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_postfragmnet, container, false);

        RecyclerView recyclerViewforpost = view.findViewById(R.id.recyclerpostfragment);
        ArrayList<PostModel> postList = generateDummyPostData();
        PostAdapter adapter = new PostAdapter(postList, getContext());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewforpost.setLayoutManager(layoutManager2);
        recyclerViewforpost.setAdapter(adapter);

        return view;
    }
    public ArrayList<PostModel> generateDummyPostData() {
        ArrayList<PostModel> dummyData = new ArrayList<>();

        // Example usage in your activity or wherever you create instances of PostModel
        List<Uri> dummyImageUris = generateDummyImageUris();  // Implement this method to generate dummy URIs
        PostModel postModel = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);
        PostModel postModel1 = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);
        PostModel postModel2 = new PostModel("Username", "2 hours ago", R.drawable.profilepic, R.drawable.profilepic, false, dummyImageUris);

        dummyData.add(postModel);
        dummyData.add(postModel1);
        dummyData.add(postModel2);

        // Add the postModel instance to the dummyData list
        return dummyData;
    }

    private List<Uri> generateDummyImageUris() {
        List<Uri> dummyImageUris = new ArrayList<>();
        dummyImageUris.add(Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.drawable.profilepic));
        dummyImageUris.add(Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.drawable.profilepic));
//        dummyImageUris.add(Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.drawable.profilepic));
//        // Add more dummy URIs as needed
        return dummyImageUris;
    }
    }


