package com.will.mobile_app.service;

import com.will.mobile_app.shared.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

//
public interface UserService extends UserDetailsService {
   UserDTO createUser(UserDTO user);

}
