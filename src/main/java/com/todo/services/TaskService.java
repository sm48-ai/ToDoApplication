package com.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.models.Task;
import com.todo.repository.TaskRepository;

@Service 
public class TaskService {
    
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }


    public List<Task> getAllTask() {

        return taskRepository.findAll();
        
    }


    public void createTask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);

    }


    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }


    public void toggleTask(Long id) {
        Task task=taskRepository.findById(id)
        .orElseThrow(()->new IllegalArgumentException("Invalid Task"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
       
    }



}
