package com.resume.utils;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Notifier {
    private final RedirectAttributes attributes;

    public Notifier(RedirectAttributes attributes) {
        this.attributes = attributes;
    }

    public Notifier message(String message) {
        this.attributes.addFlashAttribute("notifierMessage", message);
        return this;
    }

    public void success() {
        this.attributes.addFlashAttribute("notifierStatus", "success");
        this.attributes.addFlashAttribute("notifierBg", "success");
        this.attributes.addFlashAttribute("notifierTitle", "Success!");
    }

    public void warning() {
        this.attributes.addFlashAttribute("notifierStatus", "warning");
        this.attributes.addFlashAttribute("notifierBg", "warning");
        this.attributes.addFlashAttribute("notifierTitle", "Warning!");
    }

    public void error() {
        this.attributes.addFlashAttribute("notifierStatus", "error");
        this.attributes.addFlashAttribute("notifierBg", "danger");
        this.attributes.addFlashAttribute("notifierTitle", "Error!");
    }
}
