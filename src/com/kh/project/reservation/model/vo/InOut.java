package com.kh.project.reservation.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.kh.project.reservation.model.vo.Account;

public class InOut {
	
	private long checkIn = System.currentTimeMillis();
	private long checkOut /*=System.currentTimeMillis()*/;
	private String doubleCheck = ""; // 체크인 상태 
	
	public InOut() {
		// TODO Auto-generated constructor stub
	}
	



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




	public String getDoubleCheck() {
		return doubleCheck;
	}


	public void setDoubleCheck(String doubleCheck) {
		this.doubleCheck = doubleCheck;
	}
	

	
	
	
	

}
