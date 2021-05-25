package com.kh.project.reservation.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.model.vo.Account;

public class DrinkManager2 {

	private Scanner sc = new Scanner(System.in);
	private ArrayList cart = new ArrayList();
	
	int price = 2000; // 가격
	int num; // gui에서 수량을 받아오는
	String menu;// gui에서 메뉴를 받아오는
	

	public DrinkManager2() {
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

	public String select(Account account) {
		System.out.println("select 돌아가는 중");
		cart.add(menu +" " + num + "잔 ");
		System.out.println("시스템2 " + cart);//
		String result = cart.toString();

		// 수량
		account.setBeverage(account.getBeverage()+num);
		
		//System.out.println("총슈량2" + account.getBeverage());
		
		
//		numS += num;
//		System.out.println("총수량2 : " + numS);
		
		//menusave(cart);
		//totalmoney(account);
		


		return result; // 저장된걸 반환
	}

	// 메뉴와 가격 저장 - 장바구니 메소드
	public String cartIn(ArrayList cart ) {
		String result = cart.toString();
		System.out.println("장바구니 : "+cart);//
		
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
