
package com.kh.project.reservation.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Account implements Serializable {

   private static final long serialVersionUID = -8415970906280605681L;

   private HashMap<String, Account> membership;

   private String id; // 아이디
   private String pw; // 비밀번호
   private String name; // 이름
   private String idNum; // 주민번호
   private String pNum; // 전화번호
   private String bank; // 은행
   private String pay; // 결제 정보(카드)

   private int oneSeat; // 1인석 이용권개수
   private int stdRoom; // 스터디룸 이용권개수
   private int printPoint; // 프린트포인트
   private int totalH = 0; // 누적시간 -> 초로 넘겨줄것
   private int coupon = 1; // 회원가입시 주는 음료쿠폰

   private String dbCheck; // 체크인상태
   private int beverage; // 음료수량

   private String yourDate; // 예약일
   private String yourSeat; // 예약시간

   public Account() {
   }

   public Account(String id, String pw, String name, String idNum, String pNum, String bank, String pay, int oneSeat,
		int stdRoom, int printPoint, int totalH, int coupon, String dbCheck, int beverage, String yourDate,
		String yourSeat) {
	super();
	this.id = id;
	this.pw = pw;
	this.name = name;
	this.idNum = idNum;
	this.pNum = pNum;
	this.bank = bank;
	this.pay = pay;
	this.oneSeat = oneSeat;
	this.stdRoom = stdRoom;
	this.printPoint = printPoint;
	this.totalH = totalH;
	this.coupon = coupon;
	this.dbCheck = dbCheck;
	this.beverage = beverage;
	this.yourDate = yourDate;
	this.yourSeat = yourSeat;
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

   public int getCoupon() {
      return coupon;
   }

   public void setCoupon(int coupon) {
      this.coupon = coupon;
   }

   public HashMap<String, Account> getMembership() {
      return membership;
   }

   public int getOneSeat() {
      return oneSeat;
   }

   public void setOneSeat(int oneSeat) {
      this.oneSeat = oneSeat;
   }

   public int getStdRoom() {
      return stdRoom;
   }

   public void setStdRoom(int stdRoom) {
      this.stdRoom = stdRoom;
   }

   public int getPrintPoint() {
      return printPoint;
   }

   public void setPrintPoint(int printPoint) {
      this.printPoint = printPoint;
   }

   public int getTotalH() {
      return totalH;
   }

   public void setTotalH(int totalH) {
      this.totalH = totalH;
   }

   public String getdbCheck() {
      return dbCheck;
   }

   public void setDbCheck(String dbCheck) {
      this.dbCheck = dbCheck;
   }

   public int getBeverage() {
      return beverage;
   }

   public void setBeverage(int beverage) {
      this.beverage = beverage;
   }

   public String getYourDate() {
      return yourDate;
   }

   public void setYourDate(String yourDate) {
      this.yourDate = yourDate;
   }

   public String getYourSeat() {
      return yourSeat;
   }

   public void setYourSeat(String yourSeat) {
      this.yourSeat = yourSeat;
   }

   public String toString() {
      return id + "," + pw + "," + name + "," + idNum + "," + pNum + "," + bank + "," + pay + "," + oneSeat + ","
            + stdRoom + "," + printPoint + "," + totalH + "," + coupon + "," + dbCheck + "," + beverage + "," + yourDate + "," + yourSeat;
   }

}