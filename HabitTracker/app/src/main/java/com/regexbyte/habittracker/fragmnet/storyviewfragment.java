package com.regexbyte.habittracker.fragmnet;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.regexbyte.habittracker.R;

public class storyviewfragment extends Fragment {

    private static final String ARG_IMAGE_URI = "imageUri";

    public storyviewfragment() {
        // Required empty public constructor
    }

    public static storyviewfragment newInstance(Uri imageUri) {
        storyviewfragment fragment = new storyviewfragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_IMAGE_URI, imageUri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.storyviewlayout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.imageFullscreen);

        if (getArguments() != null) {
            Uri imageUri = getArguments().getParcelable(ARG_IMAGE_URI);
            if (imageUri != null) {
                imageView.setImageURI(imageUri);
            }
        }
    }
}
