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
	SignUpTest signUp;
	boolean newUser;

@Before
public void Setup() {
		logIn = new LoginPageTest();
		LoginPageTest.initialize();
		theUsers = LoginPageTest.InitUserData();
		theEvents = LoginPageTest.InitEventData();
		theCodes = logIn.InitCorpCodes();
		signUp = new SignUpTest(theUsers, logIn);
	}
	@Test
	public void userExists() {
		newUser = signUp.IExist("KarlFranz");
		assertEquals(true, newUser);

	}
	@Test
	public void userDoesNotExist() {

		newUser = signUp.IExist("Settra");
		assertEquals(false, newUser);
		
	}
	



}
