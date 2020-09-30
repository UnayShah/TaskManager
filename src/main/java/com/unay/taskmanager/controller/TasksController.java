package com.unay.taskmanager.controller;

import java.util.List;
import java.util.Map;

import com.unay.taskmanager.model.Tasks;
import com.unay.taskmanager.service.TasksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://127.0.0.1:5501")
@Controller
public class TasksController {
    
    @Autowired
    TasksService tasksService;
    
    @RequestMapping(value = "/getAllTasks", method = RequestMethod.GET)
    public ResponseEntity<List<Tasks>> findAllTasks(){
        return new ResponseEntity<>(tasksService.findAllTasks(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createNewTask(@RequestBody Map<String, String> map){
        return new ResponseEntity<>(tasksService.createNewTask(map), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/findByParentId", method = RequestMethod.POST)
    public ResponseEntity<List<Tasks>> findAllByParentId(@RequestBody Map<String, String> map){
        return new ResponseEntity<>(tasksService.findAllByParentId(map), HttpStatus.ACCEPTED);
    }

}
