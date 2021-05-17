package com.kh.project.reservation.controller;

import com.kh.project.reservation.model.vo.TicketPrice;

public class TicketManager {
	
	TicketPrice tp = new TicketPrice();
	
	
	public TicketManager() {
		// TODO Auto-generated constructor stub
	}
	// 종류별 금액 * 기간(기간에 따른 할인율 적용)
	public int onePrice(int option, int num1) {
		return tp.getonePrice()*num1; // 1일
	}
	
	public int onePrice(int option) {
	
		if(option == 2) {
			return (int)Math.round(tp.getonePrice()*30); // 1개월
		}else if (option == 3) {
			return (int)Math.round(tp.getonePrice()*30*6*0.85); // 6개월
		}else{
			return (int)Math.round(tp.getonePrice()*30*12*0.70); // 12개월
		}
	}
	
	public int strPrice(int num2) {
		return tp.getstrPrice()*num2;
	}

	public void addCntTicket(int num1) {
		//회원정보.ticket+num1; // 구매갯수만큼 회원 티켓 추가하여 회원정보에 넘겨줘야 할것 같은데
	}

}
