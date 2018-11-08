package com.test.todolist.firstattempt.viewmodel;

import com.test.todolist.firstattempt.model.Frequency;
import com.test.todolist.firstattempt.model.TodoCategory;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TodoViewModel {
    @NotNull
    private String Title;

    private String Description;

    private Date DueDate;
    private Date LastModified;
    private boolean Completed;

    private TodoCategory TodoCategory;

    private Frequency Frequency;
}

