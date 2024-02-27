package com.resume.controller.dashboard.ums.profile;

import com.resume.dtos.UserAccountDto;
import com.resume.entity.cms.Interest;
import com.resume.entity.cms.Language;
import com.resume.entity.cms.SocialAccount;
import com.resume.entity.ums.*;
import com.resume.helpers.NotifierHelper;
import com.resume.helpers.ValidationHelper;
import com.resume.service.cms.InterestService;
import com.resume.service.cms.LanguageService;
import com.resume.service.cms.SocialAccountService;
import com.resume.service.ums.*;
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

    private final UserExperienceService userExperienceService;

    private final UserAwardService userAwardService;

    private final UserInterestService userInterestService;

    private final UserSocialAccountService userSocialAccountService;

    private final UserLanguageService userLanguageService;

    private final InterestService interestService;

    private final SocialAccountService socialAccountService;

    private final LanguageService languageService;

    private User authUser;

    @Autowired
    public UserProfileController(
            UserService userService,
            UserEducationService userEducationService,
            UserExperienceService userExperienceService,
            UserAwardService userAwardService,
            UserInterestService userInterestService,
            UserSocialAccountService userSocialAccountService,
            UserLanguageService userLanguageService,
            InterestService interestService,
            SocialAccountService socialAccountService,
            LanguageService languageService)
    {
        this.userService = userService;
        this.userEducationService = userEducationService;
        this.userExperienceService = userExperienceService;
        this.userAwardService = userAwardService;
        this.userInterestService = userInterestService;
        this.userSocialAccountService = userSocialAccountService;
        this.userLanguageService = userLanguageService;
        this.interestService = interestService;
        this.socialAccountService = socialAccountService;
        this.languageService = languageService;
    }

    @ModelAttribute
    public void common(Model model, Authentication auth) {
        this.authUser = this.userService.getByUsername(auth.getName());

        model.addAttribute("title", "My Profile");
    }

    /* Account */
    @RequestMapping
    public String index(Model model, RedirectAttributes attributes) {
        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile";
        }

        model.addAttribute("user", this.authUser);

        return "dashboard/ums/user/profile/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute UserAccountDto userAccountDto, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userBasicDto", userAccountDto).bind(result);
            return "redirect:/dashboard/ums/profile";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile";
        }

        try {
            this.authUser.setName(userAccountDto.getName());
            this.authUser.setUsername(userAccountDto.getUsername());
            this.authUser.setDob(userAccountDto.getDob());
            this.authUser.setEmail(userAccountDto.getEmail());
            this.authUser.setMobile(userAccountDto.getMobile());
            this.authUser.setAddress(userAccountDto.getAddress());

            this.userService.update(this.authUser);
            new NotifierHelper(attributes).message("Account updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Account can not be updated.").error();
        }

        return "redirect:/dashboard/ums/profile";
    }

    /* Education */
    @RequestMapping("/education")
    public String education(Model model, RedirectAttributes attributes) {

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Profile not found.").error();
            return "redirect:/dashboard/ums/profile/education";
        }

        List<UserEducation> userEducations = this.userEducationService.getAllBy("user", this.authUser);

        model.addAttribute("user", this.authUser);
        model.addAttribute("userEducations", userEducations);

        return "dashboard/ums/user/profile/education";
    }

    @RequestMapping(value = "/education/store", method = RequestMethod.POST)
    public String storeEducation(@Valid @ModelAttribute UserEducation userEducation, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userEducation", userEducation).bind(result);
            return "redirect:/dashboard/ums/profile/education";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
        }

        try {
            userEducation.setUser(this.authUser);
            this.userEducationService.save(userEducation);
            new NotifierHelper(attributes).message("Education added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Education can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/education";
    }

    @RequestMapping(value = "/education/{id}/update", method = RequestMethod.POST)
    public String updateEducation(@PathVariable("id") Long id, @Valid @ModelAttribute UserEducation userEducation, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userEducation", userEducation).bind(result);
            return "redirect:/dashboard/ums/profile/education";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
        }

        try {
            userEducation.setId(id);
            userEducation.setUser(this.authUser);
            this.userEducationService.update(userEducation);

            new NotifierHelper(attributes).message("Education updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Education can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/education";
    }

    @RequestMapping(value = "/education/{id}/destroy", method = RequestMethod.POST)
    public String destroyEducation(@PathVariable("id") Long id, RedirectAttributes attributes) {

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

        return "redirect:/dashboard/ums/profile/education";
    }

    /* Experience */
    @RequestMapping("/experience")
    public String experience(Model model, RedirectAttributes attributes) {

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile/experience";
        }

        List<UserExperience> userExperiences = this.userExperienceService.getAllBy("user", this.authUser);

        model.addAttribute("user", this.authUser);
        model.addAttribute("userExperiences", userExperiences);

        return "dashboard/ums/user/profile/experience";
    }

    @RequestMapping(value = "/experience/store", method = RequestMethod.POST)
    public String storeExperience(@Valid @ModelAttribute UserExperience userExperience, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userExperience", userExperience).bind(result);
            return "redirect:/dashboard/ums/profile/experience";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
        }

        try {
            userExperience.setUser(this.authUser);
            this.userExperienceService.save(userExperience);
            new NotifierHelper(attributes).message("Experience added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Experience can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/experience";
    }

    @RequestMapping(value = "/experience/{id}/update", method = RequestMethod.POST)
    public String updateExperience(@PathVariable("id") Long id, @Valid @ModelAttribute UserExperience userExperience, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userExperience", userExperience).bind(result);
            return "redirect:/dashboard/ums/profile/experience";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userExperience.setId(id);
            userExperience.setUser(this.authUser);
            this.userExperienceService.update(userExperience);

            new NotifierHelper(attributes).message("Experience updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Experience can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/experience";
    }

    @RequestMapping(value = "/experience/{id}/destroy", method = RequestMethod.POST)
    public String destroyExperience(@PathVariable("id") Long id, RedirectAttributes attributes) {

        UserExperience userExperience = this.userExperienceService.get(id);

        if (userExperience == null) {
            new NotifierHelper(attributes).message("Experience not found.").error();
        }

        try {
            this.userExperienceService.delete(userExperience);
            new NotifierHelper(attributes).message("Experience deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Experience can not ber deleted.").error();
        }

        return "redirect:/dashboard/ums/profile/experience";
    }

    /* Award */
    @RequestMapping("/award")
    public String award(Model model, RedirectAttributes attributes) {

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile/award";
        }

        List<UserAward> userAwards = this.userAwardService.getAllBy("user", this.authUser);

        model.addAttribute("user", this.authUser);
        model.addAttribute("userAwards", userAwards);

        return "dashboard/ums/user/profile/award";
    }

    @RequestMapping(value = "/award/store", method = RequestMethod.POST)
    public String storeAward(@Valid @ModelAttribute UserAward userAward, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userAward", userAward).bind(result);
            return "redirect:/dashboard/ums/profile/award";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
        }

        try {
            userAward.setUser(this.authUser);
            this.userAwardService.save(userAward);
            new NotifierHelper(attributes).message("Award added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Award can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/award";
    }

    @RequestMapping(value = "/award/{id}/update", method = RequestMethod.POST)
    public String updateAward(@PathVariable("id") Long id, @Valid @ModelAttribute UserAward userAward, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userAward", userAward).bind(result);
            return "redirect:/dashboard/ums/profile/award";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userAward.setId(id);
            userAward.setUser(this.authUser);
            this.userAwardService.update(userAward);

            new NotifierHelper(attributes).message("Award updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Award can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/award";
    }

    @RequestMapping(value = "/award/{id}/destroy", method = RequestMethod.POST)
    public String destroyAward(@PathVariable("id") Long id, RedirectAttributes attributes) {

        UserAward userAward = this.userAwardService.get(id);

        if (userAward == null) {
            new NotifierHelper(attributes).message("Award not found.").error();
        }

        try {
            this.userAwardService.delete(userAward);
            new NotifierHelper(attributes).message("Award deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Award can not ber deleted.").error();
        }

        return "redirect:/dashboard/ums/profile/award";
    }

    /* Interest */
    @RequestMapping("/interest")
    public String interest(Model model, RedirectAttributes attributes) {

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile/interest";
        }

        List<Interest> interests = this.interestService.getAll();
        List<UserInterest> userInterests = this.userInterestService.getAllBy("user", this.authUser);

        model.addAttribute("user", this.authUser);
        model.addAttribute("interests", interests);
        model.addAttribute("userInterests", userInterests);

        return "dashboard/ums/user/profile/interest";
    }

    @RequestMapping(value = "/interest/store", method = RequestMethod.POST)
    public String storeInterest(@Valid @ModelAttribute UserInterest userInterest, BindingResult result, @RequestParam("interest_id") Long interestId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userInterest", userInterest).bind(result);
            return "redirect:/dashboard/ums/profile/interest";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
        }

        Interest interest = this.interestService.get(interestId);

        if (interest == null) {
            new NotifierHelper(attributes).message("Interest not found.").error();
        }

        try {
            userInterest.setUser(this.authUser);
            userInterest.setInterest(interest);
            this.userInterestService.save(userInterest);
            new NotifierHelper(attributes).message("Interest added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Interest can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/interest";
    }

    @RequestMapping(value = "/interest/{id}/update", method = RequestMethod.POST)
    public String updateInterest(@PathVariable("id") Long id, @Valid @ModelAttribute UserInterest userInterest, BindingResult result, @RequestParam("interest_id") Long interestId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userInterest", userInterest).bind(result);
            return "redirect:/dashboard/ums/profile/interest";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        Interest interest = this.interestService.get(interestId);

        if (interest == null) {
            new NotifierHelper(attributes).message("Interest not found.").error();
        }

        try {
            userInterest.setId(id);
            userInterest.setUser(this.authUser);
            userInterest.setInterest(interest);
            this.userInterestService.update(userInterest);

            new NotifierHelper(attributes).message("Interest updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Interest can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/interest";
    }

    @RequestMapping(value = "/interest/{id}/destroy", method = RequestMethod.POST)
    public String destroyInterest(@PathVariable("id") Long id, RedirectAttributes attributes) {

        UserInterest userInterest = this.userInterestService.get(id);

        if (userInterest == null) {
            new NotifierHelper(attributes).message("Interest not found.").error();
        }

        try {
            this.userInterestService.delete(userInterest);
            new NotifierHelper(attributes).message("Interest deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Interest can not ber deleted.").error();
        }

        return "redirect:/dashboard/ums/profile/interest";
    }

    /* Social */
    @RequestMapping("/social")
    public String socialAccount(Model model, RedirectAttributes attributes) {

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile/social";
        }

        List<UserSocialAccount> userSocialAccounts = this.userSocialAccountService.getAllBy("user", this.authUser);
        List<SocialAccount> socialAccounts = this.socialAccountService.getAll();

        model.addAttribute("user", this.authUser);
        model.addAttribute("socialAccounts", socialAccounts);
        model.addAttribute("userSocialAccounts", userSocialAccounts);

        return "dashboard/ums/user/profile/social";
    }

    @RequestMapping(value = "/social/store", method = RequestMethod.POST)
    public String storeSocialAccount(@Valid @ModelAttribute UserSocialAccount userSocialAccount, BindingResult result, @RequestParam("social_account_id") Long socialAccountId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userSocialAccount", userSocialAccount).bind(result);
            return "redirect:/dashboard/ums/profile/social";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
        }

        SocialAccount socialAccount = this.socialAccountService.get(socialAccountId);

        if (socialAccount == null) {
            new NotifierHelper(attributes).message("Social account not found.").error();
        }

        try {
            userSocialAccount.setUser(this.authUser);
            userSocialAccount.setSocialAccount(socialAccount);
            this.userSocialAccountService.save(userSocialAccount);
            new NotifierHelper(attributes).message("Social account added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Social account can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/social";
    }

    @RequestMapping(value = "/social/{id}/update", method = RequestMethod.POST)
    public String updateSocialAccount(@PathVariable("id") Long id, @Valid @ModelAttribute UserSocialAccount userSocialAccount, BindingResult result, @RequestParam("social_account_id") Long socialAccountId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userSocialAccount", userSocialAccount).bind(result);
            return "redirect:/dashboard/ums/profile/social";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        SocialAccount socialAccount = this.socialAccountService.get(socialAccountId);

        if (socialAccount == null) {
            new NotifierHelper(attributes).message("Social account not found.").error();
        }

        try {
            userSocialAccount.setId(id);
            userSocialAccount.setUser(this.authUser);
            userSocialAccount.setSocialAccount(socialAccount);
            this.userSocialAccountService.update(userSocialAccount);

            new NotifierHelper(attributes).message("Social account updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Social account can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/social";
    }

    @RequestMapping(value = "/social/{id}/destroy", method = RequestMethod.POST)
    public String destroySocialAccount(@PathVariable("id") Long id, RedirectAttributes attributes) {

        UserSocialAccount userSocialAccount = this.userSocialAccountService.get(id);

        if (userSocialAccount == null) {
            new NotifierHelper(attributes).message("Social account not found.").error();
        }

        try {
            this.userSocialAccountService.delete(userSocialAccount);
            new NotifierHelper(attributes).message("Social account deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Social account can not ber deleted.").error();
        }

        return "redirect:/dashboard/ums/profile/social";
    }

    /* Language */
    @RequestMapping("/language")
    public String language(Model model, RedirectAttributes attributes) {

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
            return "redirect:/dashboard/ums/profile/language";
        }

        List<UserLanguage> userLanguages = this.userLanguageService.getAllBy("user", this.authUser);
        List<Language> languages = this.languageService.getAll();

        model.addAttribute("user", this.authUser);
        model.addAttribute("languages", languages);
        model.addAttribute("userLanguages", userLanguages);

        return "dashboard/ums/user/profile/language";
    }

    @RequestMapping(value = "/language/store", method = RequestMethod.POST)
    public String storeLanguage(@Valid @ModelAttribute UserLanguage userLanguage, BindingResult result, @RequestParam("language_id") Long languageId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userLanguage", userLanguage).bind(result);
            return "redirect:/dashboard/ums/profile/language";
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("Account not found.").error();
        }

        Language language = this.languageService.get(languageId);

        if (language == null) {
            new NotifierHelper(attributes).message("Language not found.").error();
        }

        try {
            userLanguage.setUser(this.authUser);
            userLanguage.setLanguage(language);
            this.userLanguageService.save(userLanguage);
            new NotifierHelper(attributes).message("Language added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Language can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/language";
    }

    @RequestMapping(value = "/language/{id}/update", method = RequestMethod.POST)
    public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute UserLanguage userLanguage, BindingResult result, @RequestParam("language_id") Long languageId, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("userLanguage", userLanguage).bind(result);
            return "redirect:/dashboard/ums/profile/language";
        }

        Language language = this.languageService.get(languageId);

        if (language == null) {
            new NotifierHelper(attributes).message("Language not found.").error();
        }

        if (this.authUser == null) {
            new NotifierHelper(attributes).message("User not found.").error();
        }

        try {
            userLanguage.setId(id);
            userLanguage.setUser(this.authUser);
            userLanguage.setLanguage(language);
            this.userLanguageService.update(userLanguage);

            new NotifierHelper(attributes).message("Language updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Language can not be added.").error();
        }

        return "redirect:/dashboard/ums/profile/language";
    }

    @RequestMapping(value = "/language/{id}/destroy", method = RequestMethod.POST)
    public String destroyLanguage(@PathVariable("id") Long id, RedirectAttributes attributes) {

        UserLanguage userLanguage = this.userLanguageService.get(id);

        if (userLanguage == null) {
            new NotifierHelper(attributes).message("Language not found.").error();
        }

        try {
            this.userLanguageService.delete(userLanguage);
            new NotifierHelper(attributes).message("Language deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Language can not ber deleted.").error();
        }

        return "redirect:/dashboard/ums/profile/language";
    }
}
