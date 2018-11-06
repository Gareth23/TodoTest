package com.test.todolist.firstattempt.model;


//import org.springframework.data.annotation.Id;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;
    private Date dueDate;
    private boolean completed;

    @ManyToOne(fetch = FetchType.EAGER )
    private TodoCollection todoCollection;

    @ManyToOne(fetch = FetchType.EAGER)
    private Frequency frequency;

    public Todo(){}
    public Todo(String title, String description)
    {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getDescription() { return description; }

    public boolean getCompleted() {  return completed;   }

    public Frequency getFrequency() {
       // return frequency == null ? null : frequency.getName();
        return frequency;
    }

    public TodoCollection getTodoCollection() {
        //return todoCollection == null ? null : todoCollection.getCollectionName();
        return todoCollection;
    }

    public void setCompleted(boolean completed) {  this.completed = completed;  }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setTodoCollection(TodoCollection todoCollection) {
        this.todoCollection = todoCollection;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
