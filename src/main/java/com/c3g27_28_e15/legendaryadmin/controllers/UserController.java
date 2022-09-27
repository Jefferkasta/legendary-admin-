package com.c3g27_28_e15.legendaryadmin.controllers;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.c3g27_28_e15.legendaryadmin.entities.User;
import com.c3g27_28_e15.legendaryadmin.services.UserService;

@RestController
public class UserController {
    UserService service;

    public UserController(UserService service){
        // this.service = new TaskService();
        this.service = service;
    }
    // @GetMapping("/tasks")
    // public TaskList TaskList(){
    //     // Task tarea1 = new Task("Aprender spring boot", false, LocalDate.of(2022, 3, 22));
    //     // return tarea1;

    //     return this.service.getTaskList();
    // }
    @GetMapping("/user")
    public List<User> UserList(){
        // Long n =(long) 1;
        // this.service.getTaskbyID(n);
        return this.service.getUserList();
    }
    // @PostMapping("/tasks")
    // public Task creaTask(@RequestBody Task task){
    //     return this.service.creaTask(task);
    // }   
    @PostMapping("/User")
    public RedirectView creaUser(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD")  User user, Model model){
        model.addAttribute(user);
        // user.setId(user.getId());;
        this.service.createUser(user);
        return new RedirectView("/Task");
    }




// @PatchMapping("/Task/{id}")
// // @PutMapping("/Task/{id}")
// public RedirectView updateTask(@PathVariable("id") Long id){
//     this.service.markTaskAsFinished(id);
//     return new RedirectView("/Task");
// }

// @DeleteMapping("/Task/{id}")
// public RedirectView deleteTask(@PathVariable("id") Long id){
//     // this.service.markTaskAsF(id);
//     this.service.deleteTask(id);
//     return new RedirectView("/Task");
// }


}
