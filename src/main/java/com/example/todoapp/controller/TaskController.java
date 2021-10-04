package com.example.todoapp.controller;
import com.example.todoapp.dao.ToDoRepo;
//import com.example.todoapp.model.ToDoTask;
//import com.example.todoapp.dao.ToDoRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import java.util.List;


@Controller
@RequestMapping(value = "/todo")
public class TaskController {

    @Autowired
    private ToDoRepo toDoRepo;

    @GetMapping(value = "/")
    public String displayHome() {

        //ToDoTask aTask = new ToDoTask();
        //model.addAttribute("task", toDoRepo.findAll());
        return "home";
    }

    @GetMapping(value = "/all")
    public String showAll(Model model) {



        model.addAttribute("tasks",toDoRepo.findAll());
        return "all-tasks";
    }


}

