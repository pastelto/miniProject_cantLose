
package com.kh.project.reservation.controller;

import java.util.Random;

import javax.swing.JOptionPane;

import com.kh.project.reservation.model.vo.Account;

public class PrintServiceManager {

	private int colorPrint = 100; // 컬러프린트 비용
	private int blackPrint = 50; // 흑백프린트 비용

	public PrintServiceManager() {
		
	}

	public void prtPointCharge(Account account, int count) { // 프린트 포인트 충전

		account.setPrintPoint(account.getPrintPoint() + count);
		JOptionPane.showMessageDialog(null, "충전완료!!");
		System.out.println(account.getPrintPoint()); // 잘들어갔나 콘솔확인용

	}

	public int prtPointUse(Account account, int bkPage, int clPage) { // 프린트 포인트 사용
		int total = (bkPage * blackPrint + clPage * colorPrint);

		if (account.getPrintPoint() >= total) { // 포인트 사용가능할떄
			account.setPrintPoint(account.getPrintPoint() - total);
			JOptionPane.showMessageDialog(null, "남은포인트 : " + account.getPrintPoint() + " 점" + "\n" 
											+ "프린트 코드를 프린트에 입력해주세요! "+ "\n" 
						 					+ "프린트코드 : " + prtCode());
		} else { // 포인트 사용 불가능할때
			JOptionPane.showMessageDialog(null, "충전이 필요합니다." + "\n" 
										+ "현재포인트 : " + account.getPrintPoint() + "\n"
										+ "필요한 포인트 : " + -(account.getPrintPoint() - total));
		}

		return account.getPrintPoint();
	}

	public String prtCode() { // 프린트 코드발급(4자리 랜덤수)
		Random random = new Random();
		int rdmInt = random.nextInt(9);
		String pin = "";
		while (pin.length() < 4) {
			rdmInt = random.nextInt(9);
			String addition = String.valueOf(rdmInt);
			if (pin.contains(addition))
				continue;
			pin += addition;
		}
		return pin;
	}
}
