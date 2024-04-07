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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.regexbyte.habittracker.Models.StoryModel;
import com.regexbyte.habittracker.R;
import com.regexbyte.habittracker.UserprofileActivity;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == VIEW_TYPE_ADD_STORY) {
            View addStoryView = inflater.inflate(R.layout.add_story_item, parent, false);
            return new AddStoryViewHolder(addStoryView);
        } else {
            View normalStoryView = inflater.inflate(R.layout.item_story, parent, false);
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
            addStoryHolder.bind(context, position);
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

    public class AddStoryViewHolder extends RecyclerView.ViewHolder {
        CircleImageView addImage;
        TextView textView;

        public AddStoryViewHolder(@NonNull View itemView) {
            super(itemView);
            addImage = itemView.findViewById(R.id.storyphoto); // Change to the appropriate ID
            textView = itemView.findViewById(R.id.textViewBelowImage);
        }

        public void bind(Context context, int position) {
            addImage.setOnClickListener(view -> {
                // Open the gallery to pick an image
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                ((Activity) context).startActivityForResult(galleryIntent, position);
            });

            // Handle click to view the selected image in fullscreen
            addImage.setOnLongClickListener(v -> {
                // Do nothing or provide appropriate action
                return true; // Consume the long click event
            });
        }

        // Add this method to change the border color dynamically
        public void setBorderColor(int colorResId) {
            addImage.setBorderColor(ContextCompat.getColor(itemView.getContext(), colorResId));
        }
    }

    public class NormalStoryViewHolder extends RecyclerView.ViewHolder {
        ImageView storyImage;
        TextView userName;

        public NormalStoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImage = itemView.findViewById(R.id.circularImageViewfornewfeed);
            userName = itemView.findViewById(R.id.textViewBelowImage);

            // Inside NormalStoryViewHolder class
            itemView.setOnClickListener(v -> {
                // Get the StoryModel associated with this position
                StoryModel selectedStory = storyList.get(getAdapterPosition() - 1);

                // Get the user ID and name
                int userId = selectedStory.getUserId(); // Assuming you have a method to get the user ID
                String userName = selectedStory.getUserName();
                // Assuming you have a method to get the user name

                // Pass the user ID and name to the UserprofileActivity
                Intent intent = new Intent(context, UserprofileActivity.class);
                intent.putExtra("userId", userId);
                intent.putExtra("userName", userName);

                context.startActivity(intent);
            });
        }

        public void bind(StoryModel story) {
            // Bind your normal story data here
            storyImage.setImageResource(story.getStoryImage());
            userName.setText(story.getUserName());
        }
    }



//        private void openFullscreenImageView(Context context, Uri imageUri) {
//            // Create a FragmentTransaction to show the fullscreen image
//            FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            storyviewfragment fragment = storyviewfragment.newInstance(imageUri);
//            fragmentTransaction.replace(android.R.id.content, fragment);  // Use replace instead of add
//            fragmentTransaction.addToBackStack(null);
//            fragmentTransaction.commit();
//        }
    }

