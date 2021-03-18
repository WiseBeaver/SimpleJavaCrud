package org.alex.controller;

import org.alex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.alex.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String users(Model model){
        model.addAttribute("users",userService.findAll());
        model.addAttribute("user",new User());
        return "user";
    }


    @PostMapping("/adduser")
    public String saveUser(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id){
        userService.remove(id);
        return "redirect:/";
    }



    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable Long id,Model model){
     model.addAttribute("user",userService.findById(id));
     return "userdetail";
    }

    @PostMapping("/updateuser")
    public String update(@ModelAttribute User user){
        userService.update(user);
        return "redirect:/";
    }

}
