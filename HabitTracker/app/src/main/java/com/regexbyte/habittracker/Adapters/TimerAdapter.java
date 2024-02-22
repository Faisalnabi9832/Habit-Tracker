package com.regexbyte.habittracker.Adapters;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.regexbyte.habittracker.Models.TimerModel;
import com.regexbyte.habittracker.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;



public class TimerAdapter extends RecyclerView.Adapter<TimerAdapter.TimerViewHolder> {

    private Context context;
    private ArrayList<TimerModel> timerList;

    public TimerAdapter(Context context, ArrayList<TimerModel> timerList) {
        this.context = context;
        this.timerList = timerList;
    }

    @NonNull
    @Override
    public TimerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_timer, parent, false);
        return new TimerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimerViewHolder holder, int position) {
        TimerModel timerModel = timerList.get(position);

        holder.titleTextView.setText(timerModel.getTitle());
        holder.timeTextView.setText(timerModel.getTime());


        holder.timeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(holder, timerModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return timerList.size();
    }

    public class TimerViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView timeTextView;

        public TimerViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            timeTextView = itemView.findViewById(R.id.time);
        }
    }

    private void showTimePickerDialog(final TimerViewHolder holder, final TimerModel timerModel) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.US);
                        String selectedTime = timeFormat.format(calendar.getTime());

                        timerModel.setTime(selectedTime);
                        notifyItemChanged(holder.getAdapterPosition());
                    }
                },
                hour,
                minute,
                false
        );

        timePickerDialog.show();
    }
}
