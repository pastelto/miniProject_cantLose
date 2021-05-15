package com.kh.project.reservation.model.vo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Book extends JFrame {

		//날짜 및 시간에 따른 이용 가능 좌석 확인 (5/28 기준 한 달 이내)
		//좌석 종류 선택 (1인 칸막이 좌석 (여/남), 오픈형, 스터디룸)
		//스터디룸 -> 최대 4인
		//프로젝터 대여 가능
		private static final String MAY[][] = {{"일","월","화","수","목","금","토"},{" "," "," "," "," "," ","1일"},{"2일","3일","4일","5일","6일","7일","8일"},{"9일","10일","11일","12일","13일","14일","15일"},{"16일","17일","18일","19일","20일","21일","22일"},{"23일","24일","25일","26일","27일","28일","29일"},{"30일","31일"," ", " ", " ", " "," "}};
		private static final String JUNE[][] = {{"일","월","화","수","목","금","토"},{" "," ","1일","2일","3일","4일","5일"},{"6일","7일","8일","9일","10일","11일","12일"},{"13일","14일","15일","16일","17일","18일","19일"},{"20일","21일","22일","23일","24일","25일","26일"},{"27일","28일","29일","30일"," "," "," "},{" "," "," "," "," "," "," "}};
		

		private static final String PSEAT[][] = new String [5][5];
		private static final String OSEAT[][] = new String [5][5];
		private static final String SROOM[][] = new String [4][4];
		private int projector = 4;
		
		public void Booking() {
			JFrame mainFrame1 = new JFrame("예약일 선택 (5월)");
		
			mainFrame1.setSize(360, 600);
		
			mainFrame1.setLayout(new GridLayout(7,7));

			for(int i  = 0 ; i < MAY.length ; i++) {
				for(int j = 0 ; j <MAY[i].length ; j ++) {
					mainFrame1.add(new JButton(MAY[i][j]));
				}
			}
			
			JFrame mainFrame2 = new JFrame("예약일 선택 (6월)");

			mainFrame2.setSize(360, 600);
			
			mainFrame2.setLayout(new GridLayout(7,7));
			
			for(int i  = 0 ; i <JUNE.length ; i++) {
				for(int j = 0 ; j <JUNE[i].length ; j ++) {
						mainFrame2.add(new JButton(JUNE[i][j]));

					
				}
			}


			mainFrame1.setVisible(true);
			mainFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//mainFrame2.setVisible(true);
			//mainFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//각각 찍으면 문제 없음. 각 날짜 선택 이후 마우스 이벤트랑 5-6월 넘어다닐 수 있도록 하는 것, for 문으로 초기화
		
		}
	}


