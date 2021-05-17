package com.kh.project.reservation.controller;

public class BoardManager { // 명언 & 보드
	
	public String maxim() {
		
		int num = (int)(Math.random()*10 + 1);
		String maxim = "";
		switch(num) {
		
		case 1: 
			maxim = "<html>		창조의 모든 행위는 파괴에서 시작된다. <br>-파블로 피카소</html>";
			break;
		case 2: 
			maxim = "<html>		절대 어제를 후회하지 마라. <br> 인생은 오늘의 나 안에 있고 내일은 스스로 만드는 것이다. <br>-L.론허바드</html>";
			break;
		case 3:
			maxim = "<html>		당신이 할수 있다고 믿든 <br> 할수 없다고 믿든 믿는 대로 될것이다<br>-헨리 포드</html>";
			break;
		case 4:
			maxim = "<html>		한번의 실패와 영원한 실패를 혼동하지 마라 <br>-F.스콧 핏제랄드</html>";
			break;
		case 5:
			maxim = "<html>		늦게 도착하는 것이 추하게 도착하는 것보다 낫다 <br>-마릴린 먼로</html>";
			break;
		case 6:
			maxim = "<html>		최고에 도달하려면 최저에서 시작하라 <br>-P.시루스</html>";
			break;
		case 7:
			maxim = "<html>		겨울이 오면 봄이 멀지 않으리 <br>-셸리</html>";
			break;	
		case 8:
			maxim = "<html>	자신감 있는 표정을 지으면 자신감이 생긴다 <br>-찰스다윈</html>";
			break;
		case 9:
			maxim = "<html>	그대의 하루 하루를 그대의 마지막 날이라고 생각하라 <br>–호라티우스</html>";
			break;
		case 10:
			maxim = "<html>	오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아 간다 <br>-앙드레 말로</html>";
			
			break;	
		}
		System.out.println(maxim);
		return maxim;
		
	}

}
