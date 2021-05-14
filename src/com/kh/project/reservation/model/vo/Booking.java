package com.kh.project.reservation.model.vo;

public class Booking {

	private String[] oneRW; // 1인 칸막이 (여)
	private String[] oneRM; // 1인 칸막이 (남)
	private String[] opSeat; // 오픈형 좌석
	private String[] stR; // 스터디룸
	private int beam; // 빔프로젝터
	private int checkIn; // 체크인 시간
	private int checkOut; // 체크아웃 시간
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(String[] oneRW, String[] oneRM, String[] opSeat, String[] stR, int beam, int checkIn, int checkOut) {
		super();
		this.oneRW = oneRW;
		this.oneRM = oneRM;
		this.opSeat = opSeat;
		this.stR = stR;
		this.beam = beam;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String[] getOneRW() {
		return oneRW;
	}

	public void setOneRW(String[] oneRW) {
		this.oneRW = oneRW;
	}

	public String[] getOneRM() {
		return oneRM;
	}

	public void setOneRM(String[] oneRM) {
		this.oneRM = oneRM;
	}

	public String[] getOpSeat() {
		return opSeat;
	}

	public void setOpSeat(String[] opSeat) {
		this.opSeat = opSeat;
	}

	public String[] getStR() {
		return stR;
	}

	public void setStR(String[] stR) {
		this.stR = stR;
	}

	public int getBeam() {
		return beam;
	}

	public void setBeam(int beam) {
		this.beam = beam;
	}

	public int getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}

	public int getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(int checkOut) {
		this.checkOut = checkOut;
	}

	
	
	
}
