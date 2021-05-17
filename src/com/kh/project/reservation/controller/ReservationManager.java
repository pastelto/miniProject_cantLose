package com.kh.project.reservation.controller;

import java.util.Scanner;

import com.kh.project.reservation.model.dao.MemberDao;
import com.kh.project.reservation.model.vo.Account;

public class ReservationManager {

	private MemberDao md = new MemberDao();
	private Scanner sc = new Scanner(System.in);
	
	public ReservationManager() {
	}
	
	public void addSingIn(Account account) { 
		md.fileSave(account);
	}
	public void checkIdNPw() { // ID 와 패스워드 일치시 if 문
		
	}
	public void checkMyReservation() { // 매개변수 : 예약날짜, 예약좌석, 예약성함, 예약상태 등
		
	}
	
		// (1) 현재 예약 상황 --> 없으면 return null; / 있으면 현재 예약 정보 보여주기
		
		
	}

	
	
	

