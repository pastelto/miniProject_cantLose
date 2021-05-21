package com.kh.project.reservation.model.vo.pay;

import com.kh.project.reservation.model.vo.Account;

public class Ticket extends Account{

	private int ticket; // 이용권
	private int onePrice = 5000;// 1인실 가격
	private int strPrice = 10000; // 스터디룸 가격
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(String id, String pay, int ticket) {
		super(id, pay);
		this.ticket = ticket;
	}
	
	public int getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(int onePrice) {
		this.onePrice = onePrice;
	}

	public int getStrPrice() {
		return strPrice;
	}

	public void setStrPrice(int strPrice) {
		this.strPrice = strPrice;
	}

	
	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	
	
}
