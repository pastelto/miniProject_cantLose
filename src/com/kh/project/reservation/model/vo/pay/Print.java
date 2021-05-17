package com.kh.project.reservation.model.vo.pay;

import com.kh.project.reservation.model.vo.Account;

public class Print extends Account{
	
	private int printPoint; // 프린트 포인트
	private int printCode; // 프린트 코드
	private int colorPrint = 100; // 컬러프린트 비용
	private int blackPrint = 50; // 흑백프린트 비용
	
	public Print() {
		// TODO Auto-generated constructor stub
	}
	
	// 프린트충전 필요한 정보(아이디, 카드, 프린트 포인트)
	public Print(String id, String pay, int printPoint) {
		super(id, pay);
		this.printPoint = printPoint;
	}

	public int getPrintPoint() {
		return printPoint;
	}

	public void setPrintPoint(int printPoint) {
		this.printPoint = printPoint;
	}

	public int getPrintCode() {
		return printCode;
	}

	public void setPrintCode(int printCode) {
		this.printCode = printCode;
	}

	public int getColorPrint() {
		return colorPrint;
	}

	public void setColorPrint(int colorPrint) {
		this.colorPrint = colorPrint;
	}

	public int getBlackPrint() {
		return blackPrint;
	}

	public void setBlackPrint(int blackPrint) {
		this.blackPrint = blackPrint;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info();
	}
	
	
}
