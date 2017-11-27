package com.EventBrite;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class LoggingInJUnitTest {

	@Test
	public void test() {
		LoginPageTest loginPage = new LoginPageTest(null);
		loginPage.InitUserData();
		boolean logIn = loginPage.theUsers.get(0).loggingIn("KarlFranz", "PrinceandEmperor");
		assertEquals(true, logIn);
	}
}
