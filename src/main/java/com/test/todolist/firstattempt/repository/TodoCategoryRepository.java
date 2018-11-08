package com.test.todolist.firstattempt.repository;

import com.test.todolist.firstattempt.model.TodoCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoCategoryRepository extends JpaRepository<TodoCategory, Integer> {


}


