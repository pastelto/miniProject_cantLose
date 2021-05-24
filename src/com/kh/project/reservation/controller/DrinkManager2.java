package com.kh.project.reservation.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Beverage;

public class DrinkManager2 {

	private Beverage b = new Beverage();
	private Scanner sc = new Scanner(System.in);
	ArrayList cart = new ArrayList();
	
	int price = 2000; // 가격

	int num; // gui에서 수량을 받아오는
	String menu;// gui에서 메뉴를 받아오는
	int numS; // 총수량

	public DrinkManager2() {
	}

	// 수량 받아오기 gui에서
	public void countsave(String count) {
		num = Integer.valueOf(count);
		System.out.println(num);
		
	
	}

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
	public String menusave(ArrayList cart ) {
	
		
		System.out.println("장바구니 메소드는 타고 있어 ");
		String result = cart.toString();
		System.out.println("장바구니 : "+cart);//
		
	
		return result;
	}

	// 음료 결제
	public void buydrink(Account account) {
		b.setDiscount((int) (b.getTemp() * (account.getCoupon() * 0.1))); // ->할인금액
		
		//menusave(select);


		// 쿠폰이 1개라면
		/*
		 * if (a.getCoupon() >= 1) { System.out.println("사용가능한 쿠폰이 " + a.getCoupon() +
		 * "장 있습니다. 사용하시겠습니까? "); String s = sc.nextLine(); if (s.equals("y")) {
		 * System.out.println("쿠폰을 사용하여 " + b.getDiscount() + "원 할인되었습니다. ");
		 * System.out.println("남은 금액인 " + (b.getTemp() - b.getDiscount()) + "원은 등록하신 " +
		 * a.getPay() + "로 자동결제 되었습니다. 맛있게 먹엉♡");
		 * 
		 * } else if (s.equals("n")) { System.out.println("등록하신 " + a.getPay() +
		 * "로 자동결제 되었습니다. 맛있게 먹엉♡"); }
		 * 
		 * }
		 */// => gui 다이얼로그로 만듬

	}

	public int totalmoney(Account account) {
		
		int result = account.getBeverage()*price;

		System.out.println("총금액" + result);
		
		return result;
	}

}
