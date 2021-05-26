package com.kh.project.reservation.controller;

import javax.swing.JOptionPane;

import com.kh.project.reservation.model.vo.Account;

public class TicketManager {

	private int onePrice = 5000;// 1인실 가격
	private int strPrice = 10000; // 스터디룸 가격
	private int result = 0; // 1인석 일일권 가격 담을 변수

	Account account = new Account();

	public TicketManager() {
		// TODO Auto-generated constructor stub
	}

	public TicketManager(Account account) {
		// TODO Auto-generated constructor stub
	}

	// 1인석 금액계산(종류별 금액 * (수량에 따른 할인율 적용))
	public void oneSeatP(Account account, int oneSeatT) {

		while (true) {
			if (oneSeatT >= 1 && oneSeatT < 30) { // 30 개 미만 할인없음
				result = onePrice * oneSeatT;
				JOptionPane.showMessageDialog(null,
						"이용권 " + oneSeatT + " 장의 가격은 " + "\n" + result + " 원 입니다." + "\n" + "구매 하시겠습니까?");
				myOneSeat(account, oneSeatT);
			} else if (oneSeatT >= 30 && oneSeatT < 90) {
				result = (int) Math.round(onePrice * oneSeatT * 0.70); // 30~90개 미만
				JOptionPane.showMessageDialog(null,
						"이용권 " + oneSeatT + " 장의 가격은 " + "\n" + result + " 원 입니다." + "\n" + "구매 하시겠습니까?");
				myOneSeat(account, oneSeatT);
			} else if (oneSeatT >= 90 && oneSeatT <= 180) {
				result = (int) Math.round(onePrice * oneSeatT * 0.65); // 90~180개 미만
				JOptionPane.showMessageDialog(null,
						"이용권 " + oneSeatT + " 장의 가격은 " + "\n" + result + " 원 입니다." + "\n" + "구매 하시겠습니까?");
				myOneSeat(account, oneSeatT);
			} else if (oneSeatT >= 180) {
				result = (int) Math.round(onePrice * oneSeatT * 0.60); // 180개 이상
				JOptionPane.showMessageDialog(null,
						"이용권 " + oneSeatT + " 장의 가격은 " + "\n" + result + " 원 입니다." + "\n" + "구매 하시겠습니까?");
				myOneSeat(account, oneSeatT);
			}
			break;
		} 

	}

	// 스터디룸 금액계산
	public void strPrice(Account account, int stdRoomT) {
		result = strPrice * stdRoomT;
		JOptionPane.showMessageDialog(null,
				"이용권 " + stdRoomT + " 장의 가격은 " + "\n" + result + " 원 입니다." + "\n" + "구매 하시겠습니까?");
		myStr(account, stdRoomT);
	}

	// 1인석(일일권) 이용권정보 저장 및 정보
	public void myOneSeat(Account account, int oneSeat) {
		account.setOneSeat(account.getOneSeat() + oneSeat); // 자기가 가지고 있던 티켓 + 구매한 수량만큼 더해줘서 넣기
		System.out.println("1일권 수량: " + account.getOneSeat()); // 누적갯수 확인(콘솔용)
	}

	// 스터디룸 이용권 저장 및 정보
	public void myStr(Account account, int stdRoomT) {
		account.setStdRoom(account.getStdRoom() + stdRoomT); // 자기가 가지고 있던 티켓 + 구매한 수량만큼 더해줘서 넣기
		System.out.println("스터디룸 이용권 수량 : " + account.getStdRoom()); // 누적갯수 확인(콘솔용)
		System.out.println(account.toString()); // 누적갯수 확인(콘솔용)

	}
}
