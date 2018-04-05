package com.example.sander.structure;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;


public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        final DBHelper dbhelper = new DBHelper(this.getApplicationContext());

        Button addTask = findViewById(R.id.add_task);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get text from title
                EditText title = findViewById(R.id.add_title);
                dbhelper.insertTask(title.getText().toString(), new Date().toString());



                finish();


            }
        });
    }
}
