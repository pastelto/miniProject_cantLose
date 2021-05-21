package com.kh.project.reservation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.InOut;

public class InOutManager {

	private Account a = new Account();
	private InOut io = new InOut();
	private ArrayList in = new ArrayList();
	private Scanner sc = new Scanner(System.in);

	public InOutManager() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList checkInSave() { // 이름 좌석 체크인시간 상태 저장

		if (a.getId() == a.getPw() /* &&예약정보가 존재한다면-> 예약정보가져오는거로 바꾸기 */ ) {

			{
				in.add(a.getName());
				in.add("좌석");
				in.add(io.getCheckIn());
				in.add(io.getDoubleCheck());

			}
			
		}
		return in;
	}

	public void checkInPrint() { // 체크인 정보 출력
		String start = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(in.get(2));

		System.out.println(in.get(0) + " 님");
		System.out.println("좌석");
		System.out.println("체크인 시간 : " + start);
		{
			in.set(3, "체크인"); // 체크인 상태로 바꿔서 체크인을 눌렀을때 체크인을 다시 못하게
		}

	}

	public void chechkedIn() { // 체크인 상태 출력
		System.out.println("<체크인 상태>");
		checkInPrint();

		System.out.println("현재 체크인 중 입니다." + "\n" + "체크아웃 또는 이전을 입력하세요");
	}

	public void checkOutPrint() { // 체크아웃 정보 출력
		io.setCheckOut(System.currentTimeMillis());
		String end = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(io.getCheckOut());
		

		// 초를 시간으로 분으로
		int ss = (int) Math.round((io.getCheckOut() - io.getCheckIn()) / 1000.0); // 초
		int hour, min, sec = ss;
		min = sec / 60;
		hour = min / 60;
		sec = sec % 60;
		min = min % 60;

		System.out.println(in.get(0) + " 님");
		System.out.println("좌석");
		System.out.println("체크아웃 시간 : " + end);
		System.out.printf("이용 시간 : %d시 %d분 %d초 \n", hour, min, sec);

		{
			in.set(3, "체크인 불가");// 체크아웃 후 체크아웃을 눌렀을때 재입실을 다시 못하게
		}
		
		//누적시간 -> 조건 필요함?? 다시 테스트 해보기 
		a.setTotalH(a.getTotalH() + ss);
	
		}

	}

	

	



