package com.kh.project.reservation.controller;

import java.util.HashMap;
import java.util.Iterator;

import com.kh.collection.silsub1.model.vo.Board;
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
	public String checkId(String id) { // id 
	   md.fileOpen();
	return id;
	}
	public String checkPw(String pw) { // 패스워드 일치시
		md.fileOpen();
		return pw;
	}
	
	public void checkSingIn() { 
		md.writeList(new Account());
		}
	public void check() {
		
	}
	
}
