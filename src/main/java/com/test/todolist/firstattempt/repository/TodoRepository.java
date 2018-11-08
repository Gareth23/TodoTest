package com.test.todolist.firstattempt.repository;

import com.test.todolist.firstattempt.model.Todo;
import com.test.todolist.firstattempt.model.TodoCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

    List<Todo> findByCompletedTrue();

    List<Todo> findByTodoCategory(TodoCategory todoCategory);


}

