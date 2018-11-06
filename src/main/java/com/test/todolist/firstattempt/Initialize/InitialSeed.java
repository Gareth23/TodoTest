package com.test.todolist.firstattempt.Initialize;

import com.test.todolist.firstattempt.model.Frequency;
import com.test.todolist.firstattempt.model.Todo;
import com.test.todolist.firstattempt.model.TodoCollection;
import com.test.todolist.firstattempt.repository.FrequencyRepository;
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
    private FrequencyRepository frequencyRepository;

    @Autowired
    public InitialSeed(TodoRepository todoRepository, TodoCollectionRepository todoCollectionRepository, FrequencyRepository frequencyRepository){
        this.todoRepository = todoRepository;
        this.todoCollectionRepository = todoCollectionRepository;
        this.frequencyRepository = frequencyRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        //Seed TodoCollection
        TodoCollection homeCollection = new TodoCollection("Home");
        TodoCollection workCollection = new TodoCollection("Work");

        todoCollectionRepository.save(homeCollection);
        todoCollectionRepository.save(workCollection);

        //Update Frequency
        Frequency dailyFrequency = new Frequency("Daily");
        frequencyRepository.save(dailyFrequency);
        Frequency weeklyFrequency = new Frequency("Weekly");
        frequencyRepository.save(weeklyFrequency);


        //Seed Categories
        List<Frequency> frequencies = new ArrayList<>();
        Frequency onceFrequency = new Frequency("Once");
        Frequency monthlyFrequency = new Frequency("Monthly");
        frequencies.add(onceFrequency);
        frequencies.add(monthlyFrequency);
        frequencyRepository.saveAll(frequencies);

        //Seed Todos
        Date today = new Date();

        Todo todo = new Todo("Church","Secret Valentine");
        todo.setTodoCollection(workCollection);
        todo.setFrequency(onceFrequency);
        todo.setDueDate(addTime(today,5,0,0));
        todoRepository.save(todo);


        Todo todo1 = new Todo("Shower","homeCollection");
        todo1.setTodoCollection(homeCollection);
        todo1.setFrequency(dailyFrequency);
        todo1.setDueDate(addTime(today,0,0,20));
        todoRepository.save(todo1);

        Todo todo2 = new Todo("Clean House","Properly");
        todo2.setTodoCollection(homeCollection);
        todo2.setFrequency(weeklyFrequency);
        todo2.setDueDate(addTime(today,-70,0,0));
        todoRepository.save(todo2);

        Todo todo3 = new Todo("Football Practise","Practise Again");
        todo3.setTodoCollection(workCollection);
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
