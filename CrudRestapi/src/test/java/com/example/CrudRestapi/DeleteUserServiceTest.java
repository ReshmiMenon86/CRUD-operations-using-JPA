package com.example.CrudRestapi;


import com.example.CrudRestapi.UserController.CreateUserController;
import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserRepository.UserRepository;
import com.example.CrudRestapi.UserService.CreateUserService;
import com.example.CrudRestapi.UserService.DeleteUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeleteUserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private DeleteUserService deleteUserService;
    @Autowired
    CreateUserService createUser;


  /* @Test
    public void whenGivenId_shouldDeleteUser_ifFound(){

        CreateUserController userController= new CreateUserController();
        User user=createUser.createNewUser(new com.example.CrudRestapi.UserModel.User(5L, "Veena", "Vee@gmail.com"));
        userController.createNewUser_whenPostUser(user);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        deleteUserService.deleteUser(user.getId());
        verify(userRepository).deleteById(user.getId());
    }*/
    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_user_doesnt_exist() {
        User user=createUser.createNewUser(new com.example.CrudRestapi.UserModel.User(5L, "Veena", "Vee@gmail.com"));
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        given(userRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
        deleteUserService.deleteUser(user.getId());
    }
}