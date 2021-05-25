package com.kh.project.reservation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.InOut;

public class InOutManager {

	private InOut io = new InOut();
	private Scanner sc = new Scanner(System.in);
	
	public InOutManager() {
		// TODO Auto-generated constructor stub
	}

	public String changecheck(Account account) {

		if (account.getdbCheck() == null) {
			account.setDbCheck("체크인");
		} else if (account.getdbCheck().equals("체크인")) {
			account.setDbCheck("체크아웃");
		} else if (account.getdbCheck().equals("체크아웃")) {
			account.setDbCheck(null);

		}

		return account.getdbCheck();
	}

	// 체크인 시간 정해주는
	public String checkin(Account account) {

		long start = System.currentTimeMillis();

		String checkIn = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(System.currentTimeMillis());

		io.setCheckIn(start);

		return checkIn;
	}

	// 체크아웃 시간 정해주는
	public String checkout(Account account) {
		long end = System.currentTimeMillis();

		String checkout = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(end);

		io.setCheckOut(end);
		
		return checkout;
	}
	
	//이용시간
	public String usetime(Account account) { 

		// 초를 시간으로 분으로
		int ss = (int) Math.round((io.getCheckOut() - io.getCheckIn()) / 1000.0); // 초
		int hour, min, sec = ss;
		min = sec / 60;
		hour = min / 60;
		sec = sec % 60;
		min = min % 60;

		String total = hour + "시 " + min + "분 " + sec + "초";

		account.setTotalH(account.getTotalH() +ss);
		
		

		return total;

	}
}
