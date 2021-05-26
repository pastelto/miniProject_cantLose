package com.kh.project.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.project.reservation.model.dao.MemberDao;
import com.kh.project.reservation.model.vo.Account;

public class CheckAccount {   

	private MemberDao md = new MemberDao();
	private Account account = new Account();
	
	public CheckAccount() {}
	
	public ArrayList<Account> searchAccount(String id, String pw) { // id 
	   ArrayList<Account> a = md.searchAccount(id,pw);
	   
	return a;
	}

	public void writeAccount(Account account) {
		md.writeAccount(account);
	}

	public void saveAccount() {
		md.saveAccount();		
	}
	
	public Boolean checkId(String id) { 
		if(md.CheckId(id)) {
			return true;
			
		}
		return false;
		
}
	
	public Boolean checkIdNum(String idNum) { 
		if(md.CheckIdNum(idNum)) {
			return true;
			
		}
		return false;
}
	
	
	public ArrayList<Account> find(String name, String idNum) { // id 
		   ArrayList<Account> a = md.Find(name,idNum);
			return a;
			}
		
}
	