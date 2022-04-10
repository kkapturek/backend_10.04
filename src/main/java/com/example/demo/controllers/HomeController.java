package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String template() {
        return "template";
    }
}
