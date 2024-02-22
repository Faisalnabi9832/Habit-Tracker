package com.regexbyte.habittracker.fragmnet;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.regexbyte.habittracker.Adapters.NotesAdapter;
import com.regexbyte.habittracker.Models.Modelfornotes;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.Dialog.DialogforNotes;
import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment implements DialogforNotes.MyDialogListener, NotesAdapter.NotessAdapterListener {

    private List<Modelfornotes> notesList;
    private NotesAdapter notesAdapter;
    private FloatingActionButton fabNotes;
    RecyclerView  recyclerfornotes;
    private boolean isClockwiseRotation = true;
    private TextView noNotesTextView;
    private TextView createNotesTextView;
    private TextView newNotesTextView;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
                rotateFab();
                openNotesDialog();
            }
        });
        newNotesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotesDialog();

            }
        });
        updateViewVisibility();

        return rootView;
    }

    private void rotateFab() {
        float fromDegrees, toDegrees;

        if (isClockwiseRotation) {
            fromDegrees = 300;
            toDegrees =0;
        } else {
            fromDegrees = 300;
            toDegrees = 0;
        }

        RotateAnimation rotateAnimation = new RotateAnimation(
                fromDegrees, toDegrees,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(300);
        rotateAnimation.setFillAfter(true);
        fabNotes.startAnimation(rotateAnimation);

        isClockwiseRotation = !isClockwiseRotation;
    }

    private void openNotesDialog() {
        DialogforNotes notesDialog = new DialogforNotes(this);
        notesDialog.show(getParentFragmentManager(), "NotesDialog");
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

    @Override
    public void onSaveNotes(Modelfornotes notes) {
        notesList.add(notes);
        notesAdapter.notifyDataSetChanged();
        updateViewVisibility();
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
