package com.kh.project.reservation.controller;

import java.util.HashMap;
import java.util.Iterator;

import com.kh.project.reservation.model.dao.MemberDao;
import com.kh.project.reservation.model.vo.Account;

public class CheckAccount {

	private MemberDao md = new MemberDao();
	HashMap<String, Account> membership= new HashMap<>();
	
	Account account = new Account();
	String id ="";
	
	public CheckAccount() {}
	
	public void addSingIn(Account account) { 
		md.fileSave(account);
		
	}
	
	
	public void checkIdNPw() { // ID 와 패스워드 일치시 if 문
		
	}
	public HashMap<String, Account> selectAll() {
		return md.selectAll();
	}
	
	public void checkSingIn() { 
	if(membership.isEmpty()) {
		System.out.println("없습니다.");
	}else {
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(map.get(it.next()));
		}
	}
	}
	public void check() {
		
	}
	
}
