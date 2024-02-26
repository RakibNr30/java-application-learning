package com.resume.controller.dashboard.ums.profile;

import com.resume.dtos.UserBasicDto;
import com.resume.entity.ums.User;
import com.resume.entity.ums.UserEducation;
import com.resume.helpers.NotifierHelper;
import com.resume.helpers.ValidationHelper;
import com.resume.service.ums.UserEducationService;
import com.resume.service.ums.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/dashboard/ums/profile")
public class UserProfileController {

    private final UserService userService;

    private final UserEducationService userEducationService;

    @Autowired
    public UserProfileController(UserService userService, UserEducationService userEducationService) {
        this.userService = userService;
        this.userEducationService = userEducationService;
    }

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "My Profile");
    }

    @RequestMapping
    public String index(Model model, Authentication auth, RedirectAttributes attributes) {
        User user = this.userService.getByUsername(auth.getName());

        if (user == null) {
            new NotifierHelper(attributes).message("Profile not found.").error();
            return "redirect:/dashboard/ums/profile";
        }

        List<UserEducation> userEducations = this.userEducationService.getAllBy("user", user);

        model.addAttribute("user", user);
        model.addAttribute("userEducations", userEducations);

        return "dashboard/ums/user/profile/index";
    }

    @RequestMapping(value = "/update-basic", method = RequestMethod.POST)
    public String updateBasic(@Valid @ModelAttribute UserBasicDto userBasicDto, BindingResult result, Authentication auth, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userBasicDto", userBasicDto).bind(result);
            return "redirect:/dashboard/ums/profile#basic";
        }

        User user = this.userService.getByUsername(auth.getName());

        if (user == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile#basic";
        }

        try {
            user.setName(userBasicDto.getName());
            user.setUsername(userBasicDto.getUsername());
            user.setDob(userBasicDto.getDob());
            user.setEmail(userBasicDto.getEmail());
            user.setMobile(userBasicDto.getMobile());
            user.setAddress(userBasicDto.getAddress());

            this.userService.update(user);
            new NotifierHelper(attributes).message("Account updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Account can not be updated.").error();
        }

        return "redirect:/dashboard/ums/profile#basic";
    }

    @RequestMapping(value = "/store-education", method = RequestMethod.POST)
    public String storeEducation(@Valid @ModelAttribute UserEducation userEducation, BindingResult result, Authentication auth, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userEducation", userEducation).bind(result);
            return "redirect:/dashboard/ums/profile#education";
        }

        User user = this.userService.getByUsername(auth.getName());

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userEducation.setUser(user);
            this.userEducationService.save(userEducation);
            new NotifierHelper(attributes).message("Education added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Education can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile#education";
    }

    @RequestMapping(value = "/{id}/update-education", method = RequestMethod.POST)
    public String updateEducation(@PathVariable("id") Long id, @Valid @ModelAttribute UserEducation userEducation, BindingResult result, Authentication auth, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userEducation", userEducation).bind(result);
            return "redirect:/dashboard/ums/profile#education";
        }

        User user = this.userService.getByUsername(auth.getName());

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userEducation.setId(id);
            userEducation.setUser(user);
            this.userEducationService.update(userEducation);

            new NotifierHelper(attributes).message("Education updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Education can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile#education";
    }

    @RequestMapping(value = "/{id}/destroy-education", method = RequestMethod.POST)
    public String destroyEducation(@PathVariable("id") Long id, Authentication auth, RedirectAttributes attributes) {

        UserEducation userEducation = this.userEducationService.get(id);

        if (userEducation == null) {
            new NotifierHelper(attributes).message("Education not found.").error();
        }

        try {
            this.userEducationService.delete(userEducation);
            new NotifierHelper(attributes).message("Education deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Education can not ber deleted.").error();
        }

        return "redirect:/dashboard/ums/profile#education";
    }
}
