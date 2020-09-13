package com.unay.taskmanager;


import static org.junit.Assert.assertTrue;

import com.unay.taskmanager.model.User;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
	
	@BeforeClass
	public static void setupOnce() {
		System.out.println("Gets called only once, before the tests run.");
	}
	
	@Test
	public void testUserCreation() {
		User user = new User();
		String username = "ABCD";
		String password = "DEFG";
		
		user.setUsername(username);
		user.setPassword(password);
		assertTrue(username == user.getUsername());
		
	}
}
