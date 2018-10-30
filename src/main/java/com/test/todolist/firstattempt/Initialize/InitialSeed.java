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

import java.util.*;

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
         todoList.add(new Todo("FirstTodo","description"));
         todoList.add(new Todo("SecondTodo","desc2"));
         todoList.add(new Todo("ThirdTodo","desc3"));
        todoRepository.saveAll(todoList);

        //Seed Categories
        List<Category> categories = new ArrayList<>();
        categories.add( new Category("Weekly"));
        Category onceCategory = new Category("Once");
        categories.add(onceCategory);
        categoryRepository.saveAll(categories);

        //Update Category
        Category dailyCategory = new Category("Daily");
        categoryRepository.save(dailyCategory);
        Category weeklyCategory = new Category("Weekly");
        categoryRepository.save(weeklyCategory);

        //Some Extra Todos
        Date today = new Date();

        Todo todo = new Todo("Church","Secret Valentine");
        todo.setTodoCollection(workCollection);
        todo.setCategory(onceCategory);
        todo.setDueDate(addTime(today,5,0,0));
        todoRepository.save(todo);


        Todo todo1 = new Todo("Shower","homeCollection");
        todo1.setTodoCollection(homeCollection);
        todo1.setCategory(dailyCategory);
        todo1.setDueDate(addTime(today,0,0,20));
        todoRepository.save(todo1);



        Todo todo2 = new Todo("Clean House","Properly");
        todo2.setTodoCollection(homeCollection);
        todo2.setCategory(weeklyCategory);
        todo2.setDueDate(addTime(today,-70,0,0));
        todoRepository.save(todo2);

        Todo todo3 = new Todo("Football Practise","Practise Again");
        todo3.setTodoCollection(workCollection);
        todo3.setCategory(weeklyCategory);
        todo3.setDueDate(addTime(today,1,0,0));
        todoRepository.save(todo3);


    }

    private Date addTime(Date date, int days, int hours, int minutes)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE,days);
        cal.add(Calendar.HOUR,hours);
        cal.add(Calendar.MINUTE,minutes);

        return cal.getTime();
    }
}
