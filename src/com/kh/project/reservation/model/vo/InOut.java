package com.kh.project.reservation.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.kh.project.reservation.model.vo.Account;

public class InOut {
	private String checkIn =  new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(System.currentTimeMillis());
	//private long checkIn = System.currentTimeMillis() ;
	//private String checkIn;
	private String checkOut;
	//private long checkOut;
	//private String doubleCheck = ""; // 체크인 상태 
	
	public InOut() {
		// TODO Auto-generated constructor stub
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	



	
	

	
	
	
	

}
