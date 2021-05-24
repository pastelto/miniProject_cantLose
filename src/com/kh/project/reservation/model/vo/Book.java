package com.kh.project.reservation.model.vo;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Book /*implements Serializable*/ {
	
	//private static final long serialVersionUID = -8415970906280605681L;

	//variable
	//private HashMap<String, Book> thisPerson = new HashMap<String, Book>();
	private String yourSeat;
	private String yourDate;
	
	
	//constructor
	
	public Book() {
		
	}
	
	public Book(Account account) {
		
	}

	public String getYourSeat() {
		return yourSeat;
	}

	public void setYourSeat(String yourSeat) {
		this.yourSeat = yourSeat;
	}

	public String getYourDate() {
		return yourDate;
	}

	public void setYourDate(String yourDate) {
		this.yourDate = yourDate;
	}


	/*
	public HashMap<String, Book> getThisPerson() {
		return thisPerson;
	}

	public void setThisPerson(HashMap<String, Book> thisPerson) {
		this.thisPerson = thisPerson;
	}
	*/

}




