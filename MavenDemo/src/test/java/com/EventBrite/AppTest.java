package com.EventBrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;

public class AppTest {
	public static void main(String[] args) {
		AuthenticationTest warden = new AuthenticationTest();
		LoginPageTest loginPage = new LoginPageTest(warden);
		loginPage.setVisible(true);
	}
}
