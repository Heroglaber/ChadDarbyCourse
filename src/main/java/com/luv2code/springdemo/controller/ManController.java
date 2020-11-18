package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManController {
    @RequestMapping("/")
    public String mainPage() {
        return "main-page";
    }
}
