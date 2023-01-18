package com.heiner.tasktracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.heiner.tasktracker.R;
import com.heiner.tasktracker.TaskViewHolder;
import com.heiner.tasktracker.data.TaskData;
import com.heiner.tasktracker.model.Task;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private TaskData data;
    private Context localContext;

    public TaskRecyclerViewAdapter(Context localContext) {
        super();
        this.localContext = localContext;
        this.data = TaskData.getInstance();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_view , parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        // Set the data to textview
        Task task = data.getTasks().get(position);
        holder.setName(task.getName());
        holder.setDescription(task.getDescription());
    }

    @Override
    public int getItemCount() {
        return data.getTasks().size();
    }
}
