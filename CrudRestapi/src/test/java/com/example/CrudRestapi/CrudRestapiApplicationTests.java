package com.example.CrudRestapi;

import com.example.CrudRestapi.UserController.*;
import com.example.CrudRestapi.UserExceptionHandlers.UserNotFoundException;
import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.UserRepository.UserRepository;
import com.example.CrudRestapi.UserService.*;
import com.sun.net.httpserver.Authenticator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CrudRestapiApplicationTests {


	@Test
	void contextLoads() {
	}

	/*Testing DetailUser using Mockito*/
	@Mock
	DetailUserService DetailUser;
	@InjectMocks
	DetailUserController DetailController;

	@Test
	public void testDetailUserFunction() {
		when(DetailUser.listUser(1L)).thenReturn(java.util.Optional.of(new User(1L, "reshmi", "resh@gmail.com")));
		ResponseEntity<Optional<User>> results = DetailController.listUser_whenGetUser(1);
		assertEquals(Optional.of(new User(1L, "reshmi", "resh@gmail.com")), results.getBody());
	}

	/*Testing CreateUser using Mockito*/

	@Mock
	CreateUserService CreateUser;
	@InjectMocks
	CreateUserController CreateController;

	@Test
	public void testCreateUserFunction() {
		when(CreateUser.createNewUser(new User(5L, "Veena", "Vee@gmail.com"))).thenReturn(new User(5L, "Veena", "Vee@gmail.com"));
		ResponseEntity<User> results = CreateController.createNewUser_whenPostUser(new User(5L, "Veena", "Vee@gmail.com"));
		assertEquals(new User(5L, "Veena", "Vee@gmail.com"), results.getBody());
	}

	/*Testing Update User using Mockito*/

	@Mock
	UpdateUserService UpdateUser;
	@InjectMocks
	UpdateUserController UpdateController;

	@Test
	public void testUpdateUserFunction() {
		when(UpdateUser.updateUser(5L,new User(5L, "Veena", "Vee@gmail.com"))).thenReturn(new User(5L, "Veena", "Vee@gmail.com"));
		ResponseEntity<User> results = UpdateController.updateUser_whenPutUser(new User(5L, "Veena", "Vee@gmail.com"),5L);
		assertEquals(new User(5L, "Veena", "Vee@gmail.com"), results.getBody());
	}

	/*Testing Delete  User using Mockito*/





}






