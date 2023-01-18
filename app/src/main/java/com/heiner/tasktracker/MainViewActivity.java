package com.heiner.tasktracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.heiner.tasktracker.adapters.TaskRecyclerViewAdapter;
import com.heiner.tasktracker.data.TaskData;
import com.heiner.tasktracker.model.Task;

public class MainViewActivity extends AppCompatActivity {

    private RecyclerView taskRecyclerView;
    TaskRecyclerViewAdapter taskRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

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
                // this method is called when we swipe our item to right direction.
                // on below line we are getting the item at a particular position.
                Task deletedTask = TaskData.getInstance().getTasks().get(viewHolder.getAdapterPosition());

                // below line is to get the position
                // of the item at that position.
                int position = viewHolder.getAdapterPosition();

                // this method is called when item is swiped.
                // below line is to remove item from our array list.
                TaskData.getInstance().getTasks().remove(viewHolder.getAdapterPosition());

                // below line is to notify our item is removed from adapter.
                taskRecyclerViewAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

                // below line is to display our snackbar with action.
                Snackbar.make(taskRecyclerView, deletedTask.getName(), Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // adding on click listener to our action of snack bar.
                        // below line is to add our item to array list with a position.
                        TaskData.getInstance().getTasks().add(position, deletedTask);

                        // below line is to notify item is
                        // added to our adapter class.
                        taskRecyclerViewAdapter.notifyItemInserted(position);
                    }
                }).show();
            }
            // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(taskRecyclerView);
    }

}