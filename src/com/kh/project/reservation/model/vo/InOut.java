package com.kh.project.reservation.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.kh.project.reservation.model.vo.Account;

public class InOut  {
	//private String checkIn =  new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(System.currentTimeMillis());
	private long checkIn = System.currentTimeMillis() ;
	//private long checkIn ;
	private long checkOut;
	//private long checkOut;
	//private String doubleCheck = ""; // 체크인 상태 
	
	
	public InOut() {
		// TODO Auto-generated constructor stub
	}
	
	public InOut(Account account) {
		// TODO Auto-generated constructor stub
	}
//	public InOut(Account account, InOut inout) {
//		// TODO Auto-generated constructor stub
//		System.out.println("어카운트로 들어옴");
//	}
//	
//
//	public InOut(String id, String pw, String name, String idNum, String pNum, String bank, String pay, int oneSeat,
//			int stdRoom, int printPoint, int totalH, int coupon, String dbCheck ,String checkIn, String checkOut) {
//		super(id, pw, name, idNum, pNum, bank, pay, oneSeat, stdRoom, printPoint, totalH, coupon, dbCheck);
//		this.checkIn =checkIn;
//		this.checkOut = checkOut;
//		// TODO Auto-generated constructor stub
//	}



	public long getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(long checkIn) {
		this.checkIn = checkIn;
	}

	public long getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(long checkOut) {
		this.checkOut = checkOut;
	}

	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString() +"," +checkIn +"," +checkOut;
//	}
//	



	
	

	
	
	
	

}
