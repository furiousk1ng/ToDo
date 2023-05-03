package com.filinov.taskprojectspring;

import com.filinov.taskprojectspring.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task, Long> {
}
