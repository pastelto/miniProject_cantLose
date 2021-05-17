package com.kh.project.reservation.controller;

import com.kh.project.reservation.model.vo.pay.Ticket;

public class TicketManager {
	
	Ticket t = new Ticket();
	
	public TicketManager() {
		// TODO Auto-generated constructor stub
	}
	
	// 1인석
	public int onePrice(int option, int num1) {
		return t.getOnePrice()*num1; // 1일
	}
	
	public int onePrice(int option) {
		// 종류별 금액 * 기간(기간에 따른 할인율 적용)
		if(option == 2) {
			return (int)Math.round(t.getOnePrice()*30); // 1개월
		}else if (option == 3) {
			return (int)Math.round(t.getOnePrice()*30*6*0.85); // 6개월
		}else{
			return (int)Math.round(t.getOnePrice()*30*12*0.70); // 12개월
		}
	}
	// 스터디룸
	public int strPrice(int num2) {
		return t.getStrPrice()*num2;
	}
	// 회원이 보유한 티켓갯수
	public void addCntTicket(int tNum) {
		t.setTicket(t.getTicket()+tNum); // 자기가 가지고 있던 티켓 + 구매한 수량만큼 더해줘서 넣기
		System.out.println("누적 티켓 : " + t.getTicket()); // 누적갯수 확인
	}

}
