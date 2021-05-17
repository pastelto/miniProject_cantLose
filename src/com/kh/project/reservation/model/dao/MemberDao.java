package com.kh.project.reservation.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.kh.project.reservation.model.vo.Account;

public class MemberDao { // file로 hashmap으로 저장해서 파일 불러와서 내용 일치 확인<ID,PW>과 멤버 정보 저장

	HashMap <String, Account> membership = new HashMap<>();
		
	public MemberDao() { 
		
		membership = new HashMap<String, Account>();
	}
	
	public void fileSave(Account account) { // 회원가입시 - key -ID // value - ID, PassWord, 주민번호 등등
		try {
			membership.put(account.getId(), account);
			ObjectOutputStream loginFile = new ObjectOutputStream(new FileOutputStream("member.txt"));
			
			System.out.println(membership);
			loginFile.writeObject(membership);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileOpen(Account account) { // 로그인시 정보 확인 부분
		try {
			ObjectInputStream login = new ObjectInputStream(new FileInputStream("member.txt"));
			System.out.println(membership);
			membership = (HashMap<String, Account>) login.readObject();
			
		}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeSignIn() {
		
	}

	}

