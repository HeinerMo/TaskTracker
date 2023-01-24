package com.heiner.tasktracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.heiner.tasktracker.adapters.TaskRecyclerViewAdapter;
import com.heiner.tasktracker.data.TaskData;
import com.heiner.tasktracker.modal.Task;

public class MainViewActivity extends AppCompatActivity {

    private RecyclerView taskRecyclerView;
    private TaskRecyclerViewAdapter taskRecyclerViewAdapter;
    private Button addTask;
    private TaskData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_view);


        data = new TaskData(this);
        //Find recycler view for tasks
        taskRecyclerView = findViewById(R.id.taskContainer);

        //set the layout manager to the recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        taskRecyclerView.setLayoutManager(linearLayoutManager);

        //Set the adapter
        taskRecyclerViewAdapter = new TaskRecyclerViewAdapter(this);
        taskRecyclerView.setAdapter(taskRecyclerViewAdapter);


        // on below line we are creating a method to create item touch helper
        // method for adding swipe to delete functionality.
        // in this we are specifying drag direction and position to right
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                // this method is called
                // when the item is moved.
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //TODO SWIPE TO DELETE AND UNDO
                int position = viewHolder.getAdapterPosition();

                Task deletedTask = data.getAllTasks().get(position);

                //TODO this code won't work with the ordering logic in place
                data.deleteTaskById(data.getAllTasks().get(viewHolder.getAdapterPosition()).getId());

                taskRecyclerViewAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                Snackbar.make(taskRecyclerView, deletedTask.getName(), Snackbar.LENGTH_LONG).setAction(getApplicationContext().getString(R.string.undo_message), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data.addTask(deletedTask);
                        taskRecyclerViewAdapter.notifyItemInserted(position);
                    }
                }).show();
            }
        }).attachToRecyclerView(taskRecyclerView);
    }

    public void onResume() {
        super.onResume();
        taskRecyclerViewAdapter.notifyDataSetChanged();
    }

    public void launchAddTaskView(View view) {
        Intent myIntent = new Intent(MainViewActivity.this, AddTaskActivity.class);
        MainViewActivity.this.startActivity(myIntent);
    }

}