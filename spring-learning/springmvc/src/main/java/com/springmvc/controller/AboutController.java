package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/about")
public class AboutController {

    @RequestMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("title", "About Us");
        modelAndView.addObject("location", "Dhaka, Bangladeh");
        modelAndView.addObject("time", LocalDateTime.now());
        modelAndView.setViewName("front/about/index");

        return modelAndView;
    }
}
