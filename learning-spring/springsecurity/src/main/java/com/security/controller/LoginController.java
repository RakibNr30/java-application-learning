package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

/*    @RequestMapping(name = "/handle-loginnn", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute Object object) {
        System.out.println(object);
        System.out.println("============");

        return "login";
    }*/
}
