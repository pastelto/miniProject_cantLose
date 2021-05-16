package com.kh.project.reservation.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.controller.InOutManager;
import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Book;


public class appMenu {
	Scanner sc = new Scanner(System.in);


	ReservationManager rm = new ReservationManager();
	InOutManager io = new InOutManager();
	Account a = new Account(); // 테스트용이다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!		
		
		public void mainMenu() { //화면 구현 후 사라질 클래스.. Maybe..
		

		//로그인 창
		
		//회원가입 창 
		

		while(true) { // 나중에 GUI랑 연결 // true값 대신 로그인 조건 받아와야할듯..?
			

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


			switch(num) {
			case 1:
				Book bk = new Book();
				bk.Booking();
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
				System.out.println(ss.get(0) + " 님" + "\n" + "체크인 또는 체크아웃 또는 이전을 입력하세요");
				String str = sc.nextLine();
				if (str.equals("체크인")) {
					io.checkIn(); // 체크인 메소드
					break;
				} else if (str.equals("체크아웃")) {
					System.out.println(ss.get(0) + " 님" + "\n" + "체크인 한 기록이 없습니다. 메인 화면으로 돌아갑니다.  ");
					mainMenu();
				} else if (str.equals("이전")) {
					mainMenu();
				}
			}
		} else if (ss.get(3) == "체크인") {// 체크인 한 버전 // 상태 확인
			io.chechkedIn();
			String str = sc.nextLine();
			if (str.equals("체크아웃")) {
				io.checkOut(); // 체크아웃 메소드
			}else if (str.equals("이전")) {
				mainMenu();
			}
		} else { // 체크아웃 한 후
			System.out.println(ss.get(0) + " 님" + "\n" + "체크아웃하여 재입실이 불가합니다." + " \n" + "메인 화면으로 돌아갑니다.");
		}
	}

	

	private void checkMyReservation() {
		
		System.out.println("***예약 정보 확인***");
		
		String myR = rm.checkMyReservation();
		if(myR == null) {
			System.out.println("예약정보가 없습니다." + "\n" + "새롭게 예약을 하시겠습니까?" + "\n" + "(수락시 예약화면으로 넘어갑니다.)");
			// 예약화면으로 연결
		} else {
			// 예약정보 가져오기
		
			// 예약정보 창 
			
			// 그 밑에 예약변경 메뉴 버튼
		while(true) {
			
			System.out.println("*** 예약 변경 메뉴 ***");
			System.out.println("1. 예약변경");
			System.out.println("2. 예약취소");
			 
			int click = sc.nextInt();
			// 버튼 클릭
			
			switch(click) {
			case 1 : rm.changeReservation();
					// 시간이 지나면 예약변경 X
					break;
			case 2 : rm.cancelReservation();
					// 시간이 지나면 예약취소 X
					break;
			case 3 : mainMenu();
					break;
			}
		}
		
		
		}
}
}
