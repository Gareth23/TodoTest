package com.test.todolist.firstattempt.repository;

import com.test.todolist.firstattempt.model.Category;
import com.test.todolist.firstattempt.model.TodoCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoCollectionRepository extends JpaRepository<TodoCollection, Integer> {


}


