package com.kh.project.reservation.controller;

public class BoardManager { // 명언 & 보드
	
	public void maxim() {
		
		int num = (int)(Math.random()*10 + 1);
		
		switch(num) {
		
		case 1: 
			System.out.println("창조의 모든 행위는 파괴에서 시작된다. -파블로 피카소-");
			break;
		case 2: 
			System.out.println("절대 어제를 후회하지 마라. 인생은 오늘의 나 안에 있고 내일은 스스로 만드는 것이다. -L.론허바드");
		case 3:
			System.out.println("당신이 할수 있다고 믿든 할수 없다고 믿든 믿는 대로 될것이다.- 헨리 포드");
			break;
		case 4:
			System.out.println("한번의 실패와 영원한 실패를 혼동하지 마라  -F.스콧 핏제랄드");
			break;
		case 5:
			System.out.println("늦게 도착하는 것이 추하게 도착하는 것보다 낫다 -마릴린 먼로");
			break;
		case 6:
			System.out.println("최고에 도달하려면 최저에서 시작하라 -P.시루스");
			break;
		case 7:
			System.out.println("겨울이 오면 봄이 멀지 않으리 -셸리");
			break;	
		case 8:
			System.out.println("자신감 있는 표정을 지으면 자신감이 생긴다 -찰스다윈");
			break;
		case 9:
			System.out.println("그대의 하루 하루를 그대의 마지막 날이라고 생각하라 – 호라티우스");
			break;
		case 10:
			System.out.println("오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아 간다 -앙드레 말로");
			break;	
		}
		
		
		
	}

}
