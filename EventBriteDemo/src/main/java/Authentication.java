//package com.EventBrite.EventBriteDemo;

import java.util.ArrayList;

public class Authentication {

	private int corpCodeCorrect = 0;
	private boolean credentialsCorrect = false;
	private boolean goodToGoCorporate = false;
	private boolean goodToGoNormal = false;
	private int foundUserIndex;
	private ArrayList<UserDatabase> theUsers;
	ReadInData Reading;
	UserDatabase loggedInAs;

	public Authentication() {
		Reading = new ReadInData();
		Reading.InitCorpCodes();
		Reading.InitEventData();
		Reading.InitUserData();
		theUsers = Reading.getTheUsers();
	}

	public void Authenticate(String username, String password, boolean checkBox, char[] code) {
		// TODO Auto-generated method stub

		String corpCode = String.valueOf(code);

		for (int i = 0; i < Reading.getTheUsers().size(); i++) {
			//If username and password are good
			if (Reading.getTheUsers().get(i).getUsername().equals(username)
					&& Reading.getTheUsers().get(i).getPassword().equals(password)) {
				credentialsCorrect = true;
				foundUserIndex = i;

				// Did not check the box
				if (!checkBox) {
					corpCodeCorrect = 0;
					break;
				} else if (checkBox) {
					for (int j = 0; j < Reading.getTheCodes().size(); j++) {
						// Checked the box with a valid code
						if (Reading.getTheCodes().get(j).equals(corpCode)) {
							Reading.getTheUsers().get(i).setCorporate(true);
							corpCodeCorrect = 1;
							break;
						}
						// Checked the box with an invalid code
						else if (!Reading.getTheCodes().get(j).equals(corpCode)) {
							corpCodeCorrect = 2;
						}
					}
				}
			}
		}
		if (credentialsCorrect) {
			if (corpCodeCorrect == 0) {
				loggedInAs = Reading.getTheUsers().get(foundUserIndex);
				goodToGoNormal = true;
			}
			if (corpCodeCorrect == 1) {
				loggedInAs = Reading.getTheUsers().get(foundUserIndex);
				goodToGoCorporate = true;
			}
			if (corpCodeCorrect == 2) {
				goodToGoCorporate = false;
			}
		} else {
			credentialsCorrect = false;
		}
	}

	public boolean getCredValidation() {
		return credentialsCorrect;
	}

	public int getCorpValidation() {
		return corpCodeCorrect;
	}

	public int getUserIndex() {
		return foundUserIndex;
	}

	public ReadInData getReader() {
		return Reading;
	}

	public UserDatabase getLoggedUser() {
		return loggedInAs;
	}
	public ArrayList<UserDatabase> getTheUsers() {
		return theUsers;
	}
}
