package com.security.controller;

import com.security.dto.SignUpDTO;
import com.security.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SignUpRepository signUpRepository;

    @ModelAttribute
    public SignUpDTO getSignUpDTO() {
        SignUpDTO signUpDTO = new SignUpDTO();
        signUpDTO.setId(1);

        return signUpDTO;
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/handle-signup", method = RequestMethod.POST)
    public String handleSignup(@ModelAttribute SignUpDTO signUpDTO) {
        signUpDTO.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        System.out.println(signUpDTO);

        this.signUpRepository.save(signUpDTO);

        System.out.println("============");

        return "redirect:/login";
    }
}
