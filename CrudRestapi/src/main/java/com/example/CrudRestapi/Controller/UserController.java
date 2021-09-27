package com.example.CrudRestapi.Controller;

import com.example.CrudRestapi.Service.UserService;
import com.example.CrudRestapi.UserModel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController

public class UserController {

    @Autowired
    UserService service;

    /* Create User */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createNewuser(@RequestBody User user) {

        User createdUser = service.createUser(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(uri).body(createdUser);
    }

    /* List User */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> listAllusers() {
        return ResponseEntity.ok().body(service.listAllusers());
    }

    /* Delete User */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    /*Detail User */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<User>> listUser(@PathVariable int id) {
        return ResponseEntity.ok().body(service.listUser((long) id));
    }
    /* update User */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.updateUser(id, user));
    }
}
