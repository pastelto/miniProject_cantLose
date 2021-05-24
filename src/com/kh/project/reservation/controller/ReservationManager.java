package com.kh.project.reservation.controller;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Book;
//import com.kh.project.reservation.model.vo.pay.Ticket;

public class ReservationManager {

	private String taken;
	
	private String[] seatsFF = { "1인 칸막이 좌석 (여성전용) a,a","1인 칸막이 좌석 (여성전용) a,b","1인 칸막이 좌석 (여성전용) a,c","1인 칸막이 좌석 (여성전용) a,d","1인 칸막이 좌석 (여성전용) a,e","1인 칸막이 좌석 (여성전용) a,f","1인 칸막이 좌석 (여성전용) a,g",
			"1인 칸막이 좌석 (여성전용) a,h","1인 칸막이 좌석 (여성전용) a,i","1인 칸막이 좌석 (여성전용) a,j","1인 칸막이 좌석 (여성전용) a,k","1인 칸막이 좌석 (여성전용) a,l","1인 칸막이 좌석 (여성전용) a,m","1인 칸막이 좌석 (여성전용) a,n","1인 칸막이 좌석 (여성전용) a,o"
			};

	private String[] seatsFM = { "1인 칸막이 좌석 (남성전용) b,a","1인 칸막이 좌석 (남성전용) b,b","1인 칸막이 좌석 (남성전용) b,c","1인 칸막이 좌석 (남성전용) b,d","1인 칸막이 좌석 (남성전용) b,e","1인 칸막이 좌석 (남성전용) b,f","1인 칸막이 좌석 (남성전용) b,g",
			"1인 칸막이 좌석 (남성전용) b,h","1인 칸막이 좌석 (남성전용) b,i","1인 칸막이 좌석 (남성전용) b,j","1인 칸막이 좌석 (남성전용) b,k","1인 칸막이 좌석 (남성전용) b,l","1인 칸막이 좌석 (남성전용) b,m","1인 칸막이 좌석 (남성전용) b,n","1인 칸막이 좌석 (남성전용) b,o"
			};
	
	private String[] seatsFO = { "1인 오픈형 좌석 c,a","1인 오픈형 좌석 c,b","1인 오픈형 좌석 c,c","1인 오픈형 좌석 c,d","1인 오픈형 좌석 c,e","1인 오픈형 좌석 c,f","1인 오픈형 좌석 c,g",
			"1인 오픈형 좌석 c,h","1인 오픈형 좌석 c,i","1인 오픈형 좌석 c,j","1인 오픈형 좌석 c,k","1인 오픈형 좌석 c,l","1인 오픈형 좌석 c,m","1인 오픈형 좌석 c,n","1인 오픈형 좌석 c,o"
			};

	private String[] rooms = { "스터디룸 A (최대 4인)","스터디룸 B (최대 4인)","스터디룸 C (최대 4인)","스터디룸 D (최대 4인)"
	};
	
	public String[] getSeatsFF() {
		return seatsFF;
	}
	public void setSeatsFF(String[] seatsFF) {
		this.seatsFF = seatsFF;
	}
	public String[] getSeatsFM() {
		return seatsFM;
	}
	public void setSeatsFM(String[] seatsFM) {
		this.seatsFM = seatsFM;
	}
	public String[] getSeatsFO() {
		return seatsFO;
	}
	public void setSeatsFO(String[] seatsFO) {
		this.seatsFO = seatsFO;
	}
	public String[] getRooms() {
		return rooms;
	}
	public void setRooms(String[] rooms) {
		this.rooms = rooms;
	}
	//생성자
	public ReservationManager() {
		
	}
	public ReservationManager(Account account) {

	}
	
	/* //티켓여부 확인
	public Boolean ynTicket() {
		if(ticket().getTicket().contains 1일권) {
		 n개월
			return true;
		}else {
			return false;

		}
		
	}
 */
	//예약된 좌석 정리
	public void taken(Account account) {
		
		 Book bk = new Book(account);
		 
		for(int i = 0 ; i < seatsFF.length ; i++) {
			if(bk.getYourSeat().equals(seatsFF[i])) {
				seatsFF[i] = "예약된 좌석입니다.";
			}
		}
		for(int i = 0 ; i < seatsFM.length ; i++) {
			if(bk.getYourSeat().equals(seatsFM[i])) {
				seatsFM[i] = "예약된 좌석입니다.";
			}
		}
		for(int i = 0 ; i < seatsFO.length ; i++) {
			if(bk.getYourSeat().equals(seatsFO[i])) {
				seatsFO[i] = "예약된 좌석입니다.";
			}
		}
		for(int i = 0 ; i < rooms.length; i++) {
			if(bk.getYourSeat().equals(rooms[i])) {
				rooms[i] = "예약된 좌석입니다.";
			}
		}
	
	}
}	
	
	

