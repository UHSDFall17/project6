package com.EventBrite;

public class UserDatabaseTest {

    private String username, password, email;
    //boolean isCorporate = false;
    private int userType = UserType.MEMBER;
    boolean loggedIn = false;

    public UserDatabaseTest(String username, String password, String email, int userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public UserDatabaseTest() {
        username = "";
        password = "";
        email = "";
        userType = UserType.MEMBER;
    }

    public boolean loggingIn(String name, String pass) {
        if (username.equals(name) && password.equals(pass)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean newUser(String name, String email, String pass) {
        if (name.equals("Username") || email.equals("Email") || pass.equals("Password")) {
            return false;
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public void setLoggedIn(boolean x) {
        if (x == true) {
            loggedIn = true;

        } else if (x == false) {
            loggedIn = false;
        }
    }

    public boolean loggedIn() {

        return loggedIn;

    }

    public String toString() {
        // System.out.println("Printing users");
        return username + " : " + password;

    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }

    public String getUserTypeName() {
        return UserType.Name(userType);
    }
}
