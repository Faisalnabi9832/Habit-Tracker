// PostAdapter.java
package com.regexbyte.habittracker.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.regexbyte.habittracker.Models.PostModel;
import com.regexbyte.habittracker.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<PostModel> postList;
    private Context context;
    private GestureDetector gestureDetector;
    private Handler clickHandler;
    private boolean isDoubleClick = false;

    public PostAdapter(List<PostModel> postList, Context context) {
        this.postList = postList;
        this.context = context;
        gestureDetector = new GestureDetector(context, new GestureListener());
        clickHandler = new Handler();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newfeed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostModel post = postList.get(position);



        holder.postedImageView.setOnTouchListener((v, event) -> {
            gestureDetector.onTouchEvent(event);
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if (isDoubleClick) {
                    handleDoubleClick(post, holder);
                    isDoubleClick = false;
                } else {
                    handleClick(post, holder);
                }
            }
            return true;
        });

        holder.commentButton.setOnClickListener(v -> showCommentDialog(post, holder));

        if (post.hasComments()) {
            displayComments(post.getComments(), holder);
        }

        holder.userProfileImageView.setImageResource(post.getUserProfileImage());
        holder.usernameTextView.setText(post.getUsername());
        holder.postedTimeTextView.setText(post.getPostedTime());
        holder.postedImageView.setImageResource(post.getPostedImage());


        if (post.getAllUserImages() != null && !post.getAllUserImages().isEmpty()) {
            displayUserImages(post.getFirstFourUserImages(), holder);
        }
        if (post.getAllUserImages() != null && !post.getAllUserImages().isEmpty()) {
            displayUserImages(post.getFirstFourUserImages(), holder);
        }

        holder.userImagesContainer.setOnClickListener(v -> {
            try {
                // Show a dialog with all user images
                showAllUserImagesDialog(post.getAllUserImages());
            } catch (Exception e) {
                Log.e("PostAdapter", "Error showing user images dialog", e);
            }
        });
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView userProfileImageView;
        TextView usernameTextView;
        TextView postedTimeTextView;
        ImageView postedImageView;
        ImageButton likeButton,likeButton2;
        ImageButton commentButton;
        TextView commentTextView;
        LinearLayout userImagesContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userProfileImageView = itemView.findViewById(R.id.userProfileImageView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            postedTimeTextView = itemView.findViewById(R.id.postedTimeTextView);
            postedImageView = itemView.findViewById(R.id.postedImageView);
            likeButton = itemView.findViewById(R.id.likeButton);
            likeButton2 = itemView.findViewById(R.id.likeButton2);
            commentButton = itemView.findViewById(R.id.commentButton);
            commentTextView = itemView.findViewById(R.id.commentTextView);
            userImagesContainer = itemView.findViewById(R.id.userImagesContainer);
            userImagesContainer.setClickable(true);
            userImagesContainer.setFocusable(true);
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            isDoubleClick = true;
            return true;
        }
    }

    private void showCommentDialog(PostModel post, ViewHolder holder) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Write a Comment");

        final EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            String userInput = input.getText().toString().trim();
            post.addComment(userInput);
            notifyDataSetChanged();
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void displayComments(List<String> comments, ViewHolder holder) {
        StringBuilder commentsText = new StringBuilder();
        for (String comment : comments) {
            commentsText.append(comment).append("\n");
        }
        holder.commentTextView.setText(commentsText.toString());
        holder.commentTextView.setVisibility(View.VISIBLE);
    }

    private void handleDoubleClick(PostModel post, ViewHolder holder) {
        post.setLiked(!post.isLiked());

        if (post.isLiked()) {
            // Liked, make red heart visible
            holder.likeButton.setVisibility(View.GONE);
            holder.likeButton2.setVisibility(View.VISIBLE);
        } else {
            // Unliked, make simple heart visible
            holder.likeButton.setVisibility(View.VISIBLE);
            holder.likeButton2.setVisibility(View.GONE);
        }
    }



    private void handleClick(PostModel post, ViewHolder holder) {
        int updatedLikeButtonColor = post.isLiked() ? R.color.colorAccent : R.color.whiteTextColor;
        holder.likeButton.setColorFilter(ContextCompat.getColor(context, updatedLikeButtonColor));
        // Handle single-click action, if needed
    }

    private void displayUserImages(List<Integer> userImages, ViewHolder holder) {
        try {
            Log.d("PostAdapter", "Displaying user images");
            holder.userImagesContainer.removeAllViews();

            int maxImagesToShow = 4; // Set the maximum number of images to show initially

            for (int i = 0; i < userImages.size(); i++) {
                CircleImageView userImageView = new CircleImageView(context);
                userImageView.setLayoutParams(new ViewGroup.LayoutParams(
                        (int) context.getResources().getDimension(R.dimen.user_image_size),
                        (int) context.getResources().getDimension(R.dimen.user_image_size)));
                userImageView.setImageResource(userImages.get(i));
                holder.userImagesContainer.addView(userImageView);

                if (i == maxImagesToShow - 1 && userImages.size() > maxImagesToShow) {
                    // Show a stacked view indicating more users
                    CircleImageView stackedView = new CircleImageView(context);
                    stackedView.setLayoutParams(new ViewGroup.LayoutParams(
                            (int) context.getResources().getDimension(R.dimen.user_image_size),
                            (int) context.getResources().getDimension(R.dimen.user_image_size)));
                    stackedView.setImageResource(R.drawable.layer); // Replace with your stacked image resource
                    stackedView.setPadding(10, 10, 10, 10);
                    stackedView.setOnClickListener(v -> {
                        try {
                            // Show a dialog with all user images
                            showAllUserImagesDialog(userImages);
                        } catch (Exception e) {
                            Log.e("PostAdapter", "Error showing user images dialog", e);
                        }
                    });
                    holder.userImagesContainer.addView(stackedView);
                    break;
                }
            }
        } catch (Exception e) {
            Log.e("PostAdapter", "Error displaying user images", e);
        }
    }
    private void showAllUserImagesDialog(List<Integer> userImages) {
        try {
            Log.d("PostAdapter", "showAllUserImagesDialog called");
            Log.d("PostAdapter", "UserImages size: " + userImages.size());

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Users who viewed the post");

            LinearLayout dialogLayout = new LinearLayout(context);
            dialogLayout.setOrientation(LinearLayout.VERTICAL);

            int maxVisibleImages = 4;  // Maximum number of images to be visible initially
            int totalImages = userImages.size();

            LinearLayout stackedLayout = new LinearLayout(context);
            stackedLayout.setOrientation(LinearLayout.VERTICAL);

            for (int i = 0; i < totalImages; i++) {
                CircleImageView userImageView = new CircleImageView(context);
                userImageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                userImageView.setImageResource(userImages.get(i));

                // Add username below the user image
                TextView usernameTextView = new TextView(context);
                usernameTextView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                usernameTextView.setText("User Name"); // Replace with actual username

                LinearLayout stackLayout = new LinearLayout(context);
                stackLayout.setOrientation(LinearLayout.VERTICAL);

                stackLayout.addView(userImageView);
                stackLayout.addView(usernameTextView);

                if (i < maxVisibleImages) {
                    stackedLayout.addView(stackLayout);
                } else {
                    // For images beyond the maxVisibleImages, hide the stackLayout
                    stackLayout.setVisibility(View.GONE);
                }

                // Set a click listener on each user image to show a detailed dialog
                final int currentIndex = i;
                userImageView.setOnClickListener(v -> {
                    Toast.makeText(context, "Viewer clicked", Toast.LENGTH_SHORT).show();
                    // Implement the action to show a detailed dialog with profile name and image
                    showUserProfileDialog("Faisl nabi", userImages.get(currentIndex)); // Replace with actual user details
                });
            }

            dialogLayout.addView(stackedLayout);

            // Add a "+5" button if there are more than maxVisibleImages images
            if (totalImages > maxVisibleImages) {
                Button showMoreButton = new Button(context);
                showMoreButton.setText("+5");
                showMoreButton.setOnClickListener(v -> {
                    // Show the next five hidden images
                    for (int i = maxVisibleImages; i < maxVisibleImages + 5 && i < totalImages; i++) {
                        stackedLayout.getChildAt(i).setVisibility(View.VISIBLE);
                    }
                    showMoreButton.setVisibility(View.GONE);
                });
                dialogLayout.addView(showMoreButton);
            }

            builder.setView(dialogLayout);

            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

            builder.show();
        } catch (Exception e) {
            Log.e("PostAdapter", "Error in showAllUserImagesDialog", e);
        }
    }


    // Method to show a detailed dialog with profile name and image
    private void showUserProfileDialog(String userName, int userImageResource) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(userName);

        CircleImageView userImageView = new CircleImageView(context);
        userImageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        userImageView.setImageResource(userImageResource);

        builder.setView(userImageView);

        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        builder.show();
    }


}
