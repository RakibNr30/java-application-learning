package com.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/about")
public class AboutController {

    @RequestMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        String value = null;

        value.trim();

        modelAndView.addObject("title", "About Us");
        modelAndView.addObject("location", "Dhaka, Bangladeh");
        modelAndView.addObject("time", LocalDateTime.now());
        modelAndView.setViewName("front/about/index");

        return modelAndView;
    }

    /* moves to GlobalExceptionHandler */
    /*@ExceptionHandler({ NullPointerException.class })
    public String nullPointerException(Model model) {
        model.addAttribute("status", 500);
        model.addAttribute("message", "Null Pointer Exception has Occurred.");
        return "front/error/index";
    }*/
}
