package com.kh.project.reservation.view;

import java.util.Scanner;

import com.kh.project.reservation.controller.ReservationManager;

public class appMenu {
	
	public appMenu() {
		
		ReservationManager rm = new ReservationManager();
		
	
		Scanner sc = new Scanner(System.in);
		
		//로그인 창
		while(true) {
			System.out.println("로그인");
			String id = sc.nextLine();
			
			System.out.println("비밀번호");
			String pw = sc.nextLine();
			
			//if(rm.checkIdNPw() 가 맞는지 체크 맞으면 메뉴 페이지, 아니면 팝업창도록 수정
			break;
		}
		//회원가입 창 
		System.out.println("로그인");
		String id = sc.nextLine();
		
		System.out.println("비밀번호");
		String pw = sc.nextLine();
		
		System.out.println("이름");
		String name = sc.nextLine();
		
		System.out.println("주민번호");
		String idNum = sc.nextLine();
		
		System.out.println("성별");
		char gender = sc.nextLine().charAt(0);
		
		System.out.println("핸드폰 번호");
		String pNum = sc.nextLine();
		
		System.out.println("은행");
		String bank = sc.nextLine();
		
		System.out.println("카드번호");
		String pay = sc.nextLine();
		
		//if()문으로 일치 확인
		
		while(true) { // 나중에 GUI랑 연결 // true값 대신 로그인 조건 받아와야할듯..?
			
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
					rm.checkMyReservation();
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

}
