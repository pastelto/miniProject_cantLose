
package com.kh.project.reservation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.InOut;

public class InOutManager {

	private Account account = new Account();
	private InOut io = new InOut();
	//private InOutManager iom = new InOutManager();
	//private ArrayList in = new ArrayList();
	private Scanner sc = new Scanner(System.in);

	public InOutManager() {
		// TODO Auto-generated constructor stub
	}
	
	/*public void login(String ) {
		
	}*/
	/*
	 private void checkInOutM() {
        // ArrayList ss = iom.checkInSave();
         
         if (account.getDbcheck().equals("")) {// 체크인 안했을 때 
            while (true) {
               //System.out.println("체크인 또는 체크아웃 또는 이전을 입력하세요");
               //String str = sc.nextLine(); --> 버튼 
               if (str.equals("체크인")) {
                  checkIn(); // 체크인 메소드
                  break;
               } else if (str.equals("체크아웃")) {
                  System.out.println("체크인 한 기록이 없습니다. 메인 화면으로 돌아갑니다.  ");
                  break;
               } else if (str.equals("이전")) {
                  System.out.println("메인메뉴로 돌아갑니다.");
               }
            }
         } else if (ss.get(3).equals("체크인")) {// 체크인 한 버전 // 상태 확인
            io.chechkedIn();
            String str = sc.nextLine();
            if (str.equals("체크아웃")) {
               checkOut(); // 체크아웃 메소드
            }else if (str.equals("이전")) {
               System.out.println("메인메뉴로 돌아갑니다.");
            }
         } else { 
            System.out.println("체크아웃하여 재입실이 불가합니다." + " \n" + "메인 화면으로 돌아갑니다.");
         }
      }
      */


//	public ArrayList checkInSave() { // 이름 좌석 체크인시간 상태 저장
//
//		if (account.getId() == aaccount.getPw() /* &&예약정보가 존재한다면-> 예약정보가져오는거로 바꾸기 */ ) {
//
//			{
//				in.add(account.getName());
//				in.add("좌석");
//				in.add(io.getCheckIn());
//				//in.add(io.getDoubleCheck());
//
//			}
//
//		}
//		return in;
//	}


	//요게 돌ㅇ가는 거 
//	public String checkInPrint() { // 체크인 정보 출력
//		String start =  new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(System.currentTimeMillis());
//
//		io.setCheckIn(start);
//		System.out.println("매니저에서 뽑는 체크인 시간 "+start);
//		
//		String startP = io.getCheckIn();
//			
//			return startP;
//	}
	
	public String checkInPrint() { // 체크인 정보 출력
		String start =  io.getCheckIn();

		System.out.println("매니저에서 뽑는 체크인 시간 "+start);
		

			
			return io.getCheckIn();
	}
	
	
	


	public void chechkedIn() { // 체크인 상태 출력
		System.out.println("<체크인 상태>");
		checkInPrint();

		System.out.println("현재 체크인 중 입니다." + "\n" + "체크아웃 또는 이전을 입력하세요");
	}

//	public int checkOutPrint() { // 체크아웃 정보 출력
//		io.setCheckOut(System.currentTimeMillis());
//		String end = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(io.getCheckOut());
//
//		// 초를 시간으로 분으로
//		int ss = (int) Math.round((io.getCheckOut() - io.getCheckIn()) / 1000.0); // 초
//		int hour, min, sec = ss;
//		min = sec / 60;
//		hour = min / 60;
//		sec = sec % 60;
//		min = min % 60;
//
//		System.out.println(in.get(0) + " 님");
//		System.out.println("좌석");
//		System.out.println("체크아웃 시간 : " + end);
//		System.out.printf("이용 시간 : %d시 %d분 %d초 \n", hour, min, sec);
//
//		{
//			in.set(3, "체크인 불가");// 체크아웃 후 체크아웃을 눌렀을때 재입실을 다시 못하게
//		}
//
//		// 누적시간 -> 조건 필요함?? 다시 테스트 해보기
//		a.setTotalH(a.getTotalH() + ss);
//		pluscoupon();
//		
//		return a.getTotalH();
//	}
//
//	public int pluscoupon() {
//		// 100시간이 될때마다 쿠폰 +1씩
//		if ((a.getTotalH() % 360000 == 0)) {
//			a.setCoupon(a.getCoupon() + 1);
//		}
//		
//		return a.getCoupon();
//
//	}

}


