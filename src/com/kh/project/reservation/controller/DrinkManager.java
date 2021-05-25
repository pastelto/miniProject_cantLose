package com.kh.project.reservation.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.model.vo.Account;

public class DrinkManager {

	private ArrayList cart = new ArrayList();
	
	private	int price = 2000; // 가격
	private int num; // gui에서 수량을 받아오는
	private String menu;// gui에서 메뉴를 받아오는
	

	public DrinkManager() {
	}

	// 수량 받아오기 gui에서
	public void countsave(String count) {
		num = Integer.valueOf(count);
		System.out.println(num);
	}
	// 메뉴 받아오기 gui에서
	public void menuget(String str) {
		menu = str;
		System.out.println(menu);
	}
	
	//장바구니에 담기
	public String select(Account account) {
		cart.add(menu +" " + num + "잔 ");
		String result = cart.toString();
		// 수량
		account.setBeverage(account.getBeverage()+num);		
		
		return result; 
	}

	// 음료 결제
	public int buydrink(Account account) {
		int num = totalmoney(account);// 총금액
		int discount = (int) (num * account.getCoupon() * 0.1);
		System.out.println("할인가" + discount);

		return discount;
	}

	public int totalmoney(Account account) {
		int result = account.getBeverage()*price;
		System.out.println("총금액" + result);
		
		return result;
	}
	


}
