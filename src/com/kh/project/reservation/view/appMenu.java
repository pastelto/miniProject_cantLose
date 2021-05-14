package com.kh.project.reservation.view;

import java.util.Scanner;

import com.kh.project.reservation.controller.ReservationManager;

public class appMenu {
	Scanner sc = new Scanner(System.in);
	ReservationManager rm = new ReservationManager(); 		
		
		public void Menu() {
		
		// 로그인 창, 회원가입 창은 여기 위에?? 
		
		while(true) { // 나중에 GUI랑 연결 // true값 대신 로그인 조건 받아와야할듯..?
			
			System.out.println("******* MENU *******");
			System.out.println("메뉴를 선택해주세요");
			int num = sc.nextInt();
			sc.nextLine();

			
			switch(num) {
			case 1: // 예약 
					break;
			case 2: // 이용권 구매
					break;
			case 3: // 음료 구매
					break;
			case 4: // 프린트 서비스
					break;
			case 5: // 예약정보 확인
					checkMyReservation();
					// (2) 현재 예약 정보 없으면 null -> 예약하기 case 2로 연결
					break;
			case 6: // 내정보
					break;
			case 7: // 체크인 / 체크아웃
					break;
			case 8: // 로그아웃
					return; // 또는 초기화면 이동
				
			}
			
			
			
		}
		
		
	}

	private void checkMyReservation() {
		
		System.out.println("***예약 정보 확인***");
		
		String myR = rm.checkMyReservation();
		if(myR == null) {
			System.out.println("예약정보가 없습니다." + "\n" + "새롭게 예약을 하시겠습니까?" + "\n" + "(수락시 예약화면으로 넘어갑니다.");
			// 예약화면으로 연결
		} else {
			// 예약정보 가져오기
		
	}
		
		while(true) {
			
			System.out.println("*** 예약 변경 메뉴 ***");
			System.out.println("1. 예약변경");
			System.out.println("2. 예약취소");
			 
			int click = sc.nextInt();
			// 버튼 클릭
			
			switch(click) {
			case 1 : rm.changeReservation();
					break;
			case 2 : rm.cancelReservation();
					break;
			case 3 : Menu();
					break;
			}
		}
}
}
