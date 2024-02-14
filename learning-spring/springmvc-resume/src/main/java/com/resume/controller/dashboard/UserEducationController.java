package com.resume.controller.dashboard;

import com.resume.entity.User;
import com.resume.entity.UserEducation;
import com.resume.helpers.NotifierHelper;
import com.resume.helpers.ValidationHelper;
import com.resume.service.UserEducationService;
import com.resume.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/dashboard/user-education")
public class UserEducationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEducationService userEducationService;

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "User Education");
    }

    @ModelAttribute
    public UserEducation getUserEducation() {
        return new UserEducation();
    }

    @RequestMapping
    public String index(Model model) {
        List<UserEducation> userEducations = this.userEducationService.getAll();
        model.addAttribute("userEducations", userEducations);

        return "dashboard/user-education/index";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        List<User> users = this.userService.getAll();

        model.addAttribute("users", users);
        return "dashboard/user-education/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute UserEducation userEducation, BindingResult result, @RequestParam("user_id") Long userId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userEducation", userEducation).bind(result);
            return "redirect:/dashboard/user-education/create";
        }

        User user = this.userService.get(userId);

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userEducation.setUser(user);
            this.userEducationService.save(userEducation);
            new NotifierHelper(attributes).message("User education added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("User education can not be added.").error();
            return "redirect:/dashboard/user-education/create";
        }

        return "redirect:/dashboard/user-education";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        UserEducation userEducation = this.userEducationService.get(id);

        if (userEducation == null) {
            new NotifierHelper(attributes).message("User education not found.").error();
            return "redirect:/dashboard/user-education";
        }

        model.addAttribute("userEducation", userEducation);

        return "dashboard/user-education/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        UserEducation userEducation = this.userEducationService.get(id);

        if (userEducation == null) {
            new NotifierHelper(attributes).message("User education not found.").error();
            return "redirect:/dashboard/user-education";
        }

        List<User> users = this.userService.getAll();

        model.addAttribute("users", users);
        model.addAttribute("userEducation", userEducation);

        return "dashboard/user-education/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute UserEducation userEducation, BindingResult result, @RequestParam("user_id") Long userId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userEducation", userEducation).bind(result);
            return "redirect:/dashboard/user-education/" + id + "/edit";
        }

        UserEducation updatableUserEducation = this.userEducationService.get(id);

        if (updatableUserEducation == null) {
            new NotifierHelper(attributes).message("User education not found.").error();
            return "redirect:/dashboard-education/user";
        }

        User user = this.userService.get(userId);

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userEducation.setUser(user);
            this.userEducationService.update(userEducation);
            new NotifierHelper(attributes).message("User education updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("User education can not be updated.").error();
        }

        return "redirect:/dashboard/user-education/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {

        UserEducation userEducation = this.userEducationService.get(id);

        if (userEducation == null) {
            new NotifierHelper(attributes).message("User education not found.").error();
        }

        try {
            this.userEducationService.delete(userEducation);
            new NotifierHelper(attributes).message("User education deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("User education can not ber deleted.").error();
        }

        return "redirect:/dashboard/user-education";
    }
}
