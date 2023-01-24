package com.heiner.tasktracker.model;

public class Task {
    private final TaskStatus status;
    private String name;
    private final String description;
    private int id;

    //TODO Define what attributes a task should have.

    public Task(TaskStatus status, String name, String description) {
        this.status = status;
        this.name = name;
        this.description = description;
    }

    public Task(TaskStatus status, String name, String description, int id) {
        this.status = status;
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
