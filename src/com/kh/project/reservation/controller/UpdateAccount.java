package com.kh.project.reservation.controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.Login;

public class UpdateAccount {

	public UpdateAccount() {
	}

	public void updatePW(Account account, String pw) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt",true))){
			account.setPw(pw);
			oos.writeObject(account);
			
			System.out.println("비밀번호가 저장되었습니다.");
			
			new Login();
		}catch (Exception ex){
			System.out.println("비밀번호  저장을 실패 하였습니다.");
		}
	
	}

	public void updatePay(Account account, String pnum) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt",true))){
			account.setPw(pnum);
			oos.writeObject(account);
			
			System.out.println("비밀번호가 저장되었습니다.");
			
			new Login();
		}catch (Exception ex){
			System.out.println("비밀번호  저장을 실패 하였습니다.");
		}
	
	}

	public void updatePNum(Account account, String pay) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt",true))){
			account.setPw(pay);
			oos.writeObject(account);
			
			System.out.println("비밀번호가 저장되었습니다.");
			
			new Login();
		}catch (Exception ex){
			System.out.println("비밀번호  저장을 실패 하였습니다.");
		}
	
	}
}
