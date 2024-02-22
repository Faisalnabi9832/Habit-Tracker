package com.regexbyte.habittracker.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.regexbyte.habittracker.Adapters.HabitViewHolder.HabitViewHolder;
import com.regexbyte.habittracker.Models.HabitData;
import com.regexbyte.habittracker.R;

import java.util.ArrayList;
import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitViewHolder> {
    private List<HabitData> list = new ArrayList<>();
    private Callback callback;
    private boolean isCheckboxVisible=false;
    private boolean isCheckboxSelected=false;

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.habit_list_item, parent, false);
        return new HabitViewHolder(view, callback);
    }

    @Override
    public void onBindViewHolder(HabitViewHolder holder, int position) {


        holder.itemView.setLongClickable(true);

        holder.bindData(getItemByPosition(position),isCheckboxVisible,isCheckboxSelected);
    }

    public HabitData getItemByPosition(int position) {
        return list.get(position);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void setList(List<HabitData> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public void setCheckboxVisibility(boolean isVisible) {
        isCheckboxVisible = isVisible;
        notifyDataSetChanged();
    }

    public void setCheckboxSelected(boolean isSelected) {
        isCheckboxSelected = isSelected;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public HabitData get_items(int position) {
        if (position >= 0 && position < list.size()) {
            return list.get(position);
        }
        return null;
    }
   public void removeitem(int position){
        list.remove(position);
        notifyDataSetChanged();

   }

    public interface Callback {
        void onLongItemClick(View view, int position,CheckBox checkBox);
        void onItemClick(View view, int position);

        void onDownloadClick(String eic, View view, int position, TextView textView);
        void onCheckBoxClick( View view, int position, CheckBox checkBox);
        void onCancelClick(int itemId, View view, int position, ImageButton textView);
    }
}

