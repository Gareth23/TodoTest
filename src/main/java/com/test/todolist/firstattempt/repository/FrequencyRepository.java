package com.test.todolist.firstattempt.repository;

import com.test.todolist.firstattempt.model.Frequency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyRepository extends JpaRepository<Frequency, Integer> {


}
