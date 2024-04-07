
package com.regexbyte.habittracker.Adapters;
import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.regexbyte.habittracker.Models.Comment;
import com.regexbyte.habittracker.Models.PostModel;
import com.regexbyte.habittracker.R;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<PostModel> postList;

    private Context context;
    private final GestureDetector gestureDetector;
    private final Handler clickHandler;
    private boolean isDoubleClick = false;
    ImageAdapter imageAdapter;


    RecyclerView recyclerView;
    int REQUEST_GALLERY_IMAGE = 1;

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
        TextView captionTextView = holder.itemView.findViewById(R.id.captionTextView);
        TextView seeMoreTextView = holder.itemView.findViewById(R.id.seeMoreTextView);
        TextView seeLessTextView = holder.itemView.findViewById(R.id.seelessTextView);


        String caption = "this is 1 line caption" +
                "this is 2 line caption" +
                "this is 3 line caption "+
                "Your 4 text here..." +
                "Your 5 text here..." +
                "Your 6 text here..." +
                "Your 7 text here..." +
                "Your 8 text here" +
                        "Your 9 text here"+
                        "Your 10 text here"+
                        "Your 11 text here"
               ;
        captionTextView.setText(caption);

        ViewTreeObserver vto = captionTextView.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                captionTextView.getViewTreeObserver().removeOnPreDrawListener(this);
                if (captionTextView.getLineCount() > 1) {
                    seeMoreTextView.setVisibility(View.VISIBLE);
                    seeMoreTextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            captionTextView.setMaxLines(Integer.MAX_VALUE);
                            seeMoreTextView.setVisibility(View.GONE);
                            seeLessTextView.setVisibility(View.VISIBLE);
                        }
                    });
                    seeLessTextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            captionTextView.setMaxLines(3);
                            seeMoreTextView.setVisibility(View.VISIBLE);
                            seeLessTextView.setVisibility(View.GONE);
                        }
                    });
                } else {
                    seeMoreTextView.setVisibility(View.GONE);
                    seeLessTextView.setVisibility(View.GONE);
                }

                return true;
            }
        });


// Rest of the onBindViewHolder method remains unchanged

        holder.likeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the like status
                post.setLiked(!post.isLiked());


                if (post.isLiked()) {

                    holder.likeButton.setVisibility(View.GONE);
                    holder.likeButton2.setVisibility(View.VISIBLE);
                } else {

                    holder.likeButton.setVisibility(View.VISIBLE);
                    holder.likeButton2.setVisibility(View.GONE);
                }
            }
        });




        RecyclerView imageRecyclerView = holder.itemView.findViewById(R.id.imageRecyclerView);
        imageRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        ImageAdapter imageAdapter = new ImageAdapter(post.getImageUris(), context);
        imageRecyclerView.setAdapter(imageAdapter);




//        RecyclerView imageRecyclerView = holder.itemView.findViewById(R.id.imageRecyclerView);
//        imageRecyclerView.setLayoutManager(new CustomGridLayoutManager(context, 2));
//        imageRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, 2));
//        imageAdapter = new ImageAdapter(post.getImageUris(), context);
//        imageRecyclerView.setAdapter(imageAdapter);



        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post.setLiked(!post.isLiked());
                if (post.isLiked()) {
                    holder.likeButton.setVisibility(View.GONE);
                    holder.likeButton2.setVisibility(View.VISIBLE);
                } else {
                    holder.likeButton.setVisibility(View.VISIBLE);
                    holder.likeButton2.setVisibility(View.GONE);
                }
            }
        });


        holder.commentButton.setOnClickListener(v -> showCommentDialog(post, holder));

        if (post.hasComments()) {
            displayComments(post.getComments(), holder.commentsRecyclerView);

        }


            }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView userProfileImageView;
        TextView usernameTextView,desc;
        TextView postedTimeTextView;
        ImageButton likeButton,likeButton2;
        ImageButton commentButton;
        TextView commentTextView;
        LinearLayout userImagesContainer;
        RecyclerView commentsRecyclerView;

        RecyclerView recyclerView;

        public  ViewHolder(@NonNull View itemView) {
            super(itemView);
            userProfileImageView = itemView.findViewById(R.id.userProfileImageView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            postedTimeTextView = itemView.findViewById(R.id.postedTimeTextView);
            recyclerView = itemView.findViewById(R.id.imageRecyclerView);
            likeButton = itemView.findViewById(R.id.likeButton);
            likeButton2 = itemView.findViewById(R.id.likeButton2);
            commentButton = itemView.findViewById(R.id.commentButton);
            commentTextView = itemView.findViewById(R.id.commentTextView);

//            imageItem=itemView.findViewById(R.id.childImageItem2);
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

        View dialogView = LayoutInflater.from(context).inflate(R.layout.comment_dialog_layout, null);

        RecyclerView commentsRecyclerView = dialogView.findViewById(R.id.commentsRecyclerView);
        EditText commentEditText = dialogView.findViewById(R.id.commentEditText);
        Button postCommentButton = dialogView.findViewById(R.id.postCommentButton);


        displayComments(post.getComments(), commentsRecyclerView);


        postCommentButton.setOnClickListener(view -> {
            String newComment = commentEditText.getText().toString();
            if (!TextUtils.isEmpty(newComment)) {

                Comment newCommentObject = new Comment(R.drawable.profilepic, "khan", newComment);

                post.addComment(newCommentObject);
                displayComments(post.getComments(), commentsRecyclerView);




                Snackbar.make(holder.itemView, "Comment posted", Snackbar.LENGTH_SHORT).show();
            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void displayComments(List<Comment> comments, RecyclerView recyclerView) {

        CommentAdapter adapter = new CommentAdapter(comments);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }



    private void handleDoubleClick(PostModel post, ViewHolder holder) {
        post.setLiked(!post.isLiked());

        if (post.isLiked()) {

            holder.likeButton.setVisibility(View.GONE);
            holder.likeButton2.setVisibility(View.VISIBLE);
        } else {

            holder.likeButton.setVisibility(View.VISIBLE);
            holder.likeButton2.setVisibility(View.GONE);
        }
    }



    private void handleClick(PostModel post, ViewHolder holder) {
        if (post.isLiked()) {

            holder.likeButton.setVisibility(View.GONE);
            holder.likeButton2.setVisibility(View.VISIBLE);
        } else {

            holder.likeButton.setVisibility(View.VISIBLE);
            holder.likeButton2.setVisibility(View.GONE);
        }
    }
    public interface OnProfileClickListener {
        void onProfileClicked(List<Uri> imageUris);
    }




}
