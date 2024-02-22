package com.regexbyte.habittracker.Adapters.HabitViewHolder;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.regexbyte.habittracker.Adapters.HabitAdapter;
import com.regexbyte.habittracker.Models.HabitData;
import com.regexbyte.habittracker.R;


public class HabitViewHolder extends RecyclerView.ViewHolder {


    TextView dateText, name, streak, dueTime, tvSunday, tvMonday, tvTuesday, tvWednesday, tvThursday, tvFriday, tvSaturday;
    ImageView image;
    public LinearLayout viewForeground;
    private HabitAdapter.Callback callback;
    private Context context;


    public HabitViewHolder(View itemView, final HabitAdapter.Callback callback) {
        super(itemView);

        this.callback = callback;
        this.context = itemView.getContext();

        name = itemView.findViewById(R.id.name);
        dateText = itemView.findViewById(R.id.date_text);
        tvSunday = itemView.findViewById(R.id.sunday_text);
        tvMonday = itemView.findViewById(R.id.monday_text);
        tvTuesday = itemView.findViewById(R.id.tuesday_text);
        tvWednesday = itemView.findViewById(R.id.wednesday_text);
        tvThursday = itemView.findViewById(R.id.thursday_text);
        tvFriday = itemView.findViewById(R.id.friday_text);
        tvSaturday = itemView.findViewById(R.id.saturday_text);
        streak = itemView.findViewById(R.id.streek);
        dueTime = itemView.findViewById(R.id.due_time);
        image = itemView.findViewById(R.id.thumbnail);
        viewForeground = itemView.findViewById(R.id.view_foreground);
        if (callback != null) {
            itemView.setOnLongClickListener(v -> {
                int position = getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
//                    callback.onLongItemClick(v, position,cbStatus);
                    return true;
                }

                return false;
            });
        }

        if (callback != null) {
            itemView.setOnClickListener(v -> {
                int position = getBindingAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    callback.onItemClick(v, position);

                }

            });
        }
    }

    public void bindData(HabitData postItems, boolean isCheckBoxVisible, boolean isSelected) {


        name.setText(postItems.getHabbit_name());
        dateText.setText(postItems.getHabbit_end_date());
        streak.setText(postItems.getCount());
        dueTime.setText(postItems.getHabbit_time_one());
        Glide.with(context).load(postItems.getImageUrl()).into(image);
//
//        if (isCheckBoxVisible)
//        {
//             cbStatus.setVisibility(View.VISIBLE);
//        }
//        else {
//            cbStatus.setVisibility(View.GONE);
//        }
//
//        if (isSelected)
//        {
//            cbStatus.setChecked(true);
//        }
//        else {
//            cbStatus.setChecked(false);
//        }
//
//
//        tv_code.setText(postItems.getCode());
//        tvbarcode.setText(postItems.getBarcode());
//        name.setText(postItems.getName());
//
//        tvcategory.setText(postItems.getIdCathegories());
//        tvunit.setText(postItems.getUnit());
//        tvcost.setText(postItems.getCost());
//        tvvat.setText(String.valueOf(postItems.getIdTVSH()));
//        tvInventory.setText(String.valueOf(postItems.getInventory()));
//
//        if (postItems.getStatus().equals("1")) {
//            tvstatus.setText(context.getResources().getString(R.string.active));
//            tvstatus.setBackground(ResourcesCompat.getDrawable(context.getResources(),R.drawable.rectangle_bg_dark_gray,context.getTheme()));
//        } else {
//            tvstatus.setText(context.getResources().getString(R.string.inactive));
//            tvstatus.setBackground(ResourcesCompat.getDrawable(context.getResources(),R.drawable.rectangle_bg_red,context.getTheme()));
//        }
//
//        cbStatus.setOnClickListener(v -> callback.onCheckBoxClick( v, getBindingAdapterPosition(), cbStatus));
//
//
//    private void fillComment(String userName, RaportetModel comment, TextView commentTextView) {
//        Spannable contentString = new SpannableStringBuilder(userName + "   " + comment.getItem_name());
//        contentString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.colorBlack)),
//                0, userName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        commentTextView.setText(contentString);
//
//
//    }


    }

}
