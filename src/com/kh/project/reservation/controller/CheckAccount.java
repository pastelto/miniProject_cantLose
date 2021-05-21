package com.kh.project.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.project.reservation.model.dao.MemberDao;
import com.kh.project.reservation.model.vo.Account;

public class CheckAccount {

	private MemberDao md = new MemberDao();
	HashMap<String, Account> membership= new HashMap<>();
	
	Account account = new Account();
	
	public CheckAccount() {}
	
	/*public void addSingIn(Account account) { 
		md.fileSave(account);
		
	}*/
	public ArrayList<Account> searchAccount(String id, String pw) { // id 
	   ArrayList<Account> list = md.searchAccount(id,pw);
	return list;
	}

	public void writeAccount(Account account) {
		md.writeAccount(account);
	}

	public void saveAccount() {
		md.saveAccount();		
	}
	
}