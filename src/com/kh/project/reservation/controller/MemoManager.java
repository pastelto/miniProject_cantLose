package com.kh.project.reservation.controller;


import java.util.ArrayList;
import java.util.HashMap;

import com.kh.project.reservation.model.dao.MemoDao;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Memo;

public class MemoManager {

		private MemoDao md = new MemoDao();
		HashMap<String, String> hmMemo = new HashMap<>();
		
		Account account = new Account();
		
		public MemoManager() {}

		public Memo writeMemo(Account account, Memo memo) {
			md.writeMemo(account, memo);
			return memo;
		}

		public void saveMemo(Account account, Memo memo) {
			md.saveMemo(account, memo);		
		}
		
		public void editMemo(Account account,ArrayList<Memo> m) {
			md.editMemo(account,m);
			
		}
			
	}
		
