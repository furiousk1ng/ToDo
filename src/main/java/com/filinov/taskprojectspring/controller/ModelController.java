package com.filinov.taskprojectspring.controller;


import com.filinov.taskprojectspring.model.Task;
import com.filinov.taskprojectspring.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("/add")
    public void createTask(@RequestBody Task task){
        modelService.saveTask(task);
    }

    @PostMapping("task-delete/{id}")
    public void deleteTask(@PathVariable Long id){
        modelService.deleteTask(id);
    }

    @GetMapping("/task/{id}")
    public Optional<Task> findTask(@PathVariable Long id){
        return modelService.findById(id);
    }

    @PostMapping("/task/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return modelService.updateTask(id, task);
    }

    @GetMapping("/tasks")
    public List<Task> findAllTasks(){
        return modelService.findAll();
    }


}
