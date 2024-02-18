package com.security.controller;

import com.security.entity.User;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Arrays;
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

    @GetMapping("/trainer")
    public String trainer() {
        return "trainer";
    }

    @GetMapping("/coder")
    public String coder() {
        return "coder";
    }

    @ResponseBody
    @GetMapping("/hi")
    public String sayHi() {
        return "Hi all!";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello all!";
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "bye";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
