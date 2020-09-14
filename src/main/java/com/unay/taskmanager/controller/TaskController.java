package com.unay.taskmanager.controller;

import java.util.List;

import com.unay.taskmanager.model.Tasks;
import com.unay.taskmanager.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
    
    @Autowired
    TaskService taskService;
    
    @RequestMapping(value = "/getAllTasks", method = RequestMethod.GET)
    public ResponseEntity<List<Tasks>> findAllTasks(){
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createNewTask(@RequestBody Tasks task){
        return new ResponseEntity<>(taskService.createNewTask(task), HttpStatus.ACCEPTED);
    }
}
