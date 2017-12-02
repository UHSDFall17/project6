//package com.EventBrite.EventBriteDemo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {
	ReadInData librarian = new ReadInData();
	Transaction transaction;

	@Before
	
	public void Setup() {
		librarian.InitEventData();
		librarian.InitUserData();
		transaction = new Transaction(librarian.getTheEvents().get(1), librarian.getTheUsers().get(1));
	}

	@Test
	public void BuyNormalUnder() {
		librarian.getTheUsers().get(1).setCorporate(false);
		transaction.WeAreTesting("Billy", "123 Westheimer Rd.", "1234567890123456", "385", "5");
	}
	@Test
	public void BuyNormalOver() {
		librarian.getTheUsers().get(1).setCorporate(false);
		transaction.WeAreTesting("Billy", "123 Westheimer Rd.", "1234567890123456", "385", "10");
	}
	@Test
	public void BuyCorporateOver() {
		librarian.getTheUsers().get(1).setCorporate(true);
		transaction.WeAreTesting("Billy", "123 Westheimer Rd.", "1234567890123456", "385", "20");
	}
	@Test
	public void BuyCorporateUnder() {
		librarian.getTheUsers().get(1).setCorporate(true);
		transaction.WeAreTesting("Billy", "123 Westheimer Rd.", "1234567890123456", "385", "50");
	}
	@Test
	public void BuyNoInfo() {
		transaction.WeAreTesting("", "123 Westheimer Rd.", "1234567890123456", "385", "50");
	}

}
