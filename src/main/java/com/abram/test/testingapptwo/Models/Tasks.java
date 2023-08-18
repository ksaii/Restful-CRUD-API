package com.abram.test.testingapptwo.Models;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Tasks {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String task;

    @Column
    private String description;



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public String getTask(){
        return task;
    }
    public void setTask(String task){
        this.task=task;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
