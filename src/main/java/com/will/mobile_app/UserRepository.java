package com.will.mobile_app;


import com.will.mobile_app.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

//    UserEntity findUserByEmail(String email);
}
