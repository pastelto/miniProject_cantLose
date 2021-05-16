package com.kh.project.reservation.model.vo;

public class Beverage {
	private String beverage; // 음료종류
	private int bPrice; // 음료가격
	private int bCoupon; // 음료쿠폰

	public Beverage() {
		// TODO Auto-generated constructor stub
	}

	public String getBeverage() {
		return beverage;
	}

	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public int getbCoupon() {
		return bCoupon;
	}

	public void setbCoupon(int bCoupon) {
		this.bCoupon = bCoupon;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "음료 : " + beverage + ", 가격 : " + bPrice + ", 쿠폰 : " + bCoupon;
	}
	
	




}
