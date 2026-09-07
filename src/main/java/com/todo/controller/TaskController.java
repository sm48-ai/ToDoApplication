package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.models.Task;
import com.todo.services.TaskService;


@Controller 
@RequestMapping ("/tasks")
public class TaskController {
    
    
    @Autowired 
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @GetMapping 
    public String getTasks(Model model){
        List<Task> tasks=taskService.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping 
    public String createTasks(@RequestParam String title){
        taskService.createTask(title);
        
        return "redirect:/tasks";
    }

     @GetMapping ("/{id}/delete") 
    public String deleteTasks(@PathVariable  Long id){
        taskService.deleteTaskById(id);
        
        return "redirect:/tasks";
    }

     @DeleteMapping ("/{id}/toggle") 
    public String toggleTasks(@PathVariable  Long id){
        taskService.toggleTask(id);
        
        return "redirect:/tasks";
    }

    

}
