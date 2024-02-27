package com.resume.controllers.dashboard.ums;

import com.resume.converters.RolePropertyEditor;
import com.resume.converters.SkillPropertyEditor;
import com.resume.entities.ums.Role;
import com.resume.entities.cms.Skill;
import com.resume.entities.ums.User;
import com.resume.helpers.ValidationHelper;
import com.resume.services.ums.RoleService;
import com.resume.services.cms.SkillService;
import com.resume.services.ums.UserService;
import com.resume.helpers.NotifierHelper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("dashboardUserController")
@RequestMapping("/dashboard/ums/user")
public class UserController {

    private final UserService userService;

    private final SkillService skillService;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, SkillService skillService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.skillService = skillService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "User");
    }

    @ModelAttribute
    public User getUser() {
        return new User();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Skill.class, new SkillPropertyEditor(skillService));
        binder.registerCustomEditor(Role.class, new RolePropertyEditor(roleService));
    }

    @RequestMapping
    public String index(Model model) {
        List<User> users = this.userService.getAllByRoleName(com.resume.constants.Role.ROLE_USER.name());
        model.addAttribute("users", users);

        return "dashboard/ums/user/index";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        List<Skill> skills = this.skillService.getAll();
        List<Role> roles = this.roleService.getAll();

        model.addAttribute("skills", skills);
        model.addAttribute("roles", roles);
        return "dashboard/ums/user/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("user", user).bind(result);
            return "redirect:/dashboard/ums/user/create";
        }

        try {
            user.setPassword(passwordEncoder.encode("password"));
            this.userService.save(user);

            new NotifierHelper(attributes).message("User added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("User can not be added.").error();
            return "redirect:/dashboard/ums/user/create";
        }

        return "redirect:/dashboard/ums/user";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        User user = this.userService.get(id);

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
            return "redirect:/dashboard/ums/user";
        }

        model.addAttribute("user", user);

        return "dashboard/ums/user/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {

        User user = (User) model.getAttribute("user");

        assert user != null;
        if (user.isEmpty()) {
            user = this.userService.get(id);
        }

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
            return "redirect:/dashboard/ums/user";
        }

        List<Skill> skills = this.skillService.getAll();
        List<Role> roles = this.roleService.getAll();

        model.addAttribute("user", user);
        model.addAttribute("skills", skills);
        model.addAttribute("roles", roles);

        return "dashboard/ums/user/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute User user, BindingResult result, RedirectAttributes attributes) {
        
        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("user", user).bind(result);
            return "redirect:/dashboard/ums/user/" + id + "/edit";
        }

        User existingUser = this.userService.get(id);

        if (existingUser == null) {
            new NotifierHelper(attributes).message("User not found.").error();
            return "redirect:/dashboard/ums/user";
        }

        try {
            user.setPassword(passwordEncoder.encode("password"));
            this.userService.update(user);
            
            new NotifierHelper(attributes).message("User updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("User can not be updated.").error();
        }

        return "redirect:/dashboard/ums/user/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {

        User user = this.userService.get(id);

        if (user == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            this.userService.delete(user);
            new NotifierHelper(attributes).message("User deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("User can not ber deleted.").error();
        }

        return "redirect:/dashboard/ums/user";
    }
}
