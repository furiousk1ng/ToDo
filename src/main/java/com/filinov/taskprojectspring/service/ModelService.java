package com.filinov.taskprojectspring.service;

import com.filinov.taskprojectspring.ToDoRepository;
import com.filinov.taskprojectspring.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    private final ToDoRepository toDoRepository;
    @Autowired
    public ModelService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Optional<Task> findById(Long id){
        return toDoRepository.findById(id);
    }
    public Task saveTask(Task task){
        return toDoRepository.save(task);
    }

    public Task updateTask(Long id, Task task){
        Optional<Task> optionalTask = toDoRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setName(task.getName());
            existingTask.setDescription(task.getDescription());
            return toDoRepository.save(existingTask);
        }
        else {
                throw new RuntimeException("Task not found with id: " + id);
        }
    }

    public List<Task> findAll(){
        return toDoRepository.findAll().stream().toList();
    }

    public void deleteTask(Long id){
        toDoRepository.deleteById(id);
    }

}
