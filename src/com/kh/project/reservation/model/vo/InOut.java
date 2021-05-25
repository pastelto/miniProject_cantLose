package com.kh.project.reservation.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.kh.project.reservation.model.vo.Account;

public class InOut {
	private long checkIn = System.currentTimeMillis();
	private long checkOut;
	

	public InOut() {
	}

	public InOut(Account account) {
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

}
