package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookView extends JFrame implements ActionListener {
	private String may[][] = {{"일","월","화","수","목","금","토"},{" "," "," "," "," "," ","1일"},{"2일","3일","4일","5일","6일","7일","8일"},{"9일","10일","11일","12일","13일","14일","15일"},{"16일","17일","18일","19일","20일","21일","22일"},{"23일","24일","25일","26일","27일","28일","29일"},{"30일","31일"," ", " ", " ", " "," "}};
	private String june[][] = {{"일","월","화","수","목","금","토"},{" "," ","1일","2일","3일","4일","5일"},{"6일","7일","8일","9일","10일","11일","12일"},{"13일","14일","15일","16일","17일","18일","19일"},{"20일","21일","22일","23일","24일","25일","26일"},{"27일","28일","29일","30일"," "," "," "},{" "," "," "," "," "," "," "}};

	//좌석
	private String PSEATFF[][] = new String [5][5]; //1인 칸막이 - 여
	private String PSEATFM[][] = new String [5][5]; //1인 칸막이 - 남
	private String OSEAT[][] = new String [5][5]; // 오픈형
	private String SROOM[] = new String [4]; // 스터디룸
	
	//프로젝터
	private int projector = 4;
	JPanel panel = new JPanel();
	
	/*
	 * 1. 컨테이너 객체 생성함
2. 배치 방식을 컨테이너에 셋팅함(레이아웃 설정)
3. 컴포넌트 객체 생성함
4. 지정된 배치 방식에 따라 컨테이너에 컴포넌트 배치함 5. 컴포넌트에 마우스나 키보드 반응에 대한 이벤트 처리함
	 */
	
	JFrame frame1 = new JFrame();
	JFrame frame2 = new JFrame();
	

	public void Booking() {
		
		
		frame1.setSize(360,600);
		frame1.setTitle("예약일 선택 (5월)");
		frame1.setLayout(new GridLayout(7,7));
		frame1.setBackground(new Color(249,242,242));
		
		for(int i  = 0 ; i < may.length ; i++) {
			for(int j = 0 ; j <may[i].length ; j ++) {
				frame1.add(new JButton(may[i][j]));
			}
		}
		
		frame2.setSize(360,600);
		frame2.setTitle("예약일 선택 (6월)");
 		frame2.setLayout(new GridLayout(7,7));
 		frame2.setBackground(new Color(249,242,242));
		
		for(int i  = 0 ; i < june.length ; i++) {
			for(int j = 0 ; j <june[i].length ; j ++) {
				frame2.add(new JButton(june[i][j]));
			}
		}
				
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void pkSeat() {
		JButton block = new JButton("1인 칸막이 좌석");
		JButton open = new JButton("1인 오픈형 좌석");
		JButton company = new JButton("스터디룸");
		JButton blank = new JButton(" ");
						
		frame1.setSize(360,600);
		frame1.setTitle("좌석을 선택하세요.");
		frame1.setBackground(new Color(249,242,242));
 		
 		block.setLocation(40,170);
 		block.setSize(270,50);
 		//block.setBackground(new Color(188, 26, 135));

 		open.setLocation(40, 240);
 		open.setSize(270,50);
 		//open.setBackground(new Color(188, 26, 135));

 		company.setLocation(40, 310);
 		company.setSize(270,50);
 		//company.setBackground(new Color(188, 26, 135));

 		blank.setLocation(40, 380);
 		blank.setSize(270,50);
 		
 		frame1.add(block);
 		frame1.add(open);
 		frame1.add(company); 
 		frame1.add(blank);

 		frame1.setVisible(true);
 		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public void forWoman() {
		frame1.setSize(360,600);
		frame1.setTitle("1인 칸막이 좌석 (여성전용)");
		frame1.setLayout(new GridLayout(5,5));
		frame1.setBackground(new Color(249,242,242));
		
		int num = 97;
		
		//초기화
		for (int i = 0; i < PSEATFF.length; i++) {
			for (int j = 0; j < PSEATFF[i].length; j++) {
				if (j % 2 == 1) {
					PSEATFF[i][j] = "거리두기";
				} else {
					PSEATFF[i][j] = "a , " + (char)(num++);

				}
			}
		}
		
		//출력
		for(int i = 0 ; i < PSEATFF.length ; i++) {
			for( int j = 0 ; j <PSEATFF[i].length ; j ++) {
				frame1.add(new JButton(PSEATFF[i][j]));
			}
		}
		
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void forMan() {
		frame1.setSize(360,600);
		frame1.setTitle("1인 칸막이 좌석 (남성전용)");
		frame1.setLayout(new GridLayout(5,5));
		frame1.setBackground(new Color(249,242,242));
		
		int num = 97;
		
		//초기화
		for (int i = 0; i < PSEATFM.length; i++) {
			for (int j = 0; j < PSEATFM[i].length; j++) {
				if (j % 2 == 1) {
					PSEATFM[i][j] = "거리두기";
				} else {
					PSEATFM[i][j] = "b, " + (char)(num++);

				}
			}
		}
		
		//출력
		for(int i = 0 ; i < PSEATFM.length ; i++) {
			for( int j = 0 ; j <PSEATFM[i].length ; j ++) {
				frame1.add(new JButton(PSEATFM[i][j]));
			}
		}
		
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void open() {
		frame1.setSize(360,600);
		frame1.setTitle("1인 오픈형 좌석");
		frame1.setLayout(new GridLayout(5,5));
		frame1.setBackground(new Color(249,242,242));
		
		int num = 97;
		
		//초기화
		for (int i = 0; i < OSEAT.length; i++) {
			for (int j = 0; j < OSEAT[i].length; j++) {
				if (j % 2 == 1) {
					OSEAT[i][j] = "거리두기";
				} else {
					OSEAT[i][j] = "c, " + (char)(num++);

				}
			}
		}
		
		//출력
		for(int i = 0 ; i < OSEAT.length ; i++) {
			for( int j = 0 ; j <OSEAT[i].length ; j ++) {
				frame1.add(new JButton(OSEAT[i][j]));
			}
		}
		
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void studyRoom() { 
		frame1.setSize(360,600);
		frame1.setTitle("스터디룸");
		frame1.setLayout(new GridLayout(2,2));
		frame1.setBackground(new Color(249,242,242));
		int num = 65;
		
			for(int i = 0 ; i < SROOM.length ; i++) {
				SROOM[i] = (char)(num++) + "(4인실)";
				frame1.add(new JButton(SROOM[i]));
						
			}
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				
	}	
	
	public void pj() {
		frame1.setSize(360,600);
		frame1.setTitle("주의 사항");
		frame1.setBackground(new Color(249,242,242));
		
		JCheckBox pro = new JCheckBox("프로젝터 대여를 원하실 경우 체크하세요 ");
		pro.setLocation(40, 170);
		pro.setSize(270,50);
		
		JCheckBox dont = new JCheckBox("사용 인원이 4인 이하인 경우 체크하세요 ");
		dont.setLocation(40, 240);
		dont.setSize(270,50);
		
		JButton confirm = new JButton(" 확                       인");
		confirm.setLocation(40, 310);
		confirm.setSize(270,50);
		confirm.setBackground(new Color(188, 26, 135));
		
		JButton blank = new JButton("");
		blank.setLocation(40, 310);
		blank.setSize(270,50);
		
		frame1.add(pro);
		frame1.add(dont);
		frame1.add(confirm);
		frame1.add(blank);

		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				
		
	}
	
	
	public void done() {
		//클릭한 날짜와 좌석에 정상적으로 예약 됨,
		//예약 취소/ 수정 여부 
		//확인
		
		/**
		 * public String Booked() { 
			return  " " +ac.getName() + "님께서 선택하신 일자 [" + bDate + "] 에, \n 예약하신 좌석 [" + cSeat + "] 으로 예약 되었습니다. \n  예약 취소 및 수정은 예약 정보 확인 탭에서 가능합니다."; 
		}
		 */
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
