package com.example.CrudRestapi;


import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserRepository.UserRepository;
import com.example.CrudRestapi.Service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;



    @Test(expected = RuntimeException.class)
    public void testCreateuser() {
        User user=new User(5L, "Veena", "Vee@gmail.com");
        when(userRepository.save(user)).thenReturn(user);
        User createdUser= userService.createUser(user);
        userService.listUser(createdUser.getId());
        /*assertSame(user,createdUser);*/
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteuser() {
        User user=new User(5L, "Veena", "Vee@gmail.com");
        /*when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        given(userRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));*/
        userService.deleteUser(user.getId());
    }

    @Test
    public void testListusers() {
        List<User> users = new ArrayList();
        users.add(new User());
        given(userRepository.findAll()).willReturn(users);
        List<User> expected = userService.listAllusers();
        assertEquals(expected, users);
        verify(userRepository).findAll();
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateuser() {
        User user=new User(5L, "Veena", "Vee@gmail.com");
        /*when(userRepository.save(user)).thenReturn(user);*/
        User updatedUser= userService.updateUser(user.getId(),user);
        assertEquals(user,updatedUser);
    }

    @Test
    public void testListuser() {
        User user=new User(5L, "Veena", "Vee@gmail.com");
        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));
        Optional<User> expected = userService.listUser(user.getId());
        assertEquals(expected, Optional.of(user));
        /*verify(userRepository).findById(5L);*/
    }
}