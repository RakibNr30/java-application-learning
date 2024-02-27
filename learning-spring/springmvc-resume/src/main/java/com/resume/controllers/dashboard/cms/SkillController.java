package com.resume.controllers.dashboard.cms;

import com.resume.entities.cms.Skill;
import com.resume.helpers.ValidationHelper;
import com.resume.services.cms.SkillService;
import com.resume.helpers.NotifierHelper;
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
@RequestMapping("/dashboard/cms/skill")
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "Skill");
    }

    @ModelAttribute
    public Skill getSkill() {
        return new Skill();
    }

    @RequestMapping
    public String index(Model model) {
        List<Skill> skills = this.skillService.getAll();
        model.addAttribute("skills", skills);

        return "dashboard/cms/skill/index";
    }

    @RequestMapping("/create")
    public String create() {
        return "dashboard/cms/skill/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@Valid @ModelAttribute Skill skill, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("skill", skill).bind(result);
            return "redirect:/dashboard/cms/skill/create";
        }

        try {
            this.skillService.save(skill);
            new NotifierHelper(attributes).message("Skill added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new NotifierHelper(attributes).message("Skill can not be added.").error();
            return "redirect:/dashboard/cms/skill/create";
        }

        return "redirect:/dashboard/cms/skill/";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        Skill skill = this.skillService.get(id);

        if (skill == null) {
            new NotifierHelper(attributes).message("Skill not found.").error();
            return "redirect:/dashboard/cms/skill/";
        }

        model.addAttribute("skill", skill);

        return "dashboard/cms/skill/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {

        Skill skill = this.skillService.get(id);

        if (skill == null) {
            new NotifierHelper(attributes).message("Skill not found.").error();
            return "redirect:/dashboard/cms/skill/";
        }

        model.addAttribute("skill", skill);

        return "dashboard/cms/skill/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute Skill skill, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("skill", skill).bind(result);
            return "redirect:/dashboard/cms/skill/" + id + "/edit";
        }

        Skill updatableSkill = this.skillService.get(id);

        if (updatableSkill == null) {
            new NotifierHelper(attributes).message("Skill not found.").error();
            return "redirect:/dashboard/cms/skill/";
        }

        try {
            this.skillService.update(skill);
            new NotifierHelper(attributes).message("Skill updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Skill can not be updated.").error();
        }

        return "redirect:/dashboard/cms/skill/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {

        Skill skill = this.skillService.get(id);

        if (skill == null) {
            new NotifierHelper(attributes).message("Skill not found.").error();
        }

        try {
            this.skillService.delete(skill);
            new NotifierHelper(attributes).message("Skill deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Skill can not be deleted.").error();
        }

        return "redirect:/dashboard/cms/skill/";
    }
}
