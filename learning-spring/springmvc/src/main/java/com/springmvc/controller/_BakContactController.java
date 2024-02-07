package com.springmvc.controller;

import com.springmvc.entity.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/contact")
public class _BakContactController {

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("title", "Contact Us");

        return "front/contact/index";
    }

    /* get parameters using HttpServletRequest */
    /*@RequestMapping(method = RequestMethod.POST)
    public String store(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        System.out.println(name + " - " + email + " - " + mobile);

        return "front/contact/index";
    }*/

    /* get parameters using @RequestParam */
    /*@RequestMapping(method = RequestMethod.POST)
    public String store(
            Model model,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("mobile") String mobile,
            @RequestParam("content") String content)
    {

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("mobile", mobile);
        model.addAttribute("content", content);

        return "front/contact/index";
    }*/

    /* get parameters using Model */
    /*@RequestMapping(method = RequestMethod.POST)
    public String store(
            Model model,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("mobile") String mobile,
            @RequestParam("content") String content)
    {

        Contact contact = new Contact();
        contact.setId(1);
        contact.setName(name);
        contact.setEmail(email);
        contact.setMobile(mobile);
        contact.setContent(content);

        model.addAttribute("contact", contact);

        return "front/contact/index";
    }*/

    /* get parameters using @ModelAttribute */
    @RequestMapping(method = RequestMethod.POST)
    public String store(@ModelAttribute Contact contact, Model model)
    {
        model.addAttribute("contact", contact);

        return "front/contact/index";
    }
}
