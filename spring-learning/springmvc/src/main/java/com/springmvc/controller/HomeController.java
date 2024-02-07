package com.springmvc.controller;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @ModelAttribute
    public void commonData(Model model) {
        model.addAttribute("title", "Home");
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("BB");
        list.add("CCC");
        list.add("DDDD");
        list.add("EEEEE");

        model.addAttribute("name", "Abdur Rakib");
        model.addAttribute("mobile", "01710115566");
        model.addAttribute("list", list);

        return "front/home/index";
    }
}
