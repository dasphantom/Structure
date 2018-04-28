package com.example.sander.structure;

import android.content.Intent;

import android.graphics.Canvas;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import java.util.List;



public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;
    private List<Task> tasks;
    private DBHelper dbhelper;
    SwipeController swipeController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setDataAdapter();
        setupRecyclerView();
    }

    private void setDataAdapter() {


        dbhelper = new DBHelper(this.getApplicationContext());
        tasks = dbhelper.getTasks();
        mAdapter = new MyAdapter(tasks);
    }

    private void setupRecyclerView() {

        dbhelper = new DBHelper(this.getApplicationContext());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {

                Task task = tasks.get(position);
                dbhelper.deleteTask(task.getmTitle());


                mAdapter.tasks.remove(position);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());




            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent addIntent = new Intent(MainActivity.this, AddTask.class);
                // Start the new activity
                startActivity(addIntent);
            }
        });
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.task_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        TextView label = (TextView) findViewById(R.id.categoryLabel);

        switch (item.getItemId()) {
            case R.id.chores:
                dbhelper = new DBHelper(this.getApplicationContext());
                tasks = dbhelper.getLimitedTasks("Chores");
                mAdapter = new MyAdapter(tasks);

                label.setText("Chores");

                setupRecyclerView();

                return true;

            case R.id.health:

                return true;
            case R.id.everything:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
