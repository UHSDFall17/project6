<<<<<<< HEAD:MavenDemo/src/test/java/com/EventBrite/CorporateJUnitTest.java
package com.EventBrite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CorporateJUnitTest {

	@Before
	public void Setup() {
		AuthenticationTest warden = new AuthenticationTest();
		ReadInDataTest librarian = warden.getReader();
		LoginPageTest loginPage = new LoginPageTest(warden);
		UserDatabaseTest loggedUser = librarian.getTheUsers().get(1);
		loggedUser.setCorporate(true);
		EventDatabaseTest theEvent = librarian.getTheEvents().get(1);
		int eventIndex = 1;
	}

	@Test
	public void test() {

	}

}
=======
package com.EventBrite;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorporateJUnitTest {

	/*@Test
	public void test() {
		
	}
	*/

}
>>>>>>> 03e325c369e4b3c00b4a5b81ac4596dddb30ceb3:src/test/java/com/EventBrite/CorporateJUnitTest.java
