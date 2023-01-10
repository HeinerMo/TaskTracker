package com.heiner.tasktracker.model;

public class Task {
    private TaskStatus status;
    private String name;
    private String description;

    //TODO Define what attributes a task should have.

    public Task(TaskStatus status, String name, String description) {
        this.status = status;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "status=" + status.name() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
