package com.kh.project.reservation.model.vo;

public class PrintService {
	private int printPoint; // 프린터 포인트
	private int printCode; // 프린터 코드
	private int colorPrint = 100; // 컬러프린트 비용
	private int blackPrint = 50; // 흑백프린트 비용
	
	public PrintService() {
		// TODO Auto-generated constructor stub
	}

	public int getPrintPoint() {
		return printPoint;
	}

	public void setPrintPoint(int printPoint) {
		this.printPoint = printPoint;
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

	public int getPrintCode() {
		return printCode;
	}

	public void setPrintCode(int printCode) {
		this.printCode = printCode;
	}
	
	
	public String printPoint() {
		// TODO Auto-generated method stub
		return "프린터포인트: " + printPoint;
	}

	public String PrintCode() {
		return "프린터 코드: " + printCode;
	}
	
}
