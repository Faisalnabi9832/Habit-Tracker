package com.regexbyte.habittracker.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.regexbyte.habittracker.R;

import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_IMAGE_Parent = 1;
    private static final int TYPE_IMAGE2 = 2;
    private static final int TYPE_IMAGE3 = 3;

    private static final int TYPE_TEXT = 2;

    private List<Uri> imageUris;
    private Context context;

    public ImageAdapter(List<Uri> imageUris, Context context) {
        this.imageUris = imageUris;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_IMAGE_Parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item1image, parent, false);
            return new ImageViewHolder2(view);

        } else if (viewType == TYPE_IMAGE2) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item2image, parent, false);
            return new ImageViewHolder3(view);

        } else  {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_image, parent, false);
            return new ImageViewHolder(view);
        }


    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0 && imageUris.size() == 1) {
            ImageViewHolder2 imageViewHolder = (ImageViewHolder2) holder;
           Uri imageUri = imageUris.get(position);
           Glide.with(context).load(imageUri).into(imageViewHolder.imageView);
        } else if (position == 0  && imageUris.size() == 2) {
            ImageViewHolder3 imageViewHolder2 = (ImageViewHolder3) holder;

            Uri imageUri2 = imageUris.get(position);

            Glide.with(context).load(imageUri2).into(imageViewHolder2.imageView2);

        }
        if (position==2 && imageUris.size()==3 ) {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            Uri imageUri = imageUris.get(position);
            Glide.with(context).load(imageUri).into(imageViewHolder.imageView);
        }else if (position == 2 && imageUris.size() > 3) {
            ImageViewHolder textViewHolder = (ImageViewHolder) holder;
            int remainingImages = imageUris.size() - 3;
            String text = "+" +remainingImages;
            Glide.with(context)
                    .load(imageUris.get(position))
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(10, 3))) // Adjust parameters as needed
                    .into(textViewHolder.imageView);
            textViewHolder.textView.setText(text);
            textViewHolder.textView.setVisibility(View.VISIBLE);
        }

        }







//        if (holder instanceof ImageViewHolder) {
//            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
//            Uri imageUri = imageUris.get(position);
//            Glide.with(context).load(imageUri).into(imageViewHolder.imageView);
//        }
//
//        // Check if the position is the third child image and there are more than three images
//        if (position == 2 && imageUris.size() > 3) {
//            ImageViewHolder textViewHolder = (ImageViewHolder) holder;
//            int remainingImages = imageUris.size() - 3;
//            String text = "+" + remainingImages;
//            Glide.with(context)
//                    .load(imageUris.get(position))
//                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3))) // Adjust parameters as needed
//                    .into(textViewHolder.imageView);
//            textViewHolder.textView.setText(text);
//            textViewHolder.textView.setVisibility(View.VISIBLE);
//        } else {
//            ImageViewHolder textViewHolder = (ImageViewHolder) holder;
//            textViewHolder.textView.setVisibility(View.GONE);
//        }


    @Override
    public int getItemCount() {
        if (imageUris.size() > 3) {
            return 3;
        } else {
            return imageUris.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (imageUris.size() == 1) {
            return TYPE_IMAGE_Parent;
        } else if (imageUris.size() == 2) {
            return TYPE_IMAGE2;
        } else if (imageUris.size() == 3) {
            return TYPE_IMAGE3;
        } else {
            return imageUris.size() + 1;
        }
    }
    public void setImageUris(List<Uri> imageUris) {
        this.imageUris = imageUris;
    }
}



//        if (imageUris.size() >3 && position == 3) {
//            return TYPE_TEXT;
//        } else {
//            return TYPE_IMAGE;
//        }


//    public void setImageUris(List<Uri> imageUris) {
//        this.imageUris = imageUris;
//        notifyDataSetChanged();
//    }


     class ImageViewHolder2 extends RecyclerView.ViewHolder {
        ImageView imageView;


        public ImageViewHolder2(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.parentimage);

        }
    }
    class ImageViewHolder3 extends RecyclerView.ViewHolder {
        ImageView imageView1,imageView2;


        public ImageViewHolder3(@NonNull View itemView) {
            super(itemView);

            imageView2 = itemView.findViewById(R.id.childImageItem1);

        }
    }
      class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.childImages);
            textView = itemView.findViewById(R.id.textView);
        }
    }

//    public static class ChildImageViewHolder extends RecyclerView.ViewHolder {
//        ImageView childImageView;
//
//        public ChildImageViewHolder(@NonNull View itemView) {
//            super(itemView);
//            childImageView = itemView.findViewById(R.id.childImageItem2);
//        }
//    }

//    public static class TextViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//
//        public TextViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.textView);
//        }
//    }

//    public static class TextViewHolder extends RecyclerView.ViewHolder {
//
//        TextView textView;
//
//        public TextViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.textView);
//        }
//    }
