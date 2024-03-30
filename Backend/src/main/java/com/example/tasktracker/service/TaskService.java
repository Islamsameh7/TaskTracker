package com.example.tasktracker.service;

import com.example.tasktracker.exception.UserlNotFoundException;
import com.example.tasktracker.model.Task;
import com.example.tasktracker.repo.TaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepo.findTaskById(id)
                .orElseThrow(() -> new UserlNotFoundException("User id " + id + "was not found"));
    }

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepo.save(task);
    }

    @Transactional
    public void deleteTask(Long id) {
        taskRepo.deleteTaskById(id);
    }
}
