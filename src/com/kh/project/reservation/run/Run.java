package com.kh.project.reservation.run;

import com.kh.project.reservation.view.appMenu;
import com.kh.project.reservation.view.checkBooking;

public class Run {

	public static void main(String[] args) {

		//테스트
		new appMenu().mainMenu();


//		Update u = new Update();
//		Check c = new Check();
	
		checkBooking c = new checkBooking();
	}

}
