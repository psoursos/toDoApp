package com.example.todoapp.model;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.util.Date;

@Entity
public class ToDoTask {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private boolean done;
    private Date datetime;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public ToDoTask() {
    }

    public ToDoTask(/*Long id,*/ String title, String description, boolean done, Date datetime, User user) {
        //this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
        this.datetime = datetime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
