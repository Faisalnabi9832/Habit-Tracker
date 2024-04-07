package com.regexbyte.habittracker.Adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.regexbyte.habittracker.Models.ModelforRewards;
import com.regexbyte.habittracker.R;

import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.ViewHolder> {

    private final Context context;
    private final List<ModelforRewards> rewardsList;
    private RewardsAdapterListener listener;

    public RewardsAdapter(Context context, List<ModelforRewards> rewardsList) {
        this.context = context;
        this.rewardsList = rewardsList;
    }

    public void setListener(RewardsAdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rewards, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelforRewards reward = rewardsList.get(position);

        // Set data to the views
        holder.textViewCount.setText(reward.getCount());
        holder.textViewDescription.setText(reward.getDescription());
        holder.textViewTitle.setText(reward.getTitle());

        // Use getAdapterPosition() to get the updated position
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (listener != null && adapterPosition != RecyclerView.NO_POSITION) {
                    listener.onDeleteClick(adapterPosition);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return rewardsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCount;
        TextView textViewDescription;
        TextView textViewTitle;
        ImageButton deleteButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCount = itemView.findViewById(R.id.textViewCount);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            deleteButton=itemView.findViewById(R.id.deleteButton);


        }
    }

    public interface RewardsAdapterListener {
        void onDeleteClick(int position);

    }
}
