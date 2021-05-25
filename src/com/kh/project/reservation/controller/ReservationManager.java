package com.kh.project.reservation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.kh.project.reservation.model.vo.Account;

public class ReservationManager {

	private String[] selDate = new String[32];

	private String[] seatsFF = { "좌석을 선택하세요","1인 칸막이 좌석 (여성전용) a,a", "1인 칸막이 좌석 (여성전용) a,b", "1인 칸막이 좌석 (여성전용) a,c",
			"1인 칸막이 좌석 (여성전용) a,d", "1인 칸막이 좌석 (여성전용) a,e", "1인 칸막이 좌석 (여성전용) a,f", "1인 칸막이 좌석 (여성전용) a,g",
			"1인 칸막이 좌석 (여성전용) a,h", "1인 칸막이 좌석 (여성전용) a,i", "1인 칸막이 좌석 (여성전용) a,j", "1인 칸막이 좌석 (여성전용) a,k",
			"1인 칸막이 좌석 (여성전용) a,l", "1인 칸막이 좌석 (여성전용) a,m", "1인 칸막이 좌석 (여성전용) a,n", "1인 칸막이 좌석 (여성전용) a,o" };

	private String[] seatsFM = { "좌석을 선택하세요", "1인 칸막이 좌석 (남성전용) b,a", "1인 칸막이 좌석 (남성전용) b,b", "1인 칸막이 좌석 (남성전용) b,c",
			"1인 칸막이 좌석 (남성전용) b,d", "1인 칸막이 좌석 (남성전용) b,e", "1인 칸막이 좌석 (남성전용) b,f", "1인 칸막이 좌석 (남성전용) b,g",
			"1인 칸막이 좌석 (남성전용) b,h", "1인 칸막이 좌석 (남성전용) b,i", "1인 칸막이 좌석 (남성전용) b,j", "1인 칸막이 좌석 (남성전용) b,k",
			"1인 칸막이 좌석 (남성전용) b,l", "1인 칸막이 좌석 (남성전용) b,m", "1인 칸막이 좌석 (남성전용) b,n", "1인 칸막이 좌석 (남성전용) b,o" };

	private String[] seatsFO = { "좌석을 선택하세요", "1인 오픈형 좌석 c,a", "1인 오픈형 좌석 c,b", "1인 오픈형 좌석 c,c", "1인 오픈형 좌석 c,d", "1인 오픈형 좌석 c,e",
			"1인 오픈형 좌석 c,f", "1인 오픈형 좌석 c,g", "1인 오픈형 좌석 c,h", "1인 오픈형 좌석 c,i", "1인 오픈형 좌석 c,j", "1인 오픈형 좌석 c,k",
			"1인 오픈형 좌석 c,l", "1인 오픈형 좌석 c,m", "1인 오픈형 좌석 c,n", "1인 오픈형 좌석 c,o" };

	private String[] rooms = { "좌석을 선택하세요", "스터디룸 A (최대 4인)", "스터디룸 B (최대 4인)", "스터디룸 C (최대 4인)", "스터디룸 D (최대 4인)" };
	
	private int ticket = 0;
	public String[] getSelDate() {
		return selDate;
	}

	public void setSelDate(String[] selDate) {
		this.selDate = selDate;
	}

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

	// 생성자
	
	public ReservationManager() {}
	
	public ReservationManager(Account account) {
	}
	public Boolean OneSeat(Account account) { 
		if(account.getOneSeat()<= 0){
			 return false;

	  }else{
			return true;
	  }
	  
	}
	public Boolean StdRoom(Account account) { 
		if(account.getStdRoom()<= 0){
			 return false;

	  }else{
			return true;
	  
	  }
	  
	}
	
	public void check(Account account) {
		if(account.getYourSeat().contains("좌석")) {
			ticket = account.getOneSeat();
			  account.setOneSeat(ticket--);
		}else {
			  ticket = account.getStdRoom();
			  account.setStdRoom(ticket--);
		}
	}

	
	public String[] cDate() {
		SimpleDateFormat format1 = new SimpleDateFormat("MM월 DD일");
 		Date now = new Date();
 		String[] selDate = new String[31];
 		int date = now.getDate();
 		String time1 = format1.format(now);
 		int d = 1;
 		for(int i = 0 ; i <= 31 ; i++) {
 			if(i == 0) {
 			 selDate[i] = "날짜를 선택하세요.";
 			}else if(date < 32) {
 	 			selDate[i] = "5월 "+ (date++) + "일";
 	 			System.out.println(selDate[i]);

 			}else {
 	 			selDate[i] = "6월 "+ ( d++)+ "일";
 	 			System.out.println(selDate[i]);

 			}
 		}
 		return selDate;
	}
	public String[] takenF(Account account) {
	
		  for(int i = 0 ; i < seatsFF.length ; i++) {
			  if(seatsFF[i].equals(account.getYourSeat())) { 
				  seatsFF[i] = "예약된 좌석입니다.";
				  System.out.println(seatsFF[i] + account.getYourSeat() );
			  } 
		  }
		  return seatsFF;
	}
	public String[] takenM(Account account) {

		 for(int i = 0 ; i < seatsFM.length ; i++) {
			 
			  if(seatsFM[i].equals(account.getYourSeat())) { 
				 seatsFM[i] = "예약된 좌석입니다.";
				  System.out.println( seatsFM[i] + account.getYourSeat());
			 } 
		 }
		  return seatsFM;

	}
	
	public String[] takenO(Account account) {

		 for(int i = 0 ; i < seatsFO.length ; i++) {
			 
			  if(seatsFO[i].equals(account.getYourSeat())) { 
				 seatsFO[i] = "예약된 좌석입니다.";
				  System.out.println( seatsFO[i] + account.getYourSeat());
			 } 
		}
		  return seatsFO;

	}
	
	public String[] takenR(Account account) {
		 for(int i = 0 ; i < rooms.length; i++) {
			 
			  if(rooms[i].equals(account.getYourSeat())) { 
				 rooms[i] = "예약된 좌석입니다.";
				  System.out.println( rooms[i] + account.getYourSeat());
			 } 
		}
		 return rooms;
		 
	}
	
}