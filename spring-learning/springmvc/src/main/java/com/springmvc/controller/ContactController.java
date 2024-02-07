package com.springmvc.controller;

import com.springmvc.entity.Contact;
import com.springmvc.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @ModelAttribute
    public void commonData(Model model) {
        model.addAttribute("title", "Contact");
    }

    @RequestMapping
    public String index(Model model) {

        Contact contact = this.contactService.getOrSave(1);

        model.addAttribute("contact", contact);

        return "front/contact/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Contact contact, Model model)
    {
        try {
            this.contactService.saveOrUpdate(contact);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        model.addAttribute("contact", contact);

        return "redirect:/contact";
    }
}
