package com.resume.controllers.front;

import com.resume.entities.cms.Contact;
import com.resume.helpers.ValidationHelper;
import com.resume.services.cms.ContactService;
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

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @ModelAttribute
    public void commonData(Model model) {
        model.addAttribute("title", "Contact");
    }

    @ModelAttribute
    public Contact getContact() {
        return this.contactService.getOrSave(1);
    }

    @RequestMapping
    public String index(Model model) {
        return "front/contact/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute Contact contact, BindingResult result, Model model, RedirectAttributes attributes)
    {
        if (result.hasErrors()) {
            new ValidationHelper(attributes).model("contact", contact).bind(result);
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
