package com.taskeManager.taskmanagement.Exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super("Task not found: " + message);
    }
}
