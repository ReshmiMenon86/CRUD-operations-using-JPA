package com.example.CrudRestapi.UserService;

import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserExceptionHandlers.UserNotFoundException;
import com.example.CrudRestapi.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService {

    @Autowired
    UserRepository repository;

    public void deleteUser(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(id);
        } else {
            repository.deleteById(id);
        }
    }
}
