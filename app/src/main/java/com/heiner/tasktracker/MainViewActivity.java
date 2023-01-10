package com.heiner.tasktracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.heiner.tasktracker.data.TaskData;
import com.heiner.tasktracker.model.Task;

public class MainViewActivity extends AppCompatActivity {

    private TaskData data;
    private LinearLayout.LayoutParams params;
    private LinearLayout linearLayout;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        inflater = LayoutInflater.from(MainViewActivity.this);
        this.data = TaskData.getInstance();
        loadTasks();
    }

    private void loadTasks() {
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        linearLayout = findViewById(R.id.taskLayout);


        for (Task t: data.getTasks()) {
            int id = R.layout.task_view;
            ConstraintLayout content = (ConstraintLayout) inflater.inflate(id, null, false);
            linearLayout.addView(content);
            id = R.layout.task_spacer;
            content = (ConstraintLayout) inflater.inflate(id, null, false);
            linearLayout.addView(content);
        }

    }

}