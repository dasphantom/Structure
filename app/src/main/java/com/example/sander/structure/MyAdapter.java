package com.example.sander.structure;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public List<Task> tasks;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, last_date;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            last_date = (TextView) view.findViewById(R.id.last_date);

        }
    }

    public MyAdapter(List<Task> tasks) {
        this.tasks = tasks;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_list_row, parent, false);


        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Task task = tasks.get(position);


        holder.title.setText(task.getmTitle());

        //before we set the lastdate we want to calc difference between now and then
        long currtime = new Timestamp(System.currentTimeMillis()).getTime();
        long dif =  currtime - task.getmLast_date();
        long diffDays = dif / (24 * 60 * 60 * 1000);

        holder.last_date.setText("Days ago:" + String.valueOf(diffDays));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tasks.size();

    }



}