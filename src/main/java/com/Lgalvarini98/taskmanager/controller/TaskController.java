package com.Lgalvarini98.taskmanager.controller;

import com.Lgalvarini98.taskmanager.model.Task;
import com.Lgalvarini98.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public ArrayList<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @PostMapping()
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PutMapping()
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @PutMapping("/finalize/{id}")
    public Task finishTask(@PathVariable Long id){
        return taskService.finishTask(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }



}
