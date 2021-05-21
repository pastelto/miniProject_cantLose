package com.kh.project.reservation.model.vo;

import com.kh.project.reservation.view.BookView;

public class Book {
	
	Account ac =  new Account();

	public Book() {
		
	}
	
	public void loginCheck() {
		if(!ac.getId().equals(null)&&!ac.getName().equals(null)/*ticket이 0이 아닌 경우*/) {
			new BookView().monAndSeat();
		}
	}
	
	
	
	
}




