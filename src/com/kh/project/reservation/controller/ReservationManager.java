
package com.kh.project.reservation.controller;

import java.util.Scanner;

import com.kh.project.reservation.model.dao.MemberDao;
import com.kh.project.reservation.model.vo.Account;

public class ReservationManager {

	private MemberDao md = new MemberDao();
	private Scanner sc = new Scanner(System.in);
	
public ReservationManager() {
	// TODO Auto-generated constructor stub
}

	public String checkMyReservation() { // 매개변수 : 예약날짜, 예약좌석, 예약성함, 예약상태 등

		// (1) 현재 예약 상황 --> 없으면 return null; / 있으면 현재 예약 정보 보여주기
		
		return null;   // 결과 없으면 null, 있으면 true?
		
	}
	
	public void cancelReservation() {
		// 예약정보 Booking information 
		
		if(bi = null) { // 시간 지난 거
			// booking 메소드로 연결 or
			// 취소버튼 비활성화
		} else {
			// booking 정보 delete --> 확인 --> delete 완료!!
		}
		// (3) 예약정보 O, 취소가능한 정보 O 경우
		// 예약 취소 가능
		// Booking 정보 삭제 .delete??
		
		// 예약 취소 불가능 -> 메세지 or 버튼 효과 X
		
		// 예약 취소 이용권 반환
	}

	public void changeReservation() {
		
		
		// 예약변경 // 날짜 변경 or 좌석 변경
		
		// 예약메소드 가져오기?
	}
}	
	
	
