package com.kh.project.reservation.controller;

import com.kh.project.reservation.model.vo.Account;

public class TicketManager {

//	private int oneSeat; // 1인석이용권 갯수
//	private int stdRoom; // 스터디룸이용권 갯수
	private int onePrice = 5000;// 1인실 가격
	private int strPrice = 10000; // 스터디룸 가격
	private int result = 0; // 가격담을 변수

	Account account = new Account();

	public TicketManager() {
		// TODO Auto-generated constructor stub
	}

	// 1인석 금액계산(일일권)
	public void oneSeat(int option, int oneSeat) {
		result = onePrice * oneSeat; // 1일
		System.out.println("이용권 가격: " + result);
	}

	// 1인석 금액계산(종류별 금액 * 기간(기간에 따른 할인율 적용))
	public void oneSeat(int option) {

		while (true) {
			switch (option) {
			case 2:
				result = (int) Math.round(onePrice * 30); // 1개월
				break;
			case 3:
				result = (int) Math.round(onePrice * 30 * 6 * 0.85); // 6개월 * 할인율
				break;
			case 4:
				result = (int) Math.round(onePrice * 30 * 12 * 0.70); // 12개월 * 할인율
				break;

			}
			System.out.println("이용권 가격: " + result);
		}

	}

	// 스터디룸 금액계산
	public void strPrice(int stdRoom) {
		result = strPrice * stdRoom;
		System.out.println("이용권 가격: " + result);
	}

	// 1인석 구매
	public void oneBuy() {
		
	}

	// 스터디룸 구매
	public void strBuy() {

	}

	// 1인석 이용권정보 저장 및 정보
	public void myOneSeat(int oneSeat) {
		account.setOneSeat(account.getOneSeat() + oneSeat); // 자기가 가지고 있던 티켓 + 구매한 수량만큼 더해줘서 넣기
		System.out.println("누적 티켓 : " + account.getOneSeat()); // 누적갯수 확인
	}

	// 스터디룸 이용권 저장 및 정보
	public void myStr(int stdRoom) {
		account.setStdRoom(account.getStdRoom() + stdRoom); // 자기가 가지고 있던 티켓 + 구매한 수량만큼 더해줘서 넣기
		System.out.println("누적 티켓 : " + account.getStdRoom()); // 누적갯수 확인
	}
}
