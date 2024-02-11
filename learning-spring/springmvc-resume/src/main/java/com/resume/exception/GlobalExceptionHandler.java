package com.resume.exception;

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

    @ExceptionHandler({ Exception.class })
    public String notFoundException(Model model, Exception e) {
        model.addAttribute("status", HttpStatus.BAD_REQUEST);
        model.addAttribute("message", e.getMessage());
        return "front/error/index";
    }
}
