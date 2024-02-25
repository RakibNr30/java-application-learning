package com.resume.controller.dashboard.ums.profile;

import com.resume.entity.ums.User;
import com.resume.helpers.NotifierHelper;
import com.resume.service.ums.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/dashboard/ums/profile")
public class UserProfileController {

    private final UserService userService;

    @Autowired
    public UserProfileController(UserService userService) {
        this.userService = userService;
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

        model.addAttribute("user", user);

        return "dashboard/ums/user/profile/index";
    }

    @RequestMapping(value = "/update-basic", method = RequestMethod.POST)
    public String updateBasic(Model model, @ModelAttribute User user, Authentication auth, RedirectAttributes attributes) {
        User updatableUser = this.userService.getByUsername(auth.getName());

        if (updatableUser == null) {
            new NotifierHelper(attributes).message("Profile not found.").error();
            return "redirect:/dashboard/ums/profile#basic";
        }

        try {
            user.setId(updatableUser.getId());
            this.userService.update(user);
            new NotifierHelper(attributes).message("Profile basic updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Profile basic can not be updated.").error();
        }

        return "redirect:/dashboard/ums/profile#basic";
    }
}
