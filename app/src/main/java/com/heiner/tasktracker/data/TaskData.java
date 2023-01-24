package com.heiner.tasktracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.heiner.tasktracker.modal.Task;

import java.util.ArrayList;

public class TaskData  extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "TaskTrackerData";
    private static final int DATABASE_VERSION = 1;
    private static final String TASK_TABLE_NAME = "tb_task";
    private static final String PRIMARY_KEY_COLUMN = "id";
    private static final String TASK_NAME_COLUMN = "name";
    private static final String TASK_DESCRIPTION_COLUMN = "description";

    public TaskData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TASK_TABLE_NAME + " ("
                + PRIMARY_KEY_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TASK_NAME_COLUMN + " TEXT,"
                + TASK_DESCRIPTION_COLUMN + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TASK_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addTask(Task task) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TASK_NAME_COLUMN, task.getName());
        contentValues.put(TASK_DESCRIPTION_COLUMN, task.getDescription());

        sqLiteDatabase.insert(TASK_TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
    }

    public ArrayList<Task> getAllTasks() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TASK_TABLE_NAME, null);

        ArrayList<Task> tasks = new ArrayList<Task>();

        if (cursor.moveToFirst()) {
            do {
                Task task = new Task(cursor.getString(1), cursor.getString(2), cursor.getInt(0));
                tasks.add(task);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return tasks;
    }

    public void deleteTaskById(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(TASK_TABLE_NAME, PRIMARY_KEY_COLUMN + "=?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public void updateTaskPosition(Task task) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TASK_NAME_COLUMN, task.getName());
        contentValues.put(TASK_DESCRIPTION_COLUMN, task.getDescription());

        // sqLiteDatabase.update(TASK_TABLE_NAME, contentValues, "position=?", task.getPosition());

        // sqLiteDatabase.close();
    }
}
