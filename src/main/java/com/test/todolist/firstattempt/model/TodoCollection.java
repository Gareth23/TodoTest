package com.test.todolist.firstattempt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cascade;

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "todoCollection")
    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Todo> todoList;

    @JsonInclude
    @Transient
    private int collectionCount;

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

    public int getCollectionCount()
    {
        return todoList == null ? 0 : todoList.size();
    }

    public void setCollectionCount() {
        this.collectionCount = todoList.size();
    }
}
