package com.kh.project.reservation.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.controller.InOutManager;
import com.kh.project.reservation.model.vo.Account;

public class InOutMenu {
	Scanner sc = new Scanner(System.in);
	InOutManager io = new InOutManager();
	Account a = new Account();
	
	public void checkInOutM() {
		ArrayList ss = io.checkInSave();
		if (ss.get(3) == "") {// 체크인 안한 버전
			while (true) {
				System.out.println("체크인 또는 체크아웃 또는 이전을 입력하세요");
				String str = sc.nextLine();
				if (str.equals("체크인")) {
					checkIn(); // 체크인 메소드
					ArrayList b = io.checkInSave();//테스트다
					System.out.println(b.get(3));
					break;
				} else if (str.equals("체크아웃")) {
					System.out.println("체크인 한 기록이 없습니다. 메인 화면으로 돌아갑니다.  ");
				} else if (str.equals("이전")) {
					System.out.println("메인메뉴로 돌아갑니다.");
				}
			}
		} else if (ss.get(3) == "체크인") {// 체크인 한 버전 // 상태 확인
			io.chechkedIn();
			String str = sc.nextLine();
			if (str.equals("체크아웃")) {
				checkOut(); // 체크아웃 메소드
			}else if (str.equals("이전")) {
				//mainMenu();
				System.out.println("메인메뉴로 돌아갑니다.");
			}
		} else { // 체크아웃 한 후
			System.out.println("체크아웃하여 재입실이 불가합니다." + " \n" + "메인 화면으로 돌아갑니다.");
		}
	}
	

	public void checkIn() { // 체크인
		io.checkInSave();

		System.out.println("체크인 하시겠습니까? (Y/N)");
		String str = sc.nextLine();

		if (str.equals("Y") || str.equals("y")) {
			io.checkInPrint(); 
			System.out.println("체크인 되었습니다.");
			//망했다 왜 안되지
		} else if (str.equals("N") || str.equals("n")) {
			System.out.println("메인 메뉴로 돌아갑니다. ");
		}

	}
	
	public void checkOut() { // 체크아웃
		System.out.println("체크아웃 시 재입실이 불가합니다." + "체크아웃 하시겠습니까? (Y/N)");
		String str = sc.nextLine();

		if (str.equals("Y") || str.equals("y")) {
			io.checkOutPrint();
			System.out.println("체크아웃 되었습니다." + "\n" + "고생하셨습니다 :) ");
		} else if (str.equals("N") || str.equals("n")) {
			System.out.println("메인 메뉴로 돌아갑니다. ");
		}
	}
}
