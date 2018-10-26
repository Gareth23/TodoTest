package com.test.todolist.firstattempt.controller;

import com.test.todolist.firstattempt.model.TodoCollection;
import com.test.todolist.firstattempt.repository.TodoCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todocollection")
@CrossOrigin
public class TodoCollectionController {

    private TodoCollectionRepository todoCollectionRepository;

    @Autowired
    public TodoCollectionController(TodoCollectionRepository todoCollectionRepository){
        this.todoCollectionRepository = todoCollectionRepository;
    }

    @GetMapping("/all")
    public List<TodoCollection> GetAll(){
        return todoCollectionRepository.findAll();

    }


    @PostMapping("/create")
    public List<TodoCollection> create(@RequestBody TodoCollection todoCollection){
        todoCollectionRepository.save(todoCollection);

        return todoCollectionRepository.findAll();
    }

    @DeleteMapping("remove/{id}")
    public void remove(@PathVariable int id) {
        todoCollectionRepository.deleteById(id);
    }

}
