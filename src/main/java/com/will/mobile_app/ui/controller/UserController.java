package com.will.mobile_app.ui.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.will.mobile_app.service.UserService;
import com.will.mobile_app.shared.dto.UserDTO;
import com.will.mobile_app.ui.model.request.UserDetailsRequestModel;
import com.will.mobile_app.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.fasterxml.jackson.databind.util.BeanUtil.*;

@RestController
@RequestMapping("users")//http://localhost:8080/users
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){

        return "Get user was called!";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, returnValue);


        return null;
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
