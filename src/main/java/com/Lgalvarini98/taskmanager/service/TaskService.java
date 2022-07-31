package com.Lgalvarini98.taskmanager.service;

import com.Lgalvarini98.taskmanager.model.Task;
import com.Lgalvarini98.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // GET ALL
    public ArrayList<Task> getAllTasks(){
        return (ArrayList<Task>) taskRepository.findAll();
    }

    // GET BY ID
    public Task getTask(Long id){
        return taskRepository.findById(id).get();
    }

    // CREATE, POST
    public Task addTask(Task task){
        Task newTask = new Task();

        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setAuthor(task.getAuthor());
        newTask.setFinished(false);

        return taskRepository.save(newTask);
    }

    // ACTUALIZAR
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    // DELETE
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}

