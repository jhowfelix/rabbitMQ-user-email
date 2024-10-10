package com.ms.user.services;

import com.ms.user.producers.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserProducer userProducer;

    @Autowired
    UserRepository repository;

    @Transactional
    public UserModel save(UserModel userModel){
        UserModel userSaved = repository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userSaved;
    }

}
