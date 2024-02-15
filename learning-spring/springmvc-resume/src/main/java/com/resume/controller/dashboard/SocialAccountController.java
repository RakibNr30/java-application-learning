package com.resume.controller.dashboard;

import com.resume.entity.SocialAccount;
import com.resume.helpers.NotifierHelper;
import com.resume.helpers.ValidationHelper;
import com.resume.service.SocialAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/dashboard/social-account")
public class SocialAccountController {

    @Autowired
    private SocialAccountService socialAccountService;

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "Social Account");
    }

    @ModelAttribute
    public SocialAccount getSocialAccount() {
        return new SocialAccount();
    }

    @RequestMapping
    public String index(Model model) {
        List<SocialAccount> socialAccounts = this.socialAccountService.getAll();
        model.addAttribute("socialAccounts", socialAccounts);

        return "dashboard/social-account/index";
    }

    @RequestMapping("/create")
    public String create() {
        return "dashboard/social-account/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute SocialAccount socialAccount, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("socialAccount", socialAccount).bind(result);
            return "redirect:/dashboard/social-account/create";
        }

        try {
            this.socialAccountService.save(socialAccount);
            new NotifierHelper(attributes).message("Social account added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Social account can not be added.").error();
            return "redirect:/dashboard/social-account/create";
        }

        return "redirect:/dashboard/social-account";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        SocialAccount socialAccount = this.socialAccountService.get(id);

        if (socialAccount == null) {
            new NotifierHelper(attributes).message("Social account not found.").error();
            return "redirect:/dashboard/social-account";
        }

        model.addAttribute("socialAccount", socialAccount);

        return "dashboard/social-account/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {

        SocialAccount socialAccount = this.socialAccountService.get(id);

        if (socialAccount == null) {
            new NotifierHelper(attributes).message("Social account not found.").error();
            return "redirect:/dashboard/social-account";
        }

        model.addAttribute("socialAccount", socialAccount);

        return "dashboard/social-account/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute SocialAccount socialAccount, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("socialAccount", socialAccount).bind(result);
            return "redirect:/dashboard/social-account/" + id + "/edit";
        }

        SocialAccount updatableSocialAccount = this.socialAccountService.get(id);

        if (updatableSocialAccount == null) {
            new NotifierHelper(attributes).message("Social account not found.").error();
            return "redirect:/dashboard/social-account";
        }

        try {
            this.socialAccountService.update(socialAccount);
            new NotifierHelper(attributes).message("Social account updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Social account can not be updated.").error();
        }

        return "redirect:/dashboard/social-account/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {

        SocialAccount socialAccount = this.socialAccountService.get(id);

        if (socialAccount == null) {
            new NotifierHelper(attributes).message("Social account not found.").error();
        }

        try {
            this.socialAccountService.delete(socialAccount);
            new NotifierHelper(attributes).message("Social account deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Social account can not be deleted.").error();
        }

        return "redirect:/dashboard/social-account";
    }
}
