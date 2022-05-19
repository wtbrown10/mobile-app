package com.will.mobile_app.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.will.mobile_app.UserRepository;
import com.will.mobile_app.io.entity.UserEntity;
import com.will.mobile_app.service.UserService;
import com.will.mobile_app.shared.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.fasterxml.jackson.databind.util.BeanUtil.*;
import static org.springframework.beans.BeanUtils.copyProperties;

//
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO user) {

        UserEntity userEntity = new UserEntity();
        copyProperties(user, userEntity); // user gets properties of userEntity

        userEntity.setEncryptedPassword("test");

        userEntity.setUserId("testUserId");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDTO returnValue = new UserDTO();
        copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
