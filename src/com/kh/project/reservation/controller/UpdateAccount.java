
package com.kh.project.reservation.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.project.reservation.model.vo.Account;

public class UpdateAccount {
	private ArrayList<Account> list = new ArrayList<>();

	public UpdateAccount() {
	}

	public void update(Account account, String pw, String pnum, String pay) {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("account.dat"))) {
			list.addAll((ArrayList<Account>) ois.readObject());

		} catch (ClassNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.1");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.2");
		} catch (IOException e) {
			System.out.println("파일을 찾을 수 없습니다.3");
		}

		System.out.println(list);
		System.out.println("====================================");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(account.getId())) {
				if (!pw.equals("")) {
					list.get(i).setPw(pw);
				}
				if (!pnum.equals("")) {
					list.get(i).setpNum(pnum);
				}
				if (!pay.equals("")) {
					list.get(i).setPay(pay);
				}
			}

		}
		try {
			new FileOutputStream("account.dat").close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("account.dat"))) {
			System.out.println(list);
			oos.writeObject(list);

			System.out.println("account.dat에 성공적으로 저장되었습니다.");

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 찾을 수 없습니다.2");
		}

	}

}
