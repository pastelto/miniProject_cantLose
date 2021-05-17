package com.kh.project.reservation.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.kh.collection.silsub2.model.vo.Book;
import com.kh.project.reservation.model.vo.Account;

public class MemberDao { // file로 Hashmap으로 저장해서 파일 불러와서 내용 일치 확인<ID,PW>과 멤버 정보 저장

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
			System.out.println("성공정으로 저장되었습니다.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void fileOpen() { // 로그인시 정보 확인 부분
		try {
			ObjectInputStream login = new ObjectInputStream(new FileInputStream("member.txt"));
			System.out.println(membership);
			Account account;
			while((account = (Account) login.readObject()) != null) {
				membership.put(key, value);
			}
			
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
