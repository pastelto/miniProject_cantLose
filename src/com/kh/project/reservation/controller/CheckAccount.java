package com.kh.project.reservation.controller;

import java.util.HashMap;
import java.util.Iterator;

import com.kh.project.reservation.model.dao.MemberDao;
import com.kh.project.reservation.model.vo.Account;

public class CheckAccount {

	private MemberDao md = new MemberDao();
	Account account = new Account();
	String id ="";
	
	public CheckAccount() {}
	
	public void addSingIn(Account account) { 
		md.fileSave(account);
		
	}
	public void checkId(String id) { // ID 일치시 
		md.fileOpen();
	}
	public void checkPw(String pw) { // 패스워드 일치시
		md.fileOpen();
	}
	
	public void checkSingIn() { 
		HashMap<String, Account> membership = md.selectAll();
	if(membership.isEmpty()) {
		System.out.println("없습니다.");
	}else {
		Iterator<String> it = membership.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(membership.get(it.next()));
		}
	}
	}
	public void check() {
		
	}

	
	
}
