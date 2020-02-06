package com.hmd.controller;

import com.hmd.model.User;
import com.hmd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: <a href="mailto:nonamelnl@126.com">NoNamelnl</a>
 * @version: 1.0
 * @create: 2018/6/20
 */
@RestController
public class RestUserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getUser")
    public User getUser(){
        return userRepository.findByUserName("Iron Man");
    }

    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
