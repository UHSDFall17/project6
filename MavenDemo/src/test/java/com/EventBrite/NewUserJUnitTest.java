package com.EventBrite;

import static org.junit.Assert.*;

import org.junit.Test;

public class NewUserJUnitTest {

	@Test
	public void test() {
		SignUpTest signUp = new SignUpTest();
		signUp.InitTestData();
		boolean helpMe = signUp.IExist("KarlFranz");
		fail("Not yet implemented");
	}

}
