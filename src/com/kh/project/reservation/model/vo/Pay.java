package com.kh.project.reservation.model.vo;

public class Pay extends Account{

	private int oneDay; // 하루권
	private int month; // 한달권
	private int hYear; // 6개월권
	private int drink; // 음료 
	private int print; // 프린트
	
	public Pay() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Pay(String id, int oneDay, int month, int hYear, int drink, int print) {
		super();
		this.oneDay = oneDay;
		this.month = month;
		this.hYear = hYear;
		this.drink = drink;
		this.print = print;
	}

	public Pay(int oneDay, int month, int hYear, int drink, int print) {
		super();
		this.oneDay = oneDay;
		this.month = month;
		this.hYear = hYear;
		this.drink = drink;
		this.print = print;
	}

	
	
	public int getOneDay() {
		return oneDay;
	}
	public void setOneDay(int oneDay) {
		this.oneDay = oneDay;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int gethYear() {
		return hYear;
	}
	public void sethYear(int hYear) {
		this.hYear = hYear;
	}
	public int getDrink() {
		return drink;
	}
	public void setDrink(int drink) {
		this.drink = drink;
	}
	public int getPrint() {
		return print;
	}
	public void setPrint(int print) {
		this.print = print;
	}
	
	
}