package com.heiner.tasktracker.data;

import com.heiner.tasktracker.model.Task;
import com.heiner.tasktracker.model.TaskStatus;

import java.util.ArrayList;

public class TaskData {

    private static TaskData instance;
    private ArrayList<Task> tasks;

    private TaskData() {

        //TODO load task from file
        tasks = new ArrayList<>();
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 1", "Description 1"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 2", "Description 2"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 3", "Description 3"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 4", "Description 4"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 5", "Description 5"));
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public static TaskData getInstance() {
        if (instance == null) {
            instance = new TaskData();
        }
        return instance;
    }

}
