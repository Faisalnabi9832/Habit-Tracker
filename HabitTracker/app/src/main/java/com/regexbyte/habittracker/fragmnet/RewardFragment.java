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
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.regexbyte.habittracker.Adapters.RewardsAdapter;
import com.regexbyte.habittracker.Dialog.DialogforRewrds;
import com.regexbyte.habittracker.Models.ModelforRewards;
import com.regexbyte.habittracker.R;
import java.util.ArrayList;
import java.util.List;

public class RewardFragment extends Fragment implements DialogforRewrds.MyDialogListener, RewardsAdapter.RewardsAdapterListener {

    private List<ModelforRewards> rewardsList;
    RecyclerView recyclerforrewrds;
    private RewardsAdapter rewardsAdapter;
    private boolean isClockwiseRotation = true;
    private FloatingActionButton fabRewards;
    private TextView noRewardsTextView;
    private TextView createNotesTextView;
    private TextView newRewardsTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reward_fragmnet, container, false);

        recyclerforrewrds = rootView.findViewById(R.id.recyclerforrewrds);
        recyclerforrewrds.setLayoutManager(new LinearLayoutManager(getContext()));

        rewardsList = new ArrayList<>();
        rewardsAdapter = new RewardsAdapter(getContext(), rewardsList);
        rewardsAdapter.setListener(this);
        recyclerforrewrds.setAdapter(rewardsAdapter);

        fabRewards = rootView.findViewById(R.id.fabRewards);
        noRewardsTextView = rootView.findViewById(R.id.noRewardsTextView);
        createNotesTextView = rootView.findViewById(R.id.createrewardsTextView);
        newRewardsTextView = rootView.findViewById(R.id.newRewardsTextView);

        fabRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateFab();
                openRewardsDialog();
            }
        });

        newRewardsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "New Rewards Clicked", Toast.LENGTH_SHORT).show();
                openRewardsDialog();
            }
        });


        updateViewVisibility();

        return rootView;
    }

    private void openRewardsDialog() {

        DialogforRewrds rewardsDialog = new DialogforRewrds(this);
        rewardsDialog.show(getParentFragmentManager(), "RewardsDialog");
    }


    @Override
    public void onSaveRewards(ModelforRewards rewards) {
        rewardsList.add(rewards);
        rewardsAdapter.notifyDataSetChanged();
        updateViewVisibility();
    }

    @Override
    public void onDeleteClick(int position) {
        if (position >= 0 && position < rewardsList.size()) {
            rewardsList.remove(position);
            rewardsAdapter.notifyItemRemoved(position);
            updateViewVisibility();
        } else {
            Log.e("Delete", "Invalid position for delete: " + position);
        }
    }

    private void rotateFab() {
        float fromDegrees, toDegrees;

        if (isClockwiseRotation) {
            fromDegrees = 0;
            toDegrees = 300;
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
        fabRewards.startAnimation(rotateAnimation);

        isClockwiseRotation = !isClockwiseRotation;
    }

    private void updateViewVisibility() {
        if (rewardsList.isEmpty()) {
            recyclerforrewrds.setVisibility(View.GONE);
            noRewardsTextView.setVisibility(View.VISIBLE);
            createNotesTextView.setVisibility(View.VISIBLE);
            newRewardsTextView.setVisibility(View.VISIBLE);
        } else {
            recyclerforrewrds.setVisibility(View.VISIBLE);
            noRewardsTextView.setVisibility(View.GONE);
            createNotesTextView.setVisibility(View.GONE);
            newRewardsTextView.setVisibility(View.GONE);
        }
    }
}
