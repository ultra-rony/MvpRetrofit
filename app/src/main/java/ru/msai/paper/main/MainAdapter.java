package ru.msai.paper.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.msai.paper.R;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder> implements MainAdapterView {

    private Context context;
    private String dateTime;
    private List<MainModel> list;
    private MainAdapterPresenter presenter;

    public MainAdapter(MainActivity mainActivity, List<MainModel> list) {
        this.context = mainActivity;
        this.list = list;

        // Call presenter
        presenter = new MainAdapterPresenter(MainAdapter.this);
    }

    @NonNull
    @Override
    public MainAdapter.MainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapter_main, parent, false);
        return new MainAdapter.MainAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainAdapterViewHolder holder, final int position) {

        // Date and time conversion
        presenter.onDateTimeSetting(list.get(position).getDateTime());

        holder.tTitle.setText(list.get(position).getTitle());
        holder.tDateTime.setText(dateTime);

        // Item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        // Count
        return list.size();
    }

    @Override
    public void getDateTime(String dateTime) {
        // Conversion answer
        this.dateTime = dateTime;
    }

    public class MainAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView tTitle, tDateTime;
        public MainAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tTitle = itemView.findViewById(R.id.tTitleMain);
            tDateTime = itemView.findViewById(R.id.tDateTimeMain);
        }
    }
}
