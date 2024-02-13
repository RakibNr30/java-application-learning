package com.resume.controller;

import com.resume.entity.Contact;
import com.resume.service.ContactService;
import com.resume.helpers.NotifierHelper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @ModelAttribute
    public void commonData(Model model) {
        model.addAttribute("title", "Contact");
    }

    @ModelAttribute("contact")
    public Contact getContact() {
        return new Contact();
    }

    @RequestMapping
    public String index(Model model) {

        Contact contact = this.contactService.getOrSave(1);

        model.addAttribute("contact", contact);

        return "front/contact/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute Contact contact, BindingResult result, Model model, RedirectAttributes attributes)
    {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.contact", result);
            attributes.addFlashAttribute("contact", contact);
            return "redirect:/contact";
        }

        try {
            this.contactService.saveOrUpdate(contact);
            new NotifierHelper(attributes).message("Contact updated successfully.").success();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new NotifierHelper(attributes).message("Contact can not be updated.").error();
        }

        model.addAttribute("contact", contact);

        return "redirect:/contact";
    }
}
