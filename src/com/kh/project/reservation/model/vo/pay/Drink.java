package com.kh.project.reservation.model.vo.pay;

import com.kh.project.reservation.model.vo.Account;

public class Drink extends Account{
	
	private int drink; // 음료 
	
	public Drink() {
		// TODO Auto-generated constructor stub
	}
	
	// 음료 결제시 필요한 정보(아이디, 쿠폰, 음료구매내역) 
	public Drink(String id, int coupon, int drink) {
		super(id, coupon);
		this.drink = drink;
	}
	// 음료 결제시 필요한 정보(아이디, 카드, 음료구매내역) 
	public Drink(String id, String pay, int drink) {
		super(id, pay);
		this.drink = drink;
	}

	public int getDrink() {
		return drink;
	}

	public void setDrink(int drink) {
		this.drink = drink;
	}

	@Override 
	public String info() {
		
		return super.info();
	}
	
	
}
