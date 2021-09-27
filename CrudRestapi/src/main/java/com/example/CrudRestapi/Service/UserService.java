package com.example.CrudRestapi.Service;

import com.example.CrudRestapi.UserExceptionHandlers.UserNotFoundException;
import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    /* Create User */
    public User createUser(User user) {
        return repository.save(user);
    }

    /* delete User */
    public void deleteUser(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(id);
        } else {
            repository.deleteById(id);
        }
    }

    /* Detail User */
    public Optional<User> listUser(Long id) {

        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException(id);
        } else {
            return repository.findById(id);
        }
    }

    /* List User */
    public List<User> listAllusers() {
        return repository.findAll();
    }
    /* Update User */
    public User updateUser(Long id, User user) {

        Optional<User> userOptional = repository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException(id);
        } else {
            repository.findById(id);
            return repository.save(user);
        }
    }
}