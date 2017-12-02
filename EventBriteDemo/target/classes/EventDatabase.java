//package com.EventBrite.EventBriteDemo;

public class EventDatabase {
	
	String title, day, month, city, state, buildingNum, street, time, ticketPrice;
	
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
	public String getTicketPrice() {
		return ticketPrice;
	}
	public String getState() {
		return state;
	}
	public String getBuildingNum() {
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
	public void setTicketPrice(String line) {
		ticketPrice = line;
	}
}
