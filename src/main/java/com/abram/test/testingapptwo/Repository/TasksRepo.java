package com.abram.test.testingapptwo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abram.test.testingapptwo.Models.Tasks;

public interface TasksRepo extends JpaRepository<Tasks, Long> {
    
}
