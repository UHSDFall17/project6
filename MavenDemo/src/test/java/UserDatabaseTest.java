import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserDatabaseTest {

	public String username, password, email;

	public UserDatabaseTest(String name, String pass, String mail) {
		username = name;
		password = pass;
		email = mail;
	}
	public UserDatabaseTest() {
		username = "";
		password = "";
		email = "";
	}

	public boolean loggingIn(String name, String pass) {
		if (username.equals(name) && password.equals(pass)) {
			return true;
		} else {
			return false;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		password = pass;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public String printUsers() {
		return username + " : " + password;

	}

}