package com.taskeManager.taskmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taskeManager.taskmanagement.Model.Task;
import com.taskeManager.taskmanagement.Model.TaskStatus;
import com.taskeManager.taskmanagement.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
//        return ResponseEntity.ok(taskService.findTaskById(id));
//    }

    @GetMapping("/status")
    public ResponseEntity<List<Task>> findTaskByStatus(@RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.findTaskByStatus(status));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
