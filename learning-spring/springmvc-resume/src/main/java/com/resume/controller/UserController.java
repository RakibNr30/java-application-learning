package com.resume.controller;

import com.resume.entity.Skill;
import com.resume.entity.User;
import com.resume.service.SkillService;
import com.resume.service.UserService;
import com.resume.utils.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SkillService skillService;

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
    public String create(Model model) {
        List<Skill> skills = this.skillService.getAll();

        model.addAttribute("skills", skills);
        return "front/user/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@ModelAttribute User user, @RequestParam("selectedSkills") List<Integer> selectedSkills, RedirectAttributes attributes) {

        List<Skill> skills = new ArrayList<>();

        try {
            for (Integer skillId: selectedSkills) {
                skills.add(this.skillService.get(skillId));
            }

            user.setSkills(skills);

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

        List<Skill> skills = this.skillService.getAll();

        model.addAttribute("user", user);
        model.addAttribute("skills", skills);

        return "front/user/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute User user, @RequestParam("selectedSkills") List<Integer> selectedSkills, RedirectAttributes attributes) {

        User updatableUser = this.userService.get(id);

        if (updatableUser == null) {
            new Notifier(attributes).message("User not found.").error();
            return "redirect:/user";
        }

        List<Skill> skills = new ArrayList<>();

        try {
            for (Integer skillId: selectedSkills) {
                skills.add(this.skillService.get(skillId));
            }

            user.setSkills(skills);

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
