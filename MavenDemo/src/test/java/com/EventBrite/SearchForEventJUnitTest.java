package com.EventBrite;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SearchForEventJUnitTest {
	static ArrayList<EventDatabaseTest> theEvents;
	static ArrayList<UserDatabaseTest> theUsers;

	@Test
	public void test() {
		LoginPageTest logIn = new LoginPageTest(theUsers);
		theEvents = logIn.InitEventData();
		
		// fail("Not yet implemented");
	}

}
