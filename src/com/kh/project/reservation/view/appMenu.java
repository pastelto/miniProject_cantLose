package com.kh.project.reservation.view;

import java.util.Scanner;

import com.kh.project.reservation.controller.BeverageManager;
import com.kh.project.reservation.controller.ReservationManager;

import com.kh.project.reservation.controller.TicketManager;

import com.kh.project.reservation.model.vo.Book;


public class appMenu {
	Scanner sc = new Scanner(System.in);

	ReservationManager rm = new ReservationManager();
	TicketManager tm = new TicketManager();

	public void Menu() {


	ReservationManager rm = new ReservationManager();

	public void mainMenu() { // 화면 구현 후 사라질 클래스.. Maybe..


		// 로그인 창

		// 회원가입 창

		while (true) { // 나중에 GUI랑 연결 // true값 대신 로그인 조건 받아와야할듯..?

			System.out.println("******* MENU *******");
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 예약");
			System.out.println("2. 이용권 구매");
			System.out.println("3. 음료 구매");
			System.out.println("4. 프린트 서비스");
			System.out.println("5. 예약정보 확인");
			System.out.println("6. 내정보");
			System.out.println("7. 체크인 / 체크아웃");
			System.out.println("8. 로그아웃");

			System.out.print("메뉴를 선택해주세요 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {

			case 1: // 예약
			Book bk = new Book();
				bk.Booking();

				break;
			case 2: // 이용권 구매
				buyTicket();
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
				new InOutMenu().checkInOutM();
				break;
			case 8: // 로그아웃
				return; // 또는 초기화면 이동

			}

		}


	}

	private void orderBeverage() {
		BeverageManager bm = new BeverageManager();
		//		while(true) {
//			System.out.println("***움료 메뉴***");
//			System.out.println("1. 아메리카노");
//			System.out.println("2. 아이스아메리카노");
//			System.out.println("3. 카페라떼");
//			System.out.println("4. 아이스카페라떼");
//			System.out.println("5. 핫초코");
//			System.out.println("6. 아이스초코");
//			System.out.println("7. 딸기우유");
//			System.out.println("8. 레몬에이드");
//			System.out.println("9. 허브티");
//			System.out.println("음료선택 : ");
//			int num1 = sc.nextInt();
//			sc.nextLine();
//			System.out.println("수량: ");
//			int num2 = sc.nextInt();
//			sc.nextLine();
//			
//			System.out.println("추가하시겠습니까?");
//			char ch = sc.nextLine().toUpperCase().charAt(0);
//				if(ch =='Y') {
//					return;
//				}else {
//					break;
//				}
//		}
		


	}

	private void buyTicket() {
		while (true) {
			System.out.println("***이용권 구매***");
			System.out.println("1. 1인좌석");
			System.out.println("2. 스터디룸");
			int num = sc.nextInt();
			sc.nextLine();
			int num1 = 0;
			
			switch (num) {
			case 1: // 기간에 따른 할인률 적용하여 반환
				System.out.println("***기간 선택***");
				System.out.println("1. 1 일권 ");
				System.out.println("2. 1 개월권 ");
				System.out.println("3. 6 개월권 ");
				System.out.println("4. 1 년권 ");
				int option = sc.nextInt();
				sc.nextLine();
				
				if(option == 1) {
				System.out.println("수량 : ");
				num1 = sc.nextInt();
				tm.onePrice(option, num1);
				tm.addCntTicket(num1);
				System.out.println("총 금액은 " + tm.onePrice(option,num1) +" 입니다.");
				break;
				} else {
				tm.onePrice(option);
				System.out.println("총 금액은 " + tm.onePrice(option) +" 입니다.");
				break;
				}
				
			case 2:
				System.out.println("수량 : ");
				int num2 = sc.nextInt();
				sc.nextLine();
				System.out.println("총 금액은 " + tm.strPrice(num2)+ "입니다.");
				break;
			case 3:
				Menu();
				break;
			default : System.out.println("다시입력해주세요.");
			    break;

			switch(num) {
			case 1 : 
					break;
			case 2 : 
					break;
			case 3 : mainMenu();
					break;

			}
			Menu();
		}
	}

	private void checkMyReservation() {

		System.out.println("***예약 정보 확인***");

		String myR = rm.checkMyReservation();
		if (myR == null) {

			System.out.println("예약정보가 없습니다." + "\n" + "새롭게 예약을 하시겠습니까?" + "\n" + "(수락시 예약화면으로 넘어갑니다.");

			System.out.println("예약정보가 없습니다." + "\n" + "새롭게 예약을 하시겠습니까?" + "\n" + "(수락시 예약화면으로 넘어갑니다.)");

			// 예약화면으로 연결
		} else {
			// 예약정보 가져오기


		}

		while (true) {

			System.out.println("*** 예약 변경 메뉴 ***");
			System.out.println("1. 예약변경");
			System.out.println("2. 예약취소");

			int click = sc.nextInt();
			// 버튼 클릭

			switch (click) {
			case 1:
				rm.changeReservation();
				break;
			case 2:
				rm.cancelReservation();
				break;
			case 3:
				Menu();
				break;

			// 예약정보 창

			// 그 밑에 예약변경 메뉴 버튼
			while (true) {

				System.out.println("*** 예약 변경 메뉴 ***");
				System.out.println("1. 예약변경");
				System.out.println("2. 예약취소");

				int click = sc.nextInt();
				// 버튼 클릭

				switch (click) {
				case 1:
					rm.changeReservation();
					// 시간이 지나면 예약변경 X
					break;
				case 2:
					rm.cancelReservation();
					// 시간이 지나면 예약취소 X
					break;
				case 3:
					mainMenu();
					break;
				}

			}

		}
	}
}
