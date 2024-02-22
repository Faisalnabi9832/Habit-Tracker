package com.regexbyte.habittracker.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.regexbyte.habittracker.Models.ModelforRewards;
import com.regexbyte.habittracker.R;

public class DialogforRewrds extends DialogFragment {

    private EditText editTextcount, description, title;
    private TextView buttonSaveNotes;
    private ImageView imageViewClose;

    private MyDialogListener dialogListener;

    public DialogforRewrds(MyDialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialoglayoutforrewards, container, false);

        editTextcount = rootView.findViewById(R.id.editTextcount);
        description = rootView.findViewById(R.id.editTexttaskDescription);
        title = rootView.findViewById(R.id.editTextrewardtitle);
        buttonSaveNotes = rootView.findViewById(R.id.buttonSaveNotes);
        imageViewClose = rootView.findViewById(R.id.imageViewClose);

        buttonSaveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveRewards();
            }
        });

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }

    private void onSaveRewards() {
        String count = editTextcount.getText().toString();
        String desc = description.getText().toString();
        String rewardTitle = title.getText().toString();

        ModelforRewards rewards = new ModelforRewards(count, desc, rewardTitle);
        dialogListener.onSaveRewards(rewards);

        dismiss();
    }

    public interface MyDialogListener {
        void onSaveRewards(ModelforRewards rewards);
    }
}
