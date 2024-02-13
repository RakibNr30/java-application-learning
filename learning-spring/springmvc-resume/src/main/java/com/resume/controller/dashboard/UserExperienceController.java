package com.resume.controller.dashboard;

import com.resume.entity.User;
import com.resume.entity.UserExperience;
import com.resume.helpers.NotifierHelper;
import com.resume.service.UserExperienceService;
import com.resume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/dashboard/user-experience")
public class UserExperienceController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserExperienceService userExperienceService;

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "User Experience");
    }

    @RequestMapping
    public String index(Model model) {
        List<UserExperience> userExperiences = this.userExperienceService.getAll();
        model.addAttribute("userExperiences", userExperiences);

        return "dashboard/user-experience/index";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        List<User> users = this.userService.getAll();

        model.addAttribute("users", users);
        return "dashboard/user-experience/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@ModelAttribute UserExperience userExperience, @RequestParam("user_id") Long userId, RedirectAttributes attributes) {

        User user = this.userService.get(userId);

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userExperience.setUser(user);
            this.userExperienceService.save(userExperience);
            new NotifierHelper(attributes).message("User experience added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("User experience can not be added.").error();
            return "redirect:/dashboard/user-experience/create";
        }

        return "redirect:/dashboard/user-experience";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        UserExperience userExperience = this.userExperienceService.get(id);

        if (userExperience == null) {
            new NotifierHelper(attributes).message("User experience not found.").error();
            return "redirect:/dashboard/user-experience";
        }

        model.addAttribute("userExperience", userExperience);

        return "dashboard/user-experience/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        UserExperience userExperience = this.userExperienceService.get(id);

        if (userExperience == null) {
            new NotifierHelper(attributes).message("User experience not found.").error();
            return "redirect:/dashboard/user-experience";
        }

        List<User> users = this.userService.getAll();

        model.addAttribute("users", users);
        model.addAttribute("userExperience", userExperience);

        return "dashboard/user-experience/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute UserExperience userExperience, @RequestParam("user_id") Long userId, RedirectAttributes attributes) {

        UserExperience updatableUserExperience = this.userExperienceService.get(id);

        if (updatableUserExperience == null) {
            new NotifierHelper(attributes).message("User experience not found.").error();
            return "redirect:/dashboard-experience/user";
        }

        User user = this.userService.get(userId);

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userExperience.setUser(user);
            this.userExperienceService.update(userExperience);
            new NotifierHelper(attributes).message("User experience updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("User experience can not be updated.").error();
        }

        return "redirect:/dashboard/user-experience/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {

        UserExperience userExperience = this.userExperienceService.get(id);

        if (userExperience == null) {
            new NotifierHelper(attributes).message("User experience not found.").error();
        }

        try {
            this.userExperienceService.delete(userExperience);
            new NotifierHelper(attributes).message("User experience deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("User experience can not ber deleted.").error();
        }

        return "redirect:/dashboard/user-experience";
    }
}
