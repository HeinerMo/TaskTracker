package com.heiner.tasktracker;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder{

    private TextView name;
    private TextView description;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById((R.id.taksName));
        description = itemView.findViewById((R.id.taskDescription));
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }
}
