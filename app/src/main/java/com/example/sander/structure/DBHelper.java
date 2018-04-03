package com.example.sander.structure;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_PATH = Environment.getExternalStorageDirectory() + "db";
    public static final String DATABASE_NAME = "db";


    public DBHelper(Context context){
        super(context, DATABASE_NAME,null,1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table tasks " +
                        "(id integer primary key, title text,last_date )"
        );



    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {}

    public void insertTask(String title, String last_date) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("last_date", last_date);

        db.insert("Tasks", null, contentValues);

    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> tasks_list = new ArrayList<Task>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from tasks", null );

        res.moveToFirst();

        while(res.isAfterLast() == false){
            //in this loop we want to use what we get as a string

            tasks_list.add(
                    new Task(
                            res.getString(res.getColumnIndex("title")),
                            res.getString(res.getColumnIndex("last_date"))
                    )
            );


            res.moveToNext();
        }
        return tasks_list;
    }
}
