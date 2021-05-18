package com.kh.project.reservation.model.vo;

public class Account {

	private String id="ㅇ";  // 아이디
	private String pw="ㅇ"; // 비밀번호
	private String name="조아혜"; // 이름
	private String idNum; // 주민번호
	private char gender; // 성별
	private String pNum; // 전화번호
	private String bank; // 은행 
	private String pay; // 결제 정보(카드)
	private int ticket;
	private int bevticket;
	private int printpoint;
	private int totalH = 0; // 누적시간 -> 초로 넘겨줄것
	private int coupon; // 회원가입시 주는 쿠폰

	
	public Account() {}


	public Account(String id, String pw, String name, String idNum, char gender, String pNum, String bank, String pay, int ticket, int bevticket, int printpoint, int totalH) {


		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.idNum = idNum;
		this.gender = gender;
		this.pNum = pNum;
		this.bank = bank;
		this.pay = pay;

		this.ticket = ticket;
		this.bevticket = bevticket;
		this.printpoint = printpoint;
		this.totalH = totalH;
		this.coupon = coupon;
	}
	
	
	public Account(String id, int coupon) { // 음료쿠폰으로 결제시
		this.id = id;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	
	
	public int getTotalH() {
		return totalH;
	}


	public void setTotalH(int totalH) {
		this.totalH = totalH;
	}


	
	public String info() {
		return "아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 주민번호 : " + idNum + ", 성별 : " + gender + ", 전화번호 : "
				+ pNum + ", 은행 : " + bank + ", 카드번호 : " + pay +", 쿠폰 : "+coupon;
	}


}
