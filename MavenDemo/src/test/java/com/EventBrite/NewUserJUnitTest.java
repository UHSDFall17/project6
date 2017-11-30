<<<<<<< HEAD
package com.EventBrite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NewUserJUnitTest {
	
	LoginPageTest logIn;
	ArrayList<UserDatabaseTest> theUsers;
	ArrayList<EventDatabaseTest> theEvents;
	ArrayList<String> theCodes;
	SignUpTest signUpPage;
	boolean newUser;

@Before
public void Setup() {
	AuthenticationTest warden = new AuthenticationTest();
	ReadInDataTest librarian = warden.getReader();
	LoginPageTest loginPage = new LoginPageTest(warden);
	signUpPage = new SignUpTest(librarian.getTheUsers(), loginPage);
	UserDatabaseTest loggedUser = librarian.getTheUsers().get(1);
	loggedUser.setCorporate(true);
	EventDatabaseTest theEvent = librarian.getTheEvents().get(1);
	int eventIndex = 1;
	}
	@Test
	public void UserExistsUsername() {
		newUser = signUpPage.IExist("KarlFranz", "theogonist@Empire.gov");
		assertEquals(true, newUser);
	}
	@Test
	public void UserExistsEmail() {
		newUser = signUpPage.IExist("LuthorHuss", "kfaltdorf@Empire.gov");
		assertEquals(true, newUser);
	}
	@Test
	public void UserDoesNotExist() {
		newUser = signUpPage.IExist("Settra", "priestking@nehek.gov");
		assertEquals(false, newUser);
	}



}
=======
package com.EventBrite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NewUserJUnitTest {
	
	LoginPageTest logIn;
	ArrayList<UserDatabaseTest> theUsers;
	ArrayList<EventDatabaseTest> theEvents;
	ArrayList<String> theCodes;
	SignUpTest signUpPage;
	boolean newUser;

@Before
public void Setup() {
	AuthenticationTest warden = new AuthenticationTest();
	ReadInDataTest librarian = warden.getReader();
	LoginPageTest loginPage = new LoginPageTest(warden);
	signUpPage = new SignUpTest(librarian.getTheUsers(), loginPage);
	UserDatabaseTest loggedUser = librarian.getTheUsers().get(1);
	loggedUser.setCorporate(true);
	EventDatabaseTest theEvent = librarian.getTheEvents().get(1);
	int eventIndex = 1;
	}
	@Test
	public void UserExists() {
		newUser = signUpPage.IExist("KarlFranz", "kfaltdorf@Empire.gov");
		assertEquals(true, newUser);
	}
	@Test
	public void UserDoesNotExist() {
		newUser = signUpPage.IExist("Settra", "priestking@nehek.gov");
		assertEquals(false, newUser);
	}



}
>>>>>>> 03e325c369e4b3c00b4a5b81ac4596dddb30ceb3
