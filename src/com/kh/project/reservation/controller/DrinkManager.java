
package com.kh.project.reservation.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Beverage;

public class DrinkManager {

	private Account a = new Account();
	private Beverage b = new Beverage();
	private Scanner sc = new Scanner(System.in);
	private HashMap<String, Integer> dc = new HashMap<String, Integer>(); // 장바구니 출력
	private HashMap<String, Integer> dr = new HashMap<String, Integer>(); // 메뉴와 가격 저장

	{// 메뉴종류 초기화
		dr.put("아메리카노", 2000);
		dr.put("아이스아메리카노", 2000);
		dr.put("카페라떼", 3000);
		dr.put("아이스카페라떼", 3000);
		dr.put("핫초코", 2000);
		dr.put("아이스초코", 2000);
		dr.put("자몽에이드", 4000);
		dr.put("레몬에이드", 4000);
		dr.put("물", 1000);

	}

	int temp = 0; // 총금액 담는 변수
	Set<String> eSet1 = dc.keySet(); // 카트에 메뉴만 담은 것 
	
	int num; // gui에서 수량을 받아오는
	String menu;// gui에서 메뉴를 받아오는

	public DrinkManager() {
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

	public HashMap<String, Integer> select() {

			System.out.println("select 돌아가는 중");
			{
				dc.put(menu, num);
			}
		
			//카트에 뭐가 담겼나 보자
			Set< Entry<String, Integer> > eSet1 = dc.entrySet();

			Iterator<Entry<String, Integer>> it1 = eSet1.iterator();
			while(it1.hasNext()) {
				Entry<String, Integer> entry = (Entry)it1.next();
				System.out.println(entry.getKey() + " = " + entry.getValue());
			}
		return dc; // 저장된걸 반환 
	}
	
	
	// 메뉴와 가격 저장 - 장바구니 메소드
	public void menusave() {
		System.out.println("장바구니 메소드는 타고 있어 ");
		
		HashMap<String, Integer> dcNew = select();
		
		 Set< Entry<String, Integer> > eSet1 = dcNew.entrySet();

		Iterator<Entry<String, Integer>> it1 = eSet1.iterator();
		while(it1.hasNext()) {
			System.out.println("장바구니 메소드 이터레이터는 타고 있어 ");
			Entry<String, Integer> entry = (Entry)it1.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		
//		Set< Entry<String, Integer> > eSet1 = dc.entrySet();
//
//		Iterator<Entry<String, Integer>> it1 = eSet1.iterator();
//		while(it1.hasNext()) {
//			System.out.println("장바구니 메소드 이터레이터는 타고 있어 ");
//			Entry<String, Integer> entry = (Entry)it1.next();
//
//
//			System.out.println(entry.getKey() + " = " + entry.getValue());
//		}
		

	

	}

	// 음료 결제
	public void buydrink() {
		b.setDiscount((int) (b.getTemp() * (a.getCoupon() * 0.1))); //->할인금액
		//int discount = (int) (b.getTemp() * (a.getCoupon() * 0.1)); // 할인금액
		//menusave();
		System.out.println("총금액 : " + b.getTemp());

		// 쿠폰이 1개라면
		/*
		if (a.getCoupon() >= 1) {
			System.out.println("사용가능한 쿠폰이 " + a.getCoupon() + "장 있습니다. 사용하시겠습니까? ");
			String s = sc.nextLine();
			if (s.equals("y")) {
				System.out.println("쿠폰을 사용하여 " + b.getDiscount() + "원 할인되었습니다. ");
				System.out.println("남은 금액인 " + (b.getTemp() - b.getDiscount()) + "원은 등록하신 " + a.getPay() + "로 자동결제 되었습니다. 맛있게 먹엉♡");

			} else if (s.equals("n")) {
				System.out.println("등록하신 " + a.getPay() + "로 자동결제 되었습니다. 맛있게 먹엉♡");
			}

		}*///=> gui 다이얼로그로 만듬 

	}

	public void totalmoney() {
		int price = 0;
		int count = 0;

		// 가격

		for (Entry<String, Integer> entry : dr.entrySet()) {
			// System.out.println("가격 1 if전" + price);
			if (dc.containsKey(entry.getKey())) {
				price = entry.getValue();
				// System.out.println("가격 2 if 후 " + price);
				// System.out.println("가격" + price);
				//break;
			}
		}

		// 수량
		for (String key : eSet1) {
			count = dc.get(key);
			// System.out.println("수량" + count);
			//break;

		}

		/*
		 * // 가격 Set<Entry<String, Integer>> eSet1 = dr.entrySet();
		 * 
		 * Iterator<Entry<String, Integer>> it1 = eSet1.iterator(); while
		 * (it1.hasNext()) {
		 * 
		 * Entry<String, Integer> entry = (Entry) it1.next(); if
		 * (dc.containsKey(entry.getKey())) { price = entry.getValue(); break; } } //수량
		 * Set<Entry<String, Integer>> eSet2 = dc.entrySet();
		 * 
		 * Iterator<Entry<String, Integer>> it2 = eSet2.iterator(); while
		 * (it2.hasNext()) { Entry<String, Integer> entry2 = (Entry) it2.next();
		 * 
		 * if (dc.containsKey(entry2.getKey())) { count = entry2.getValue(); break;
		 * 
		 * } }
		 */

		// System.out.println("가격 :" + price);
		// System.out.println("수량 :" + count);

		int result = price * count;
		b.setTemp(b.getTemp() + result);
		
		System.out.println("테스트 토탈이다" + b.getTemp());
		

		// System.out.println("토탈"+temp);

	}

}
