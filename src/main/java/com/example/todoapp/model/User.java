package com.example.todoapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long uId;

    private String fName;
    private String lName;
    private String email;
    private String password;

    @OneToMany(mappedBy="user")
    private List<ToDoTask> tasks;

    public User() {
    }

    public User(/*Long uId,*/ String fName, String lName, String email, String password, List<ToDoTask> tasks) {
        //this.uId = uId;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.tasks = tasks;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDoTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ToDoTask> tasks) {
        this.tasks = tasks;
    }
}
