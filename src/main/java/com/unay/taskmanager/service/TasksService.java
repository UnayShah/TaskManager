package com.unay.taskmanager.service;

import java.util.List;
import java.util.Map;

import com.unay.taskmanager.model.Tasks;
import com.unay.taskmanager.repository.TasksRepository;
import com.unay.taskmanager.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

    @Autowired
    TasksRepository tasksRepository;
    @Autowired
    UserRepository userRepository;

    public List<Tasks> findAllTasks() {
        return tasksRepository.findAll();
    }

    public Boolean createNewTask(Map<String, String> map) {
        try {
            Tasks task = new Tasks();
            task.setDescription(map.get("description"));
            task.setParentId(Long.valueOf(map.get("parentId")));
            task.setUser(userRepository.getOne(map.get("username")));
            return !tasksRepository.save(task).equals(null);
        } catch (Exception e) {
            return false;
        }
    }
}
