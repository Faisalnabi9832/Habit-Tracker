package com.regexbyte.habittracker.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.regexbyte.habittracker.Models.StoryModel;
import com.regexbyte.habittracker.R;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_ADD_STORY = 0;
    private static final int VIEW_TYPE_NORMAL_STORY = 1;

    private final List<StoryModel> storyList;
    private final Context context;

    public StoryAdapter(List<StoryModel> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ADD_STORY) {
            View addStoryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_story_item, parent, false);
            return new AddStoryViewHolder(addStoryView);
        } else {
            View normalStoryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
            return new NormalStoryViewHolder(normalStoryView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_NORMAL_STORY) {
            NormalStoryViewHolder normalHolder = (NormalStoryViewHolder) holder;
            StoryModel story = storyList.get(position - 1); // Adjust position for the header
            normalHolder.bind(story);
        } else {
            AddStoryViewHolder addStoryHolder = (AddStoryViewHolder) holder;
            addStoryHolder.addImage.setOnClickListener(view -> {

                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                ((Activity) context).startActivityForResult(galleryIntent, position);
            });
        }
    }

    @Override
    public int getItemCount() {
        return storyList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? VIEW_TYPE_ADD_STORY : VIEW_TYPE_NORMAL_STORY;
    }

    public static class AddStoryViewHolder extends RecyclerView.ViewHolder {
        ImageView addImage;
        TextView textView;

        public AddStoryViewHolder(@NonNull View itemView) {
            super(itemView);
            addImage = itemView.findViewById(R.id.addimage);
            textView = itemView.findViewById(R.id.textViewBelowImage);
        }
    }

    public static class NormalStoryViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImage;
        TextView userName;

        public NormalStoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImage = itemView.findViewById(R.id.circularImageViewfornewfeed);
            userName = itemView.findViewById(R.id.textViewBelowImage);
        }

        public void bind(StoryModel story) {
            // Bind your normal story data here
            storyImage.setImageResource(story.getStoryImage());
            userName.setText(story.getUserName());
        }
    }
}
