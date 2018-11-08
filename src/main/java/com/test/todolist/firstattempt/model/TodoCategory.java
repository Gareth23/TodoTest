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
public class TodoCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String categoryName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "todoCategory")
    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Todo> todoList;

    @JsonInclude
    @Transient
    private int categoryCount;

    public TodoCategory(){}
    public TodoCategory(String categoryName) {
        this.categoryName = categoryName;
        this.todoList = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
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

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryCount()
    {
        return todoList == null ? 0 : todoList.size();
    }

    public void setCategoryCount() {
        this.categoryCount = todoList.size();
    }
}
