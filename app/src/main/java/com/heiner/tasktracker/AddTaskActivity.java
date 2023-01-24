package com.heiner.tasktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.heiner.tasktracker.data.TaskData;
import com.heiner.tasktracker.modal.Task;
import com.heiner.tasktracker.modal.TaskStatus;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        editName = findViewById(R.id.editTextTaskName);
        editDescription = findViewById(R.id.editTextTaskDescription);
    }
    
    public void saveNewTask(View view) {
        if (TextUtils.isEmpty(editName.getText().toString().trim())) {
            editName.setError(getApplicationContext().getString(R.string.error_name_field_empty));
        } else {

            //create new task
            Task task = new Task(editName.getText().toString(), editDescription.getText().toString() + "", -1);
            TaskData taskData = new TaskData(this);
            taskData.addTask(task);

            //Go back to main view
            Intent myIntent = new Intent(AddTaskActivity.this, MainViewActivity.class);
            AddTaskActivity.this.startActivity(myIntent);

        }
    }
}