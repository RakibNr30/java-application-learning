package com.security.controller;

import com.security.entity.User;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String index(Model model) {

        List<User> users = this.userService.getAll();

        model.addAttribute("users", users);

        return "index";
    }


}
