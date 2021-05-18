package com.kh.project.reservation.controller;

import java.util.Random;

import com.kh.project.reservation.model.vo.pay.Print;

public class PrintServiceManager {
	
	Print p = new Print();

	public PrintServiceManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void prtPointInfo() { //포인트조회
		
		System.out.println("프린트포인트: " + p.getPrintPoint());

	}

	public int prtPointCharge(int num2) { // 프린트 포인트 충전
		
		p.setPrintPoint(p.getPrintPoint()+num2);
		System.out.println("충전완료! \n프린트포인트: " + p.getPrintPoint());
		return p.getPrintPoint();
	}
	
	public void prtPointUse(int bkPage, int clPage) { // 프린트 포인트 사용
		if(p.getPrintPoint()>((bkPage*p.getBlackPrint()+clPage*p.getColorPrint()))) 
		{
		p.setPrintPoint(p.getPrintPoint()-(bkPage*p.getBlackPrint()+clPage*p.getColorPrint()));
		}else {
			System.out.println("충전이 필요합니다.");
			
		}
		System.out.println("남은 포인트: "  + p.getPrintPoint());
		
	}

	public void prtCode() { // 프린트 코드발급
		Random random = new Random();
		int rdmInt = random.nextInt(9);
		String pin = "";
		while (pin.length() < 4) {
		    rdmInt = random.nextInt(9);
		    String addition = String.valueOf(rdmInt);
			if (pin.contains(addition))
				continue;
			pin += addition;
		}System.out.println("프린트에 코드 입력: " + pin);
	}
}
