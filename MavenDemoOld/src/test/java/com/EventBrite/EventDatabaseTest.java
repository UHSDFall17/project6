package com.EventBrite;

public class EventDatabaseTest {
	
	String title, day, month, city, state, address, time;
	
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
	public String getAddress() {
		return address;
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
	public void PrintEvents() {
		System.out.println(title);
		System.out.println(day);
		System.out.println(month);
		System.out.println(city);
		System.out.println(state);
		System.out.println(address);
		System.out.println(time);
	}
	public int SearchEvent(String days, String months, String cities, String states) {
		if((day.equals(days) && months.equals(null))) {
			
		}
		return 0;
	}
}
