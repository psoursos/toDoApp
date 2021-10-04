package com.example.todoapp.restController;


import com.example.todoapp.model.ToDoTask;
import com.example.todoapp.dao.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api.todo")
public class ToDoController {

//    @RequestMapping(value = "/new")
//    public String displayHome(Model model) {
//
//        ToDoTask aTask = new ToDoTask();
//        model.addAttribute("task", aTask);
//        return "new-task.html";
//    }

//
    @Autowired
    private ToDoRepo toDoRepo;

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping
    public List<ToDoTask> findAll(){
        return toDoRepo.findAll();
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/{id}")
    public ToDoTask getTaskById(@PathVariable("id") Long id ){
        return toDoRepo.findById(id).get();
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PostMapping
    public ToDoTask save(@RequestBody ToDoTask toDoTask){
        return toDoRepo.save(toDoTask);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PutMapping(value="/{id}")
    public ToDoTask update(@PathVariable("id") Long id, @RequestBody ToDoTask newToDoTask) {
        return toDoRepo.findById(id)
                .map(task -> {
                    if (! (newToDoTask.getTitle()==null))
                    task.setTitle(newToDoTask.getTitle());
                    if (! (newToDoTask.getDatetime()==null))
                    task.setDatetime(newToDoTask.getDatetime());
                    if (! (newToDoTask.getDescription()==null))
                    task.setDescription(newToDoTask.getDescription());
                    task.setDone(newToDoTask.isDone());

                    return toDoRepo.save(task);
                })
                .orElseGet(() -> {
                    newToDoTask.setId(id);
                    return toDoRepo.save(newToDoTask);
                });

    }
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id) {
        toDoRepo.deleteById(id);
    }
}
