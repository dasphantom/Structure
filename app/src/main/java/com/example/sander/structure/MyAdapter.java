package com.example.sander.structure;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Task> mTasksList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title, last_date;


        //this is the constructor for the ViewHolder, it takes in a TextView Object, i want it to take in something else
        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            last_date = (TextView) view.findViewById(R.id.last_date);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Task> taskList) {
        this.mTasksList = taskList;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_list_row, parent, false);


        return new ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Task task = mTasksList.get(position);

        holder.title.setText(task.getmTitle());
        holder.last_date.setText(task.getStringmLast_date());



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mTasksList.size();
    }
}