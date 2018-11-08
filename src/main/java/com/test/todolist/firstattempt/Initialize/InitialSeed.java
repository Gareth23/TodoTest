package com.test.todolist.firstattempt.Initialize;

import com.test.todolist.firstattempt.model.Frequency;
import com.test.todolist.firstattempt.model.Todo;
import com.test.todolist.firstattempt.model.TodoCategory;
import com.test.todolist.firstattempt.repository.FrequencyRepository;
import com.test.todolist.firstattempt.repository.TodoCategoryRepository;
import com.test.todolist.firstattempt.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InitialSeed implements CommandLineRunner {

    private TodoRepository todoRepository;
    private TodoCategoryRepository todoCategoryRepository;
    private FrequencyRepository frequencyRepository;

    @Autowired
    public InitialSeed(TodoRepository todoRepository, TodoCategoryRepository todoCategoryRepository, FrequencyRepository frequencyRepository){
        this.todoRepository = todoRepository;
        this.todoCategoryRepository = todoCategoryRepository;
        this.frequencyRepository = frequencyRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        //Seed TodoCategory
        TodoCategory homeCategory = new TodoCategory("Home");
        TodoCategory workCategory = new TodoCategory("Work");

        todoCategoryRepository.save(homeCategory);
        todoCategoryRepository.save(workCategory);

        //Update Frequency
        Frequency dailyFrequency = new Frequency("Once");
        frequencyRepository.save(dailyFrequency);
        Frequency weeklyFrequency = new Frequency("Daily");
        frequencyRepository.save(weeklyFrequency);


        //Seed Categories
        List<Frequency> frequencies = new ArrayList<>();
        Frequency monthlyFrequency = new Frequency("Weekly");
        Frequency onceFrequency = new Frequency("Monthly");
        frequencies.add(monthlyFrequency);
        frequencies.add(onceFrequency);
        frequencyRepository.saveAll(frequencies);

        //Seed Todos
        Date today = new Date();

        Todo todo = new Todo("Church","Secret Valentine");
        todo.setTodoCategory(workCategory);
        todo.setFrequency(onceFrequency);
        todo.setDueDate(addTime(today,5,0,0));
        todoRepository.save(todo);


        Todo todo1 = new Todo("Shower","homeCategory");
        todo1.setTodoCategory(homeCategory);
        todo1.setFrequency(dailyFrequency);
        todo1.setDueDate(addTime(today,0,0,20));
        todoRepository.save(todo1);

        Todo todo2 = new Todo("Clean House","Properly");
        todo2.setTodoCategory(homeCategory);
        todo2.setFrequency(weeklyFrequency);
        todo2.setDueDate(addTime(today,-70,0,0));
        todoRepository.save(todo2);

        Todo todo3 = new Todo("Football Practise","Practise Again");
        todo3.setTodoCategory(workCategory);
        todo3.setFrequency(weeklyFrequency);
        todo3.setDueDate(addTime(today,1,0,0));
        todoRepository.save(todo3);

        //Extra Todos
        List<Todo> todoList = new ArrayList<>();
         todoList.add(new Todo("FirstTodo","description"));
         todoList.add(new Todo("SecondTodo","desc2"));
         todoList.add(new Todo("ThirdTodo","desc3"));
        todoRepository.saveAll(todoList);





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
