package com.resume.controller;

import com.resume.entity.User;
import com.resume.service.UserService;
import com.resume.helpers.NotifierHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "User");
    }

    @RequestMapping
    public String index(Model model) {
        List<User> users = this.userService.getAll();
        model.addAttribute("users", users);

        return "front/user/index";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        User user = this.userService.get(id);

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
            return "redirect:/user";
        }

        model.addAttribute("user", user);

        return "front/user/show";
    }
}
