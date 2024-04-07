package com.regexbyte.habittracker.fragmnet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.regexbyte.habittracker.R;

public class Tagsfragmnet extends Fragment {

    public Tagsfragmnet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tagsfragmnet, container, false);
    }
}