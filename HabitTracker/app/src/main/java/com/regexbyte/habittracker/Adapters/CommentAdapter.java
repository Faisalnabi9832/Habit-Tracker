package com.regexbyte.habittracker.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
  // Add this import
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.regexbyte.habittracker.Models.Comment;
import com.regexbyte.habittracker.R;

import java.util.List;

// CommentAdapter.java
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<Comment> comments;

    CommentAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate your comment item layout here
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind existing user profile, username, and comment to the ViewHolder
        Comment comment = comments.get(position);

        holder.existingUserProfileImageView.setImageResource(comment.getUserProfileImage());
        holder.existingUsernameTextView.setText(comment.getUsername());
        holder.commentTextView.setText(comment.getComment());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView existingUserProfileImageView;
        TextView existingUsernameTextView;
        TextView commentTextView;

        ViewHolder(View itemView) {
            super(itemView);
            existingUserProfileImageView = itemView.findViewById(R.id.existingUserProfileImageView);
            existingUsernameTextView = itemView.findViewById(R.id.existingUsernameTextView);
            commentTextView = itemView.findViewById(R.id.commentTextView);
        }
    }
}
