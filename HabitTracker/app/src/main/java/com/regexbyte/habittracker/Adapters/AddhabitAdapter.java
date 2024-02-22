package com.regexbyte.habittracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.regexbyte.habittracker.Models.AddhabitModel;
import com.regexbyte.habittracker.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddhabitAdapter extends RecyclerView.Adapter<AddhabitAdapter.ViewHolder> {

    private List<AddhabitModel> dataList;
    private List<AddhabitModel> filteredList;
    private Context context;


    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(AddhabitModel item);
    }

    public AddhabitAdapter(List<AddhabitModel> dataList, Context context, OnItemClickListener listener) {
        this.dataList = dataList;
        this.filteredList = new ArrayList<>(dataList);
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemaddhabit, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AddhabitModel model = filteredList.get(position);
        holder.imageView.setImageResource(model.getImageResource());
        holder.textView.setText(model.getText());
        holder.imageView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(model);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void setHabits(ArrayList<AddhabitModel> habits) {
        dataList = habits;
        filteredList = new ArrayList<>(habits);
        notifyDataSetChanged();
    }

    public void filterList(String query) {
        filteredList.clear();

        if (query.isEmpty()) {
            filteredList.addAll(dataList);
        } else {
            for (AddhabitModel model : dataList) {
                if (model.getText().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(model);
                }
            }
        }

        notifyDataSetChanged();
    }

    public Set<String> getAllUniqueCategoryIds() {
        Set<String> uniqueCategoryIds = new HashSet<>();
        for (AddhabitModel model : dataList) {
            uniqueCategoryIds.add(String.valueOf(model.getCategoryId()));
        }
        return uniqueCategoryIds;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.circularImageView);
            textView = itemView.findViewById(R.id.textViewBelowImage);
        }
    }
}
