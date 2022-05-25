package com.will.mobile_app.io.repositories;


import com.will.mobile_app.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends
        CrudRepository<UserEntity, Long> { //CrudRepository takes class that is being peristed into database and data type of id field

    UserEntity findByEmail(String email);
}
