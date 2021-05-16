package com.kh.project.reservation.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.controller.InOutManager;
import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.model.vo.Account;

public class appMenu {
	Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
	ReservationManager rm = new ReservationManager();
	InOutManager io = new InOutManager();
	Account a = new Account(); // 테스트용이다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	public void Menu() {

		// 로그인 창, 회원가입 창은 여기 위에??

		while (true) { // 나중에 GUI랑 연결 // true값 대신 로그인 조건 받아와야할듯..?

=======
	ReservationManager rm = new ReservationManager(); 		
		
		public void Menu() {
		
		//로그인 창
		
		//회원가입 창 
		
		while(true) { // 나중에 GUI랑 연결 // true값 대신 로그인 조건 받아와야할듯..?
			
>>>>>>> branch 'master' of https://github.com/pastelto/miniProject_cantLose
			System.out.println("******* MENU *******");
			System.out.println("메뉴를 선택해주세요");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
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
				checkInOutM();
				break;

			case 8: // 로그아웃
				return; // 또는 초기화면 이동

			}

		}

	}

	private void checkInOutM() {
		ArrayList ss = io.checkInSave();
		if (ss.get(3) == "") {// 체크인 안한 버전
			while (true) {
				System.out.println(ss.get(0) + " 님"+"\n" + "체크인 또는 체크아웃 또는 이전을 입력하세요");
				String str = sc.nextLine();
				if (str.equals("체크인")) {
					checkIn();
					break;
				} else if (str.equals("체크아웃")) {
					System.out.println("체크인 한 기록이 없습니다. 메인 화면으로 돌아갑니다.  ");
					Menu();
				} else if (str.equals("이전")) {
					Menu();
				}
			}
		} else if (ss.get(3) == "체크인불가") { // 체크아웃 한 후
			System.out.println("체크아웃하여 재입실이 불가합니다." + " \n" + "메인 화면으로 돌아갑니다.");
		} else {// 체크인 한 버전 // 상태 확인
			io.chechkedIn();
			String str = sc.nextLine();
			if (str.equals("체크아웃")) {
				checkOut();
			}
			if (str.equals("이전")) {
				Menu();
			}
		}
		
	}

	private void checkIn() {
		io.checkInSave();

		//io.checkInPrint();
		System.out.println("체크인 하시겠습니까? (Y/N)");
		String str = sc.nextLine();

		if (str.equals("Y") || str.equals("y")) {
			io.checkInPrint();
			System.out.println("체크인 되었습니다.");
		} else if (str.equals("N") || str.equals("n")) {
			System.out.println("메인 메뉴로 돌아갑니다. ");
			Menu();
		}

	}

	private void checkOut() {
		//io.checkOutPrint(); //정보
		System.out.println("체크아웃 시 재입실이 불가합니다." + "체크아웃 하시겠습니까? (Y/N)");
		String str = sc.nextLine();

		if (str.equals("Y") || str.equals("y")) {
			io.checkOutPrint();
			io.timeUsed();
			System.out.println("체크아웃 되었습니다." + "\n" + "고생하셨습니다 :) ");
			io.checkOutAfter();
		} else if (str.equals("N") || str.equals("n")) {
			Menu();
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
