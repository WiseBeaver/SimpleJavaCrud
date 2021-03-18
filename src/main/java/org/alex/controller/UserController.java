package org.alex.controller;

import org.alex.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.alex.service.UserService;
import javax.validation.Valid;

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
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("users",userService.findAll());
            return "user";
        }
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

    @PatchMapping("/updateuser")
    public String update(@Valid @ModelAttribute User user,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "userdetail";
        }
        userService.update(user);
        return "redirect:/";
    }

}
