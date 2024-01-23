package com.webapp.kata_311.controller;

import com.webapp.kata_311.model.User;
import com.webapp.kata_311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(ModelMap model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        if (user.getId() != null) {
            userService.update(user.getId(), user);
        } else {
            userService.add(user);
        }

        return "redirect:/";
    }

    @PostMapping(value = "/deleteUser", params = {"userId"})
    public String deleteUser(@RequestParam("userId") long id) {
        userService.delete(id);

        return "redirect:/";
    }

    @PostMapping(value = "/updateUser", params = {"userId"})
    public String updateUser(@RequestParam("userId") long id, ModelMap model) {
        User user = userService.get(id);
        model.addAttribute("user", user);

        return "user-info";
    }

}