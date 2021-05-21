package com.kh.project.reservation.model.vo;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3933614699611495817L;
	private String id;  // 아이디
	private String pw; // 비밀번호
	private String name; // 이름
	private String idNum; // 주민번호
	private String pNum; // 전화번호
	private String bank; // 은행 
	private String pay; // 결제 정보(카드)

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String id, String pw, String name, String idNum, String pNum, String bank, String pay) {

		
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.idNum = idNum;
		this.pNum = pNum;
		this.bank = bank;
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
	public String toString() {
		return  id + "," + pw + "," + name + "," + idNum + "," + pNum + "," + bank + "," + pay ;
	}
}
