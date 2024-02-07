package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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

    @RequestMapping("/create")
    public String create() {
        return "front/user/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@ModelAttribute User user) {
        try {
            this.userService.save(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "redirect:/user/create";
        }

        return "redirect:/user";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        User user = this.userService.get(id);

        if (user == null) {
            return "redirect:/user";
        }

        model.addAttribute("user", user);

        return "front/user/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        User user = this.userService.get(id);

        if (user == null) {
            return "redirect:/user";
        }

        model.addAttribute("user", user);

        return "front/user/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute User user) {

        User updatableUser = this.userService.get(id);

        if (updatableUser == null) {
            return "redirect:/user";
        }

        try {
            this.userService.update(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return "redirect:/user/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id) {

        User user = this.userService.get(id);

        if (user == null) {
            /* not found message here */
        }

        try {
            this.userService.delete(user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return "redirect:/user";
    }
}
