//package com.EventBrite.EventBriteDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {
	public static void main(String[] args) {
		Authentication warden = new Authentication();
		LoginPage loginPage = new LoginPage(warden);
		loginPage.setVisible(true);
	}
}
