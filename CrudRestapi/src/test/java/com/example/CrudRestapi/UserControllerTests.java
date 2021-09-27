package com.example.CrudRestapi;

import com.example.CrudRestapi.Controller.*;
import com.example.CrudRestapi.UserModel.User;
import com.example.CrudRestapi.Service.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTests {


	private Object ResponseEntity;

	@Test
	void contextLoads() {
	}

	/*Testing DetailUser using Mockito*/
	@Mock
	UserService service;
	@InjectMocks
	UserController controller;

	@Test
	public void testListuser() {
		when(service.listUser(1L)).thenReturn(java.util.Optional.of(new User(1L, "reshmi", "resh@gmail.com")));
		ResponseEntity<Optional<User>> results = controller.listUser(1);
		assertEquals(Optional.of(new User(1L, "reshmi", "resh@gmail.com")), results.getBody());
	}

	@Test
	public void testListusers() {
		List<User> users = new ArrayList();
		users.add(new User());
		given(service.listAllusers()).willReturn(users);
		ResponseEntity<List<User>> expected =  controller.listAllusers();
		assertEquals(expected.getBody(), users);

	}




	@Test
	public void testCreateuser() {
		when(service.createUser(new User(5L, "Veena", "Vee@gmail.com"))).thenReturn(new User(5L, "Veena", "Vee@gmail.com"));
		ResponseEntity<User> results = controller.createNewuser(new User(5L, "Veena", "Vee@gmail.com"));
		assertEquals(new User(5L, "Veena", "Vee@gmail.com"), results.getBody());
	}

	/*Testing Update User using Mockito*/



	@Test
	public void testUpdateuser() {
		when(service.updateUser(5L,new User(5L, "Veena", "Vee@gmail.com"))).thenReturn(new User(5L, "Veena", "Vee@gmail.com"));
		ResponseEntity<User> results = controller.updateUser(new User(5L, "Veena", "Vee@gmail.com"),5L);
		assertEquals(new User(5L, "Veena", "Vee@gmail.com"), results.getBody());
	}

	@Test
	public void testDeleteuser() {
		User user=new User(5L, "Veena", "Vee@gmail.com");
		controller.deleteUser(user.getId());
	}




	/*Testing Delete  User using Mockito*/





}






