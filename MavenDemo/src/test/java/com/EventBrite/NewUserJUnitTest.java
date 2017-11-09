package com.EventBrite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NewUserJUnitTest {
	static ArrayList<UserDatabaseTest> theUsers;

	@Test
	public void test() {
		LoginPageTest logIn = new LoginPageTest(theUsers);
		theUsers = logIn.InitUserData();
		SignUpTest signUp = new SignUpTest(theUsers, logIn);
		boolean newUser = signUp.IExist("Mazdamundi");
		assertEquals(true, newUser);
		//fail("Not yet implemented");
	}

	
	
	
	
}
