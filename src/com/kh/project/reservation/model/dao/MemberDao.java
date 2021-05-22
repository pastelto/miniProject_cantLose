package com.kh.project.reservation.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.Login;


public class MemberDao { // file로 으로 저장해서 파일 불러와서 내용 일치 확인<ID,PW>과 멤버 정보 저장

	private ArrayList<Account> list = new ArrayList<>();
	
	public MemberDao() { 
		
		try(ObjectInputStream ois = new ObjectInputStream (new FileInputStream("account.txt"))){
			list.addAll((ArrayList<Account>)ois.readObject());
			
			/* Account b; 
			 while((b=(Account)ois.readObject()) != null) { 
				 list.add(b); }*/
			 
		}catch(ClassNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.1");
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.2");
		}catch(IOException e) {
			System.out.println("파일을 찾을 수 없습니다.3");
		}
	}

		/*
	 public void fileSave(Account account) { // ArrayList로 넣어서 append(경로, true)로 넣어서 Input으로 넣기
		try {
			if(//폴더가 있면); { //폴더가 있면
					list.add(account);
			ObjectOutputStream loginFile = new ObjectOutputStream(new FileOutputStream("member.txt",true));
			
			loginFile.writeObject(membership);
			System.out.println("성공정으로 저장되었습니다.");
			loginFile.close();
			
			else { // 폴더가 없으면
				
			// memeber[i] = 에 id,password,idNum....이런식으로 생성하고 tokenizer나 spilt를 통해서 나눠서 담고
			// bufferedreader readline으로 해서 읽어오고
			// save할때 -member[i]이런식으로 해서 다시 .append(it, true) --> 이렇게 하면 한칸씩 띄어서 입력 (이거 시험)
				
				// true 미작성시 : 기존 해당 파일이 있을경우 덮어씌워짐 ( 기본값 false )
				// true 작성시 : 기존 파일이 있는 경우 이어서 작성됨(append)
				// ex) fout = new FileOutputStream("a_byte.txt",true); // FileNotFoundException 발생 : 없는 경로 제시시에 발생 (ex_ "")
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} */

	
	public void writeAccount(Account account) {
		list.add(account);
	}

	public void saveAccount() {
		try(ObjectOutputStream oos = new ObjectOutputStream
				(new FileOutputStream("account.txt"))){
			System.out.println(list);
			oos.writeObject(list);
						
			System.out.println("account.txt에 성공적으로 저장되었습니다.");
			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("파일을 찾을 수 없습니다.2");
		}
		
	}
	public ArrayList<Account> searchAccount(String id, String pw) {

		ArrayList<Account> check = new ArrayList<Account>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().contains(id)&&list.get(i).getPw().contains(pw)) {
				check.add(list.get(i));
				System.out.println(list.get(i));
			} 
		}
		System.out.println(check);
		return check;
	}

	public Boolean CheckId(String id) {
		ArrayList<Account> check = new ArrayList<Account>();
		for(int i =0; i<check.size();i++) {
			if(list.get(i).getId().contains(id)) {
			return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public Boolean CheckIdNum(String idNum) {
		ArrayList<Account> check = new ArrayList<Account>();
		for(int i =0; i<check.size();i++) {
			if(list.get(i).getIdNum().contains(idNum)) {
			return true;
			} else {
				return false;
			}
		}
		return false;
	}

	}
	
