package com.kh.project.reservation.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MaximManager { // 명언 & 보드
	
	public String maxim() {
		
		int num = (int)(Math.random()*10 + 1);
		String maxim = "";
		switch(num) {
		
		case 1: 
			maxim = "<html>	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;	창조의 모든 행위는 파괴에서 시작된다. <br><br>&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; -파블로 피카소</html>";
			break;
		case 2: 
			maxim = "<html>	 &nbsp; &nbsp; &nbsp; 	&nbsp; &nbsp; &nbsp; &nbsp; 	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 절대 어제를 후회하지 마라. <br>&nbsp; 인생은 오늘의 나 안에 있고 내일은 스스로 만드는 것이다.<br> <br> &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;-L.론허바드</html>";
			break;
		case 3:
			maxim = "<html> &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; 당신이 할수 있다고 믿든 <br> &nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp; 할 수 없다고 믿는대로 될 것이다<br><br> &nbsp; &nbsp; &nbsp;&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;-헨리 포드</html>";
			break;
		case 4:
			maxim = "<html> &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; 한번의 실패와 영원한 실패를 혼동하지 마라 <br><br>&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  -F.스콧 핏제랄드</html>";
			break;
		case 5:
			maxim = "<html>	&nbsp; &nbsp; &nbsp; &nbsp; 늦게 도착하는 것이 추하게 도착하는 것보다 낫다 <br><br>&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;-마릴린 먼로</html>";
			break;
		case 6:
			maxim = "<html>	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 최고에 도달하려면 최저에서 시작하라 <br><br>&nbsp;  &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;-P.시루스</html>";
			break;
		case 7:
			maxim = "<html>	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   &nbsp; &nbsp; &nbsp; &nbsp;   겨울이 오면 봄이 멀지 않으리 <br><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;-셸리</html>";
			break;	
		case 8:
			maxim = "<html> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  자신감 있는 표정을 지으면 자신감이 생긴다 <br><br>&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;-찰스다윈</html>";
			break;
		case 9:
			maxim = "<html>	&nbsp; &nbsp;  그대의 하루 하루를 그대의 마지막 날이라고 생각하라 <br><br>&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;–호라티우스</html>";
			break;
		case 10:
			maxim = "<html>	&nbsp;  오랫동안 꿈을 그리는 사람은 마침내 그 꿈을 닮아 간다 <br><br>&nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;-앙드레 말로</html>";
			
			break;	
		}
		return maxim;
		
	}


}
