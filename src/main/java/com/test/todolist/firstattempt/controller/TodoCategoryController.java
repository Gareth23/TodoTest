package com.test.todolist.firstattempt.controller;

import com.test.todolist.firstattempt.model.TodoCategory;
import com.test.todolist.firstattempt.repository.TodoCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todocategory")
@CrossOrigin
public class TodoCategoryController {

    private TodoCategoryRepository todoCategoryRepository;

    @Autowired
    public TodoCategoryController(TodoCategoryRepository todoCategoryRepository){
        this.todoCategoryRepository = todoCategoryRepository;
    }

    @GetMapping("/all")
    public List<TodoCategory> GetAll(){
        return todoCategoryRepository.findAll();

    }


    @PostMapping("/create")
    public List<TodoCategory> create(@RequestBody TodoCategory todoCategory){
        todoCategoryRepository.save(todoCategory);

        return todoCategoryRepository.findAll();
    }

    @DeleteMapping("remove/{id}")
    public void remove(@PathVariable int id) {
        todoCategoryRepository.deleteById(id);
    }

}
