package com.unay.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebsiteController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "userLogin.html";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "newUserRegister.html";
    }    
}
