package com.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ NullPointerException.class })
    public String nullPointerException(Model model) {
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        model.addAttribute("message", "Null Pointer Exception has Occurred.");
        return "front/error/index";
    }

    @ExceptionHandler({ NumberFormatException.class })
    public String numberFormatException(Model model) {
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        model.addAttribute("message", "Number Format Exception has Occurred.");
        return "front/error/index";
    }
}
