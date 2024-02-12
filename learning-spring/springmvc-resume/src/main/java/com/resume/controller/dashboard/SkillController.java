package com.resume.controller.dashboard;

import com.resume.entity.Skill;
import com.resume.service.SkillService;
import com.resume.utils.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller("dashboardSkillController")
@RequestMapping("/dashboard/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("title", "Skill");
    }

    @RequestMapping
    public String index(Model model) {
        List<Skill> skills = this.skillService.getAll();
        model.addAttribute("skills", skills);

        return "dashboard/skill/index";
    }

    @RequestMapping("/create")
    public String create() {
        return "dashboard/skill/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@ModelAttribute Skill skill, RedirectAttributes attributes) {
        try {
            this.skillService.save(skill);
            new Notifier(attributes).message("Skill added successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());

            new Notifier(attributes).message("Skill can not be added.").error();
            return "redirect:/dashboard/skill/create";
        }

        return "redirect:/dashboard/skill";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        Skill skill = this.skillService.get(id);

        if (skill == null) {
            new Notifier(attributes).message("Skill not found.").error();
            return "redirect:/dashboard/skill";
        }

        model.addAttribute("skill", skill);

        return "dashboard/skill/show";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        Skill skill = this.skillService.get(id);

        if (skill == null) {
            new Notifier(attributes).message("Skill not found.").error();
            return "redirect:/dashboard/skill";
        }

        model.addAttribute("skill", skill);

        return "dashboard/skill/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, @ModelAttribute Skill skill, RedirectAttributes attributes) {

        Skill updatableSkill = this.skillService.get(id);

        if (updatableSkill == null) {
            new Notifier(attributes).message("Skill not found.").error();
            return "redirect:/dashboard/skill";
        }

        try {
            this.skillService.update(skill);
            new Notifier(attributes).message("Skill updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new Notifier(attributes).message("Skill can not be updated.").error();
        }

        return "redirect:/dashboard/skill/" + id + "/edit";
    }

    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, RedirectAttributes attributes) {

        Skill skill = this.skillService.get(id);

        if (skill == null) {
            new Notifier(attributes).message("Skill not found.").error();
        }

        try {
            this.skillService.delete(skill);
            new Notifier(attributes).message("Skill deleted successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new Notifier(attributes).message("Skill can not be deleted.").error();
        }

        return "redirect:/dashboard/skill";
    }
}
