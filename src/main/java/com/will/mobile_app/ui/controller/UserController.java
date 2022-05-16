package com.will.mobile_app.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")//http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser(){

        return "Get user was called!";
    }

    @PostMapping
    public String createUser(){

        return "Create user was called!";
    }

    @PutMapping
    public String updateUser(){

        return "User was updated!";
    }

    @DeleteMapping
    public String deleteUser(){

        return "User was deleted!";
    }
}
