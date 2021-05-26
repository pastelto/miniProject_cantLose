package com.kh.project.reservation.controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.Memo.MyMemo;

public class MemoManager {


		Account account = new Account();
		
		public MemoManager() {}
		
		public String callMyMemo(Account account) {
			String str = "";
			String fileName = account.getId().toString() + ".dat"; // 개인 메모만 읽기 가능
			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

				String temp = "";
				while ((temp = br.readLine()) != null) {

					str += temp + "\n";

				}

				br.close();

			} catch (FileNotFoundException e) {
				System.out.println("존재하는 파일이 없습니다. ");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("temp? : " + str);
			return str;
 
		}

		public void saveMemo(Account account, String memo) {
			String fileName = account.getId().toString() + ".dat";

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

				bw.write(memo);
				System.out.println("메모 내용 " + memo);
				System.out.println("입력받은 " + fileName + " 파일에 성공적으로 저장하였습니다. ");

			} catch (IOException e) {
				e.printStackTrace();
			}

			new MyMemo(account);
		}	
	}
		
