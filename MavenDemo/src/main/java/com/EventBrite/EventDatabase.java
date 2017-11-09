package com.EventBrite;

public class EventDatabase {
	String title, day, month, city, state, buildingNum, street, time;
        
        private int price; // /100 for penny
	
        
        
	public String getTitle() {
		return title;
	}
	public String getTime() {
		return time;
	}
	public String getDay() {
		return day;
	}
	public String getMonth() {
		return month;
	}
	public String getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public String GetBuildingNum() {
		return buildingNum;
	}
	public void setTitle(String line) {
		title = line;
	}
	public void setMonth(String line) {
		month = line;
	}
	public void setDay(String line) {
		day = line;
	}
	public void setCity(String line) {
		city = line;
	}
	public void setTime(String line) {
		time = line;
	}
	public void setState(String line) {
		state = line;
	}
	public void setStreet(String line) {
		street = line;
	}
	public void setBuildingNum(String line) {
		buildingNum = line;
	}
	public void PrintEvents() {
		System.out.println(title);
		System.out.println(day);
		System.out.println(month);
		System.out.println(city);
		System.out.println(state);
		System.out.println(street);
		System.out.println(time);
	}
	public String SearchEvent(String days, String months, String cities, String states) {
		if(days.equals("Day") && months.equals("Month") && cities.equals("City") && states.equals("State")) {
			return("no information given");
		}
		return "0";
	}
        
}
