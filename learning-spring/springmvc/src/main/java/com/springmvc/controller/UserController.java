package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;
import com.springmvc.utils.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String store(@ModelAttribute User user, RedirectAttributes attributes) {
        try {
            this.userService.save(user);
            new Notifier(attributes).message("User added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new Notifier(attributes).message("User can not be added.").error();
            return "redirect:/user/create";
        }

        return "redirect:/user";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        User user = this.userService.get(id);

        if (user == null) {
            new Notifier(attributes).message("User not found.").error();
            return "redirect:/user";
        }

        model.addAttribute("user", user);

        return "front/user/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        User user = this.userService.get(id);

        if (user == null) {
            new Notifier(attributes).message("User not found.").error();
            return "redirect:/user";
        }

        model.addAttribute("user", user);

        return "front/user/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute User user, RedirectAttributes attributes) {

        User updatableUser = this.userService.get(id);

        if (updatableUser == null) {
            new Notifier(attributes).message("User not found.").error();
            return "redirect:/user";
        }

        try {
            this.userService.update(user);
            new Notifier(attributes).message("User updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new Notifier(attributes).message("User can not be updated.").error();
        }

        return "redirect:/user/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {

        User user = this.userService.get(id);

        if (user == null) {
            new Notifier(attributes).message("User not found.").error();
        }

        try {
            this.userService.delete(user);
            new Notifier(attributes).message("User deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new Notifier(attributes).message("User can not ber deleted.").error();
        }

        return "redirect:/user";
    }
}
