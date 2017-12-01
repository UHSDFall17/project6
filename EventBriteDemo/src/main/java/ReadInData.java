//package com.EventBrite.EventBriteDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInData {
	int numOfEvents = 0;
	int numOfUsers = 0;
	private ArrayList<EventDatabase> theEvents;
	private ArrayList<UserDatabase> theUsers;
	private ArrayList<String> corpCodes;

	public ArrayList<UserDatabase> InitUserData() {
		
		theUsers = new ArrayList<UserDatabase>();
		try {
			File file = new File("Fake Users.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			int userPassMail = 0;
			boolean isUsername = true;

			while ((line = bufferedReader.readLine()) != null) {

				if (userPassMail == 0) {
					theUsers.add(new UserDatabase());
					theUsers.get(numOfUsers).setUsername(line);
					userPassMail = 1;
					continue;
				}
				if (userPassMail == 1) {
					theUsers.get(numOfUsers).setPassword(line);
					userPassMail = 2;
					continue;
				}
				if (userPassMail == 2) {
					theUsers.get(numOfUsers).setEmail(line);
					userPassMail = 0;
				}

				numOfUsers++;
				//System.out.println(theUsers.size());
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theUsers;
	}

	public ArrayList<EventDatabase> InitEventData() {
		theEvents = new ArrayList<EventDatabase>();
		int asset = 0;
		try {
			File file = new File("Fake Events.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			// int x = 0;

			while ((line = bufferedReader.readLine()) != null) {
				
				if (asset == 0) {
					theEvents.add(new EventDatabase());
					theEvents.get(numOfEvents).setTitle(line);
					asset = 1;
					continue;
				}
				if (asset == 1) {
					theEvents.get(numOfEvents).setDay(line);
					asset = 2;
					continue;
				}
				if (asset == 2) {
					theEvents.get(numOfEvents).setMonth(line);
					asset = 3;
					continue;
				}

				if (asset == 3) {
					theEvents.get(numOfEvents).setCity(line);
					asset = 4;
					continue;
				}
				if (asset == 4) {
					theEvents.get(numOfEvents).setState(line);
					asset = 5;
					continue;
				}
				if (asset == 5) {
					theEvents.get(numOfEvents).setBuildingNum(line);
					asset = 6;
					continue;
				}
				if (asset == 6) {
					theEvents.get(numOfEvents).setStreet(line);
					asset = 7;
					continue;
				}
				if (asset == 7) {
					theEvents.get(numOfEvents).setTime(line);
					asset = 8;
					continue;
				}
				if (asset == 8) {
					theEvents.get(numOfEvents).setTicketPrice(line);
					asset = 0;
					numOfEvents++;
					//System.out.println(theEvents.size());
					continue;
				}
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theEvents;
	}

	public ArrayList InitCorpCodes() {
		corpCodes = new ArrayList<String>();
		try {
			File file = new File("Corporate Codes.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			// int x = 0;

			while ((line = bufferedReader.readLine()) != null) {
				
				corpCodes.add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return corpCodes;
	}

	public ArrayList<UserDatabase> getTheUsers() {
		return theUsers;
	}

	public ArrayList<EventDatabase> getTheEvents() {
		return theEvents;
	}

	public ArrayList<String> getTheCodes() {
		return corpCodes;
	}
}
