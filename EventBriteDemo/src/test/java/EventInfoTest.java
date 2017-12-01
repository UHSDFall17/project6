//package com.EventBrite.EventBriteDemo.JUnitTestcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EventInfoTest {
	ReadInData librarian;
	@Before
	public void Setup() {
		librarian = new ReadInData();
		librarian.InitEventData();
	}
	
	@Test
	public void getTitle() {
		assertEquals("Hound Town",librarian.getTheEvents().get(1).getTitle());
	}
	@Test
	public void getDay() {
		assertEquals("13",librarian.getTheEvents().get(1).getDay());
	}
	@Test
	public void getMonth() {
		assertEquals("9",librarian.getTheEvents().get(1).getMonth());
	}
	@Test
	public void getState() {
		assertEquals("TX",librarian.getTheEvents().get(1).getState());
	}
	@Test
	public void getBuildingNum() {
		assertEquals("96942",librarian.getTheEvents().get(1).getBuildingNum());
	}
	@Test
	public void getStreet() {
		assertEquals("Scott St.",librarian.getTheEvents().get(1).getStreet());
	}
	@Test
	public void getTime() {
		assertEquals("9:00",librarian.getTheEvents().get(1).getTime());
	}
	@Test
	public void getPrice() {
		assertEquals("10.50",librarian.getTheEvents().get(1).getTicketPrice());
	}
	@Test
	public void getCity() {
		assertEquals("Houston",librarian.getTheEvents().get(1).getCity());
	}

}
