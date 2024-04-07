package com.regexbyte.habittracker.fragmnet;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.regexbyte.habittracker.Adapters.NotesAdapter;
import com.regexbyte.habittracker.Models.Modelfornotes;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.Dialog.DialogforNotes;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;
import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment implements DialogforNotes.MyDialogListener, NotesAdapter.NotessAdapterListener {

    private List<Modelfornotes> notesList;
    private NotesAdapter notesAdapter;
    private FloatingActionButton fabNotes;
    private RecyclerView recyclerfornotes;
    private TextView noNotesTextView;
    private TextView createNotesTextView;
    private TextView newNotesTextView;
    private LifecycleOwner lifecycleOwner;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notes, container, false);
        recyclerfornotes = rootView.findViewById(R.id.recyclerfornotes);
        recyclerfornotes.setLayoutManager(new LinearLayoutManager(getContext()));
        notesList = new ArrayList<>();
        notesAdapter = new NotesAdapter(getContext(), notesList);
        notesAdapter.setListener(this);
        recyclerfornotes.setAdapter(notesAdapter);

        fabNotes = rootView.findViewById(R.id.fabnotes);
        noNotesTextView = rootView.findViewById(R.id.noNotesTextView);
        createNotesTextView = rootView.findViewById(R.id.createNotesTextView);
        newNotesTextView = rootView.findViewById(R.id.newNotesTextView);

        fabNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotesBalloon();
            }
        });

        newNotesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotesBalloon();
            }
        });

        updateViewVisibility();

        return rootView;
    }

    private void openNotesBalloon() {
        Balloon balloon = new Balloon.Builder(getContext())
                .setLayout(R.layout.dialogfornotes)
                .setArrowSize(10)
                .setArrowOrientation(ArrowOrientation.TOP)
                .setWidthRatio(0.55f)
                .setHeight(BalloonSizeSpec.WRAP)
                .setCornerRadius(4f)
                .setBackgroundColor(ContextCompat.getColor(getContext(), R.color.black))
                .setBalloonAnimation(BalloonAnimation.ELASTIC)
                .setLifecycleOwner(lifecycleOwner)
                .build();
        balloon.showAlignTop(fabNotes);
    }

    @Override
    public void onSaveNotes(Modelfornotes notes) {
        notesList.add(notes);
        notesAdapter.notifyDataSetChanged();
        updateViewVisibility();
    }
    public void onDeleteClick(int position) {
        if (position >= 0 && position < notesList.size()) {
            notesList.remove(position);
            notesAdapter.notifyItemRemoved(position);
            updateViewVisibility();
        } else {
            Log.e("Delete", "Invalid position for delete: " + position);
        }
    }

    private void updateViewVisibility() {
        if (notesList.isEmpty()) {
            recyclerfornotes.setVisibility(View.GONE);
            noNotesTextView.setVisibility(View.VISIBLE);
            createNotesTextView.setVisibility(View.VISIBLE);
            newNotesTextView.setVisibility(View.VISIBLE);
        } else {
            recyclerfornotes.setVisibility(View.VISIBLE);
            noNotesTextView.setVisibility(View.GONE);
            createNotesTextView.setVisibility(View.GONE);
            newNotesTextView.setVisibility(View.GONE);
        }
    }
}
