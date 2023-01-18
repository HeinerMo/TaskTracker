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
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 6", "Description 6"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 7", "Description 7"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 8", "Description 8"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 9", "Description 9"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 10", "Description 10"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 11", "Description 11"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 12", "Description 12"));
        tasks.add(new Task(TaskStatus.IN_PROGRESS, "Task 13", "Description 13"));
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
