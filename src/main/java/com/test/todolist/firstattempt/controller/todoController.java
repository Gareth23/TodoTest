package com.test.todolist.firstattempt.controller;

import com.test.todolist.firstattempt.model.Todo;
import com.test.todolist.firstattempt.model.TodoCategory;
import com.test.todolist.firstattempt.repository.TodoCategoryRepository;
import com.test.todolist.firstattempt.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todo")
@CrossOrigin
public class todoController {

    private TodoRepository todoRepository;
    private TodoCategoryRepository todoCategoryRepository;

    @Autowired
    public todoController(TodoRepository todoRepository, TodoCategoryRepository todoCategoryRepository) {
        this.todoRepository = todoRepository;
        this.todoCategoryRepository = todoCategoryRepository;
    }

    @GetMapping("/all")
    public List<Todo> getTodo() {
        return todoRepository.findAll();
    }

    @GetMapping("/completed")
    public List<Todo> getCompleted() {
        return todoRepository.findByCompletedTrue();
    }

    @PostMapping("/create")
    public List<Todo> create(@RequestBody Todo todo){
        todoRepository.save(todo);

        return todoRepository.findAll();
    }


    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable int id){
        todoRepository.deleteById(id);
    }


    @PostMapping("/updatedetails")
    public void updateTodoDetails(@RequestBody Todo todo)
    {
        final Optional<Todo> tempTodo = todoRepository.findById(todo.getId());

        Todo savedTodo = tempTodo.stream().findFirst().orElse(null);
        if (savedTodo != null) {
            savedTodo.setDueDate(todo.getDueDate());
            savedTodo.setFrequency(todo.getFrequency());
            savedTodo.setDescription(todo.getDescription());
            savedTodo.setTitle(todo.getTitle());
            savedTodo.setFrequency((todo.getFrequency()));
            todoRepository.save(savedTodo);
        }
    }


    @GetMapping("/incategory/{categoryId}")
    public List<Todo> getTodosInCategory(@PathVariable int categoryId)
    {
        TodoCategory category = todoCategoryRepository.getOne(categoryId);
        return todoRepository.findByTodoCategory(category);
    }


}
