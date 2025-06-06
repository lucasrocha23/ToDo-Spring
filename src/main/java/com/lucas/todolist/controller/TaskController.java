package com.lucas.todolist.controller;

import com.lucas.todolist.dto.TaskRequestDTO;
import com.lucas.todolist.model.Task;
import com.lucas.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ComponentScan(basePackages = "com.lucas.todolist")
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    private List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTask(id);
        return task == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(task);
    }

    @PostMapping
    private ResponseEntity<Task> createTask(@RequestBody TaskRequestDTO task) {
        Task newTask = taskService.saveTask(task);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO task) {
        Task updatedTask = taskService.updateTask(id, task);
        return updatedTask == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
