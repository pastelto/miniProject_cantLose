package com.kh.project.reservation.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.project.reservation.model.vo.Account;

public class DrinkManager {

	private Account a = new Account();
	private Scanner sc = new Scanner(System.in);
	private ArrayList al = new ArrayList();

	public DrinkManager() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	//돌아가는 while문 
	public void orderBeverage() {
		while (true) {
			System.out.println("***움료 메뉴***");
			System.out.println("1.아메리카노"); // 2000
			System.out.println("2.아이스아메리카노"); // 2000
			System.out.println("3.카페라떼"); // 3000
			System.out.println("4.아이스카페라떼"); // 3000
			System.out.println("5.핫초코"); // 2000
			System.out.println("6.아이스초코"); // 2000
			System.out.println("7.딸기우유"); // 4000
			System.out.println("8.레몬에이드"); // 3000
			select();
		}
	}
	
	 // 메뉴와 가격 저장 - 장바구니 메소드
	public void menusave() {
		System.out.println("***장바구니***");
		
		for(int i=0; i < al.size(); i++) {
			
			if( i%2 == 0 ) {
				System.out.println("주문 메뉴 : " + al.get(i));
			}else {
				System.out.println("갯수 : " + al.get(i));
			}
		}
		
		

	}

	// 음료선택
	private void select() {
		while (true) {
			System.out.println("메뉴이름");
			String menu = sc.nextLine();
			System.out.println("갯수선택");
			int num = sc.nextInt();
			sc.nextLine();
			
			{
				al.add(menu);
				al.add(num);
			}
			
			System.out.println("장바구니에 더 담으시겠습니까? (Y/N)");
			String str = sc.nextLine();

			if (str.equals("y")) { 
				continue;
			} else {
				//결제메소드
				buydrink();
			}
		}
	}

	private void buydrink() {
		//장바구니 메소드 불러오기
		menusave();
		
		//총금액 total 계산 메소드
		totalmoney();
		
		
		
//		//System.out.println("총 " + total + "원 입니다.");
//		
//		//쿠폰이 1나라면 두개라면 
//		if(a.getCoupon() == 1) {
//			System.out.println("사용가능한 쿠폰이 1장 있습니다. 사용하시겠습니까? ");
//			String s = sc.nextLine();
//			if(s.equals("Y")) {
//				System.out.println("쿠폰을 사용하여 " + 총금액*0.2 + " 할인되었습니다. ");
//				System.out.println("남은 금액은 등록하신 "+ a.getPay()+ "로 자동결제 되었습니다. 맛있게 먹어라 ");
//				총금액 * 0.8 
//			}else if(s.equals("N")) {
//				System.out.println("등록하신 " + a.getPay()+ "로 자동결제 되었습니다. 맛있게 먹어라 ");
//			}
//			
//		}//쿠폰이 2장이상이라면?
		
	


	}

	private void totalmoney() {
		
		StringBuilder sb = new StringBuilder();
		
		
		
		
	}




	private void buybCoupon() {

		System.out.println("***음료쿠폰 구매***");
		System.out.println("수량 : ");
		int num = sc.nextInt();
		sc.nextLine();
		a.setCoupon(a.getCoupon() + num);
		System.out.println("쿠폰 " + num + "개를 구매하셔서 총 " + (num * 2000) + "원 입니다.");
		System.out.println(a.getPay() + " 로 결제완료되었습니다.");
		System.out.println("보유하고 있는 쿠폰갯수는 총 " + a.getCoupon() + "입니다.");

	}
	
	
	

}
