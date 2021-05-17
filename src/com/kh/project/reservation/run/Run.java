package com.kh.project.reservation.run;

import com.kh.project.reservation.controller.BeverageManager;
import com.kh.project.reservation.view.Login;
import com.kh.project.reservation.view.appMenu;


import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.Login;

import com.kh.project.reservation.view.MenuChoice;
import com.kh.project.reservation.view.appMenu;
import com.kh.project.reservation.view.checkBooking;


public class Run {

	public static void main(String[] args) {

		//테스트

//		new appMenu().mainMenu();

		new appMenu();

//		Login l = new Login();
//		SignUp s = new SignUp();
//		Update u = new Update();
//		Check c = new Check();
	
//		checkBooking c = new checkBooking();

		//appMenu am = new appMenu();
//		am.mainMenu();
		
		new Login();
		//MenuChoice m = new MenuChoice();
	
		//appMenu am = new appMenu();
		//am.mainMenu();

		
		Account ac[] = new Account[40]; //테스트를 위해 회원가입 했습니다.
		ac[0] = new Account("subin", "0915", "Subin", "000915-4******", 'F', "01033715190","하나은행" ,"0915200011112222");
		System.out.println(ac[0].info());		

//		appMenu am = new appMenu();
//		am.Menu();
//		
//		Login l = new Login();
//		

		MenuChoice m = new MenuChoice();

	}

}
