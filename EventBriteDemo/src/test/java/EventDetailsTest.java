//package com.EventBrite.EventBriteDemo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EventDetailsTest {
	
	ReadInData librarian = new ReadInData();
	EventDetailsPage eventDetails;
	
	@Before
	public void Setup() {
		librarian.InitEventData();
		librarian.InitUserData();
		librarian.getTheUsers().get(2).setCorporate(true);
		eventDetails = new EventDetailsPage(librarian, 1, librarian.getTheUsers().get(2));
	}
	@Test
	public void GoToTransaction() {
		eventDetails.TestGoToTransaction();
	}

}
