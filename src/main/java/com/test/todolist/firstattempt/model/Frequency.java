package com.test.todolist.firstattempt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Frequency {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "frequency")
    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Todo> todoList;

    public Frequency(){}
    public Frequency(String name){
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
