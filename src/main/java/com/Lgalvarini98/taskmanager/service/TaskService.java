package com.Lgalvarini98.taskmanager.service;

import com.Lgalvarini98.taskmanager.model.Task;
import com.Lgalvarini98.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // GET ALL
    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = (ArrayList<Task>) taskRepository.findAll();
        tasks.sort(Comparator.comparing(Task::isFinished).reversed());
        return tasks;
    }

    // GET BY ID
    public Task getTask(Long id) {
        return taskRepository.findById(id).get();
    }

    // CREATE, POST
    public Task addTask(Task task) {
        Task newTask = new Task();

        newTask.setTitle(task.getTitle());
        newTask.setDescription(task.getDescription());
        newTask.setAuthor(task.getAuthor());
        newTask.setFinished(false);

        return taskRepository.save(newTask);
    }

    // UPDATE
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    // FINISH
    public Task finishTask(Long id) {
        Task task = taskRepository.findById(id).get();
        task.setFinished(!task.isFinished());
        return taskRepository.save(task);
    }

    // DELETE
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

