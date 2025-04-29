package com.taskeManager.taskmanagement.Service;

import com.taskeManager.taskmanagement.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskeManager.taskmanagement.Model.Task;
import com.taskeManager.taskmanagement.Model.TaskStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    private List<Task> tasks = new ArrayList<>();

    // Create task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    // Update task status
    public Task updateTaskStatus(Long id, TaskStatus status) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setStatus(status);
            return taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    // Delete task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Find task by status (custom method)
    public List<Task> findTaskByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status); // Assuming you have defined this method in the repository
    }
}
