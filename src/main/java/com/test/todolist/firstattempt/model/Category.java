package com.test.todolist.firstattempt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Todo> todoList;

    public Category(){}
    public Category(String name){
        this.name = name;
        this.todoList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
