package com.example.CrudRestapi.UserService;

import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserExceptionHandlers.UserNotFoundException;
import com.example.CrudRestapi.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailUserService {

    @Autowired
    UserRepository repository;

    public Optional<User> listUser(Long id) {

        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException(id);
        } else {
            return repository.findById(id);
        }
    }
}
