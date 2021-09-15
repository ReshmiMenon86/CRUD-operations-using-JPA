package com.example.CrudRestapi.UserService;

import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateUserService {

    @Autowired
    UserRepository repository;

    public User createNewUser(User user) {
        return repository.save(user);
    }
}