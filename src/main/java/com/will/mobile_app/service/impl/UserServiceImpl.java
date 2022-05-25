package com.will.mobile_app.service.impl;

import com.will.mobile_app.io.repositories.UserRepository;
import com.will.mobile_app.io.entity.UserEntity;
import com.will.mobile_app.service.UserService;
import com.will.mobile_app.shared.dto.UserDTO;
import com.will.mobile_app.shared.dto.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static org.springframework.beans.BeanUtils.copyProperties; //git config --global user.email "wtbrown10@gmail.com"

//service class
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO user) {

        UserEntity userEntity = new UserEntity();
        copyProperties(user, userEntity); // user gets properties of userEntity


        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new RuntimeException("Record already exist");

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDTO returnValue = new UserDTO();
        copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(),
                userEntity.getEncryptedPassword(),
                new ArrayList<>());
    }
}
