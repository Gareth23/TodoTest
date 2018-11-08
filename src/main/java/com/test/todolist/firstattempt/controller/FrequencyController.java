package com.test.todolist.firstattempt.controller;


import com.test.todolist.firstattempt.model.Frequency;
import com.test.todolist.firstattempt.repository.FrequencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/frequency")
@CrossOrigin
public class FrequencyController {

    private FrequencyRepository frequencyRepository;

    @Autowired
    public FrequencyController (FrequencyRepository frequencyRepository)
    {
        this.frequencyRepository = frequencyRepository;
    }

    @GetMapping("/all")
    public List<Frequency> GetAll () {
        return frequencyRepository.findAll();
    }
}
