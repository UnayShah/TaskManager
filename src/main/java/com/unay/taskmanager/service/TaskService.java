package com.unay.taskmanager.service;

import java.util.List;

import com.unay.taskmanager.model.Tasks;
import com.unay.taskmanager.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository tasksRepository;

    public List<Tasks> findAllTasks() {
        return tasksRepository.findAll();
    }

    public Boolean createNewTask(Tasks task){
        return !tasksRepository.save(task).equals(null);
    }
}
