package com.kh.project.reservation.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.project.reservation.model.vo.Account;


public class MemberDao { // file로 으로 저장해서 파일 불러와서 내용 일치 확인<ID,PW>과 멤버 정보 저장

	ArrayList<Account> list = new ArrayList<>();
	Account account;
	public MemberDao() { 
		
		BufferedReader br = new BufferedReader (new InputStreamReader (new FileInputStream(".txt")));  {
			Account b;
			while((b=(account)ois.readObject())!=null) {
				list.add(b);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
		public void writeList(Account account) {
			list.add(account);
			
		}
	
	 public void fileSave(Account account) { // ArrayList로 넣어서 append(경로, true)로 넣어서 Input으로 넣기
		try {
			if(//폴더가 있면); { //폴더가 있면
					list.add(account);
			ObjectOutputStream loginFile = new ObjectOutputStream(new FileOutputStream("member.txt"));
			
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
		
	}
	
	public void fileOpen() { // 로그인시 정보 확인 부분
		try {
			ObjectInputStream login = new ObjectInputStream(new FileInputStream("member.txt"));
			Account account;
			while((account = (Account) login.readObject()) != null) {
				membership.put(account.getId(), account);
				login.close();
				
				// for 문을 돌리면서 -오픈은 생성자에 넣어서, tokenizer등으로 뽑으면서 비교해야 id랑 pw가 일치하는것을 하고
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



	public HashMap<String, Account> selectAll() {
		return null;
	} 

	
	}

