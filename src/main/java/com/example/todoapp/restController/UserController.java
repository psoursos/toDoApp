package com.example.todoapp.restController;

import com.example.todoapp.dao.UserRepo;
import com.example.todoapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @RestController
    @RequestMapping(value = "/user")
    public class UserController {

        @Autowired
        private UserRepo userRepo;

        @GetMapping
        public List<User> findAll(){
            return userRepo.findAll();
        }

        @GetMapping("/{uId}")
        public User getUserById(@PathVariable("uId") Long uId ){
            return userRepo.findById(uId).get();
        }

        @PostMapping
        public User save(@RequestBody User user){
            return userRepo.save(user);
        }
        @PutMapping
        public User update(@RequestBody User user) {
            return userRepo.save(user);
        }
        @DeleteMapping(value="/{id}")
        public void delete(@PathVariable Long id) {
            userRepo.deleteById(id);
        }
}
