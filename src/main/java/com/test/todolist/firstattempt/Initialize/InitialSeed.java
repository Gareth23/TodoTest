package com.test.todolist.firstattempt.Initialize;

import com.test.todolist.firstattempt.model.Category;
import com.test.todolist.firstattempt.model.Todo;
import com.test.todolist.firstattempt.model.TodoCollection;
import com.test.todolist.firstattempt.repository.CategoryRepository;
import com.test.todolist.firstattempt.repository.TodoCollectionRepository;
import com.test.todolist.firstattempt.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitialSeed implements CommandLineRunner {

    private TodoRepository todoRepository;
    private TodoCollectionRepository todoCollectionRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public InitialSeed(TodoRepository todoRepository, TodoCollectionRepository todoCollectionRepository, CategoryRepository categoryRepository){
        this.todoRepository = todoRepository;
        this.todoCollectionRepository = todoCollectionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Seed TodoCollection
        TodoCollection homeCollection = new TodoCollection("Home");
        TodoCollection workCollection = new TodoCollection("Work");

        todoCollectionRepository.save(homeCollection);
        todoCollectionRepository.save(workCollection);

        //Seed Todo's
        List<Todo> todoList = new ArrayList<>();
       // todoList.add(new Todo("FirstTodo",homeCollection));
       // todoList.add(new Todo("SecondTodo",homeCollection));
       // todoList.add(new Todo("ThirdTodo",workCollection));
         todoList.add(new Todo("FirstTodo","description"));
         todoList.add(new Todo("SecondTodo","desc2"));
         todoList.add(new Todo("ThirdTodo","desc3"));
        todoRepository.saveAll(todoList);

        //Seed Categories
        List<Category> categories = new ArrayList<>();
        categories.add( new Category("Weekly"));
        categories.add( new Category("Urgent"));
        categoryRepository.saveAll(categories);

        //Update Category
        Category dailyCategory = new Category("Daily");
        categoryRepository.save(dailyCategory);
        Category weeklyCategory = new Category("Weekly");
        categoryRepository.save(weeklyCategory);

        //Some Extra Todos
        Todo todo = new Todo("Shower","homeCollection");
        todo.setTodoCollection(homeCollection);
        todo.setCategory(dailyCategory);
        todoRepository.save(todo);

        Todo todo2 = new Todo("Clean House","Properly");
        todo2.setTodoCollection(homeCollection);
        todo2.setCategory(weeklyCategory);
        todoRepository.save(todo2);



    }
}
