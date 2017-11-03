package com.EventBrite;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchForEventTest {

	@Test
	public void test() {
		EventPageTest eventPage = new EventPageTest();
		eventPage.InitTestData();
		String search = EventPageTest.theEvents.get(0).SearchEvent("Day", "Month", "City", "State");
		assertEquals("no information given", search);
	}

}
