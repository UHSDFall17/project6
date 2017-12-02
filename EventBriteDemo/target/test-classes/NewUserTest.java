

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
//import com.EventBrite.EventBriteDemo.Authentication;
//import com.EventBrite.EventBriteDemo.EventDatabase;
//import com.EventBrite.EventBriteDemo.LoginPage;
//import com.EventBrite.EventBriteDemo.ReadInData;
//import com.EventBrite.EventBriteDemo.SignUp;
//import com.EventBrite.EventBriteDemo.UserDatabase;

public class NewUserTest {

	LoginPage logIn;
	ArrayList<UserDatabase> theUsers;
	ArrayList<EventDatabase> theEvents;
	ArrayList<String> theCodes;
	SignUp signUp;
	boolean newUser;
	ReadInData librarian;

	@Before
	public void Setup() {
		librarian = new ReadInData();
		librarian.InitCorpCodes();
		librarian.InitUserData();
		librarian.InitEventData();

		Authentication warden = new Authentication();
		
		logIn = new LoginPage(warden);
		signUp = new SignUp(librarian.getTheUsers(), logIn);
	}
	@Test
	public void UserExistsUsername() {
		newUser = signUp.IExist("KarlFranz", "theogonist@empire.emp");
		assertEquals(true, newUser);
	}
	@Test
	public void UserExistsEmail() {
		newUser = signUp.IExist("LuthorHuss", "kfaltdorf@empire.emp");
		assertEquals(true, newUser);
	}
	@Test
	public void UserDoesNotExist() {
		newUser = signUp.IExist("Settra", "priestking@nehek.gov");
		assertEquals(false, newUser);
	}
	
	@Test
	public void testWriteToList() {
		signUp.WeAreTesting("Settra", "Imperishable", "priestking@khemri.tmb");
		System.out.println("IMPORTANT: Remember to delete Settra's data in the 'Fake Users.txt' file after each test.");
	}
	

}
