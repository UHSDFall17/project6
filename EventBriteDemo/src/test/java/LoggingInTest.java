
//package com.EventBrite.EventBriteDemo.JUnitTestcases;

import static org.junit.Assert.*;

import java.awt.Button;

import org.junit.Before;
import org.junit.Test;

public class LoggingInTest {
	Authentication warden;
	LoginPage login;
	String corpCodeStr;
	App app = new App();

	@Before
	public void Setup() {
		warden = new Authentication();
		login = new LoginPage(warden);
	}
	public char[] codifier(String codeString) {
		char[] corpCodeAr = codeString.toCharArray();
		return corpCodeAr;
	}
	@Test
	public void goodCorporateCredentials() {
		warden.Authenticate("Queek", "Headtaker", true, codifier("13579"));
		int goodCode = warden.getCorpValidation();
		assertEquals(0, goodCode);
	}
	@Test
	public void goodUserCredentials() {
		warden.Authenticate("Queek", "Headtaker", false, codifier(""));
		boolean goodUser = warden.getCredValidation();
		assertEquals(false, goodUser);
	}
	@Test
	public void badCorpCredentials() {
		warden.Authenticate("Queek", "Headtaker", false, codifier("13579"));
		int badCred = warden.getCorpValidation();
		assertEquals(0, badCred);
	}
	@Test
	public void badCorpCode() {
		warden.Authenticate("Queek", "Headtaker", true, codifier("57879"));
		int badCode = warden.getCorpValidation();
		assertEquals(0, badCode);
	}
	@Test
	public void badBadUserCred() {
		warden.Authenticate("Queek", "Headaker", true, codifier("57879"));
		boolean badCred = warden.getCredValidation();
		assertEquals(false, badCred);
	}	
	@Test
	public void loginNormal() {
		login.weAreTesting("Queek", "Headtaker", false, "");
	}
	@Test
	public void loginCorporate() {
		login.weAreTesting("Queek", "Headtaker", true, "13579");
	}
	@Test
	public void failNormal() {
		login.weAreTesting("Queek", "eadtaker", false, "");
	}
	@Test
	public void failCorporate() {
		login.weAreTesting("Queek", "Headtaker", true, "467789");
	}
	@Test 
	public void GoToSignUp() {
		login.testJumptoSignUp();
	}
}
