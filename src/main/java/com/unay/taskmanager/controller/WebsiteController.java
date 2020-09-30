package com.unay.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://127.0.0.1:5501")
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
    @GetMapping(value = "/test")
    public String test(@RequestBody String s){
        System.out.println(s);
        return s;
    }
}
