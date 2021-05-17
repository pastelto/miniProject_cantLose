package com.kh.project.reservation.view;

import java.util.Scanner;

import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.model.vo.Book;

public class appMenu {
	Scanner sc = new Scanner(System.in);

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
			case 1:
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

	private void buyTicket() {
			while(true) {
			System.out.println("***이용권 구매***");
			System.out.println("1. 1인좌석");
			System.out.println("2. 스터디룸");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1 : 
					break;
			case 2 : 
					break;
			case 3 : mainMenu();
					break;
			}
			
		}
	}
	private void checkMyReservation() {

		System.out.println("***예약 정보 확인***");

		String myR = rm.checkMyReservation();
		if (myR == null) {
			System.out.println("예약정보가 없습니다." + "\n" + "새롭게 예약을 하시겠습니까?" + "\n" + "(수락시 예약화면으로 넘어갑니다.)");
			// 예약화면으로 연결
		} else {
			// 예약정보 가져오기

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
