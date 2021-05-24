package com.kh.project.reservation.model.vo;

import java.util.ArrayList;

public class Beverage extends Account{
	
	private int temp=0; // 총금액
	private int discount=0; //할인금액
	private int price = 2000; //가격통일
	private ArrayList cart = new ArrayList();
	
	

	public Beverage() {
		// TODO Auto-generated constructor stub
	}
	

	public Beverage(Account account) {
		// TODO Auto-generated constructor stub
	}
	

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	public ArrayList getCart() {
		return cart;
	}

	public void setCart(ArrayList cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return cart.toString();
	}
	
	

}
