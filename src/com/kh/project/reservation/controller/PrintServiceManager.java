package com.kh.project.reservation.controller;

import com.kh.project.reservation.model.vo.pay.Print;

public class PrintServiceManager {
	
	Print p = new Print();

	public void prtPointInfo() {
		System.out.println("프린트포인트: " + p.getPrintPoint());

	}

	public void prtPointCharge(int num2) {
		// 프린트 포인트 충전
		p.setPrintPoint(p.getPrintPoint()+num2);

		
	}
	
	public void prtPointUse() {
		// 프린트 포인트 사용
		
		
	}

	public void prtCode() {
		// 프린트 코드발급
		
	}
}
