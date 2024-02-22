package com.regexbyte.habittracker.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.regexbyte.habittracker.Models.Modelfornotes;
import com.regexbyte.habittracker.R;

public class DialogforNotes extends DialogFragment {

    private EditText editTextnotes;
    private TextView buttonSaveNotes;
    private ImageView imageViewClose;

    private MyDialogListener dialogListener;

    public DialogforNotes(MyDialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfornotes, container, false);

        editTextnotes = rootView.findViewById(R.id.edtfordialognotes);
        buttonSaveNotes = rootView.findViewById(R.id.buttonSaveNotes);
        imageViewClose = rootView.findViewById(R.id.imageViewClose);

        buttonSaveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveNotes();
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

    private void onSaveNotes() {
        String notesText = editTextnotes.getText().toString();

        Modelfornotes notes = new Modelfornotes(notesText);
        dialogListener.onSaveNotes(notes);

        dismiss();
    }

    public interface MyDialogListener {
        void onSaveNotes(Modelfornotes notes);
    }
}
