package com.unay.taskmanager.controller;

import com.unay.taskmanager.model.User;
import com.unay.taskmanager.service.UserService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createNewUser(@RequestBody Map<String, String> map) {
        return new ResponseEntity<>(userService.createNewUser(map), HttpStatus.OK);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updatePassword(@RequestBody Map<String, String> map) {
        return new ResponseEntity<>(userService.updatePassword(map), HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkUsername(@RequestBody Map<String, String> map) {
        return new ResponseEntity<>(userService.checkUsername(map), HttpStatus.ACCEPTED);
    }
}
