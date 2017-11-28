package com.EventBrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;

public class AppTest {
	public void Sample() {
		System.out.println("made it here");
		
		//InitEventData();
		//InitUserData();
		
		//LoginPageTest.main(InitUserData());
	}

	public static ArrayList<EventDatabaseTest> InitEventData() {
		ArrayList<EventDatabaseTest> theEvents= new ArrayList<EventDatabaseTest>();
		int asset = 0;
		try {
			File file = new File("Fake Events.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			int x = 0;

			while ((line = bufferedReader.readLine()) != null) {
				if (asset == 0) {
					theEvents.add(new EventDatabaseTest());
					theEvents.get(x).setTitle(line);
					asset = 1;
					continue;
				}
				if (asset == 1) {
					theEvents.get(x).setMonth(line);
					asset = 2;
					continue;
				}
				if (asset == 2) {
					theEvents.get(x).setDay(line);
					asset = 3;
					continue;
				}
				if (asset == 3) {
					theEvents.get(x).setCity(line);
					asset = 4;
					continue;
				}
				if (asset == 4) {
					theEvents.get(x).setState(line);
					asset = 5;
					continue;
				}
				if (asset == 5) {
					theEvents.get(x).setTime(line);
					asset = 0;
					x++;
					continue;
				}
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theEvents;
	}
	public static ArrayList<UserDatabaseTest> InitUserData() {
		ArrayList<UserDatabaseTest> theUsers = new ArrayList<UserDatabaseTest>();
		try {
			
			File file = new File("Fake Users.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			int x = 0;
			int userPassMail = 0;
			boolean isUsername = true;

			while ((line = bufferedReader.readLine()) != null) {
				if (userPassMail == 0) {
					theUsers.add(new UserDatabaseTest());
					theUsers.get(x).setUsername(line);
					userPassMail = 1;
					continue;
				}
				if (userPassMail == 1) {
					theUsers.get(x).setPassword(line);
					userPassMail = 2;
					continue;
				}
				if (userPassMail == 2) {
					theUsers.get(x).setEmail(line);
					userPassMail = 0;
				}

				x++;
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theUsers;
	}
}
