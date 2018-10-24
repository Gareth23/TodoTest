package com.test.todolist.firstattempt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TodoCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String collectionName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "todoCollection",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Todo> todoList;

    public TodoCollection(){}
    public TodoCollection(String collectionName) {
        this.collectionName = collectionName;
        this.todoList = new ArrayList<>();
    }

    public String getCollectionName() {
        return collectionName;
    }

    public int getId() {
        return Id;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int todoCount() //length
    {
        return todoList.size();
    }

}
