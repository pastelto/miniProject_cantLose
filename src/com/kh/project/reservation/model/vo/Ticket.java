package com.kh.project.reservation.model.vo;

public class Ticket {

	private String oneRW;// 1인 칸막이 (여)
	private String oneRM; // 1인 칸막이 (남)
	private String opSeat; // 오픈형 좌석
	private String stR; // 스터디룸
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(String oneRW, String oneRM, String opSeat, String stR) {
		super();
		this.oneRW = oneRW;
		this.oneRM = oneRM;
		this.opSeat = opSeat;
		this.stR = stR;
	}



	public String getOneRW() {
		return oneRW;
	}

	public void setOneRW(String oneRW) {
		this.oneRW = oneRW;
	}

	public String getOneRM() {
		return oneRM;
	}

	public void setOneRM(String oneRM) {
		this.oneRM = oneRM;
	}

	public String getOpSeat() {
		return opSeat;
	}

	public void setOpSeat(String opSeat) {
		this.opSeat = opSeat;
	}

	public String getStR() {
		return stR;
	}

	public void setStR(String stR) {
		this.stR = stR;
	}

}
