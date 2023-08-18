package com.abram.test.testingapptwo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abram.test.testingapptwo.Models.Tasks;
import com.abram.test.testingapptwo.Repository.TasksRepo;


@RestController
public class ApiControllers {

    @Autowired
    private TasksRepo taskRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "lol";
    }

    @GetMapping(value ="/tasks")
    public List<Tasks> getTasks() {
        return taskRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveTask(@RequestBody Tasks task) {
        taskRepo.save(task);
        return "Saved!";
        
    }
    @PutMapping(value ="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Tasks task){
        Tasks updateTasks = taskRepo.findById(id).get();
        updateTasks.setTask(task.getTask());
        updateTasks.setDescription(task.getDescription());
        taskRepo.save(updateTasks);
        return "UPDATED!";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Tasks deleteTasks = taskRepo.findById(id).get();
        taskRepo.delete(deleteTasks);
        return "Successfully deleted Data with id: " +id;

    }


}
