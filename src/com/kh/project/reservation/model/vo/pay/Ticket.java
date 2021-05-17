package com.kh.project.reservation.model.vo.pay;

import com.kh.project.reservation.model.vo.Account;

public class Ticket extends Account{

	private int ticket; // 이용권
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(String id, String pay, int ticket) {
		super(id, pay);
		this.ticket = ticket;
	}
	
	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	
	
}
