package com.example.CrudRestapi.UserService;

import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserService {

    @Autowired
    UserRepository repository;

    public List<User> listAllUsers() {
        return repository.findAll();
    }
}
