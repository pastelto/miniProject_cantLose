package com.kh.project.reservation.model.vo;

import java.util.ArrayList;

import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.view.BookView;

public class Book {
	Account ac = new Account();
	
	private ArrayList<Book> thisPerson = new ArrayList<Book>();
	
	
	private String yourSeat;
	private String yourDate;
	private Boolean gotTicket;
	

	//constructor
	public Book() {
		
	}

	//getters & setters

	public Boolean getGotTicket() {
		return gotTicket;
	}

	public void setGotTicket(Boolean gotTicket) {
		this.gotTicket = gotTicket;
	}
	
	public ArrayList<Book> getThisPerson() {
		return thisPerson;
	}



	public void setThisPerson(ArrayList<Book> thisPerson) {
		this.thisPerson = thisPerson;
	}


	public String getYourSeat() {
		return yourSeat;
	}



	public void setYourSeat(String yourSeat) {
		this.yourSeat = yourSeat;
	}



	public String getYourDate() {
		return yourDate;
	}



	public void setYourDate(String yourDate) {
		this.yourDate = yourDate;
	}
	//

	public Book(Account account) {
		/*
	}
		if(ac.getTicket() > 0) {
			new BookView(account);
			
		}else {
			JOptionPane.showMessageDialog(
					null, 
					"이용권 구매 이후 예약 가능합니다.",
					"이용권이 없습니다",
					JOptionPane.PLAIN_MESSAGE, 
					null
					);
				
			//new Ticket(account); 
		}
	*/
		/*
		//성별판별하기
		try {
			FileInputStream aintFree = new FileInputStream(new File("account.txt"));
			int read = aintFree.available();
			byte[] infos = new byte[read];
			aintFree.read(infos);
			System.out.println(new String(infos));
				
				/*
				for(int i = 0 ; i < forMe.size() ; i++) {
					forMe.add()
				}
				
			
			aintFree.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
	}




	
	
	}



