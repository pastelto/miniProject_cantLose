package com.kh.project.reservation.run;

import com.kh.project.reservation.model.vo.Account;

public class Run {

	public static void main(String[] args) {
		/*
		 * System.out.println("default"); System.out.println("김명선");
		 * System.out.println("add dayeong");
		 * System.out.println("DH first commit testing"); System.out.println("주연 수정");
		 * System.out.println("A ");
		 */
		
		//appMenu am = new appMenu();
		//am.mainMenu();
		
		Account ac[] = new Account[40]; //테스트를 위해 회원가입 했습니다.
		ac[0] = new Account("subin", "0915", "Subin", "000915-4******", 'F', "01033715190","하나은행" ,"0915200011112222");
		System.out.println(ac[0].info());		
		
		
		/**
		Book bk = new Book();
		bk.pSeatForWoman();
		bk.pSeatForMan();
		bk.oSeat(); 왕수빈 테스트용
		**/
	}

}
