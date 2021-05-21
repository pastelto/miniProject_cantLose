package com.kh.project.reservation.model.vo;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8415970906280605681L;
	
	private HashMap<String, Account> membership;
	
	
	private String id;  // 아이디
	private String pw; // 비밀번호
	private String name; // 이름
	private String idNum; // 주민번호
	private String pNum; // 전화번호
	private String bank; // 은행 
	private String pay; // 결제 정보(카드)

	private int ticket;
	private int printpoint;
	private int totalH = 0; // 누적시간 -> 초로 넘겨줄것
	private int coupon; // 회원가입시 주는 쿠폰


	
	public Account() {}



	public Account(String id, String pw, String name, String idNum, String pNum, String bank, String pay, int ticket, int printpoint, int totalH , int coupon) {

		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.idNum = idNum;
		this.pNum = pNum;
		this.bank = bank;
		this.pay = pay;
		this.ticket = ticket;
		this.printpoint = printpoint;
		this.totalH = totalH;
		this.coupon = coupon;
	}
	
	
	public Account(String id, String pay) { // 음료구매, 티켓, 프린트에서 상속받아 결제시
		this.id = id;
		this.pay = pay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}
	
	public String getCoupon() {
		return pay;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	
	public HashMap<String, Account> getMembership() {
		return membership;
	}

	public int getTicket() {
		return ticket;
	}


	public void setTicket(int ticket) {
		this.ticket = ticket;
	}


	public int getPrintpoint() {
		return printpoint;
	}


	public void setPrintpoint(int printpoint) {
		this.printpoint = printpoint;
	}
  
  	public int getTotalH() {
		return totalH;
	}
  
  public void setTotalH(int totalH) {
		this.totalH = totalH;
	}

	
	public String toString() {
		return id + "," + pw + "," + name + "," + idNum + "," + pNum + "," + bank + "," + pay + "," + ticket + ","
				+ printpoint + "," + totalH + "," + coupon;
	}

}
