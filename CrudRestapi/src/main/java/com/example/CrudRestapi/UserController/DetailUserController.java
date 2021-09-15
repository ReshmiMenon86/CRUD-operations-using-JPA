package com.example.CrudRestapi.UserController;

import com.example.CrudRestapi.UserService.DetailUserService;
import com.example.CrudRestapi.UserModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users/{id}")
public class DetailUserController {

    @Autowired
    DetailUserService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<User>> listUser_whenGetUser(@PathVariable int id) {
        return ResponseEntity.ok().body(service.listUser((long) id));
    }
}
