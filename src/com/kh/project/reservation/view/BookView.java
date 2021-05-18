package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

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
	JTable table = new JTable();
	JFrame booking = new JFrame();
	
	public void Booking5() {
		//메뉴와 연결하고 이건 패널에 부착
		this.setSize(360, 600);
		this.setTitle("예약일 선택 (5월)");
		this.setLayout(new GridLayout(7,7));
		this.setBackground(new Color(249,242,242));

		for(int i  = 0 ; i < may.length ; i++) {
			for(int j = 0 ; j <may[i].length ; j ++) {
				this.add(new JButton(may[i][j]));
			}
		}
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Booking6() {
		this.setSize(360,600);
		this.setTitle("예약일 선택 (6월)");
		this.setLayout(new GridLayout(7,7));
		this.setBackground(new Color(249,242,242));
		
		for(int i  = 0 ; i < june.length ; i++) {
			for(int j = 0 ; j <june[i].length ; j ++) {
				this.add(new JButton(june[i][j]));
			}
		}
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void pkSeat() {
		JButton block = new JButton("1인 칸막이 좌석");
		JButton open = new JButton("1인 오픈형 좌석");
		JButton company = new JButton("스터디룸");
		JButton blank = new JButton(" ");
						//리페인트..패널? 겟텏ㅌ스
		this.setSize(360,600);
		this.setTitle("좌석을 선택하세요.");
		this.setBackground(new Color(249,242,242));
 		
 		block.setLocation(40,170);
 		block.setSize(270,50);

 		open.setLocation(40, 240);
 		open.setSize(270,50);

 		company.setLocation(40, 310);
 		company.setSize(270,50);

 		
 		blank.setLocation(40, 380);
 		blank.setSize(270,50);
 
 		
 		this.add(block);
 		this.add(open);
 		this.add(company); 
 		this.add(blank);
 		
 		this.setVisible(true);
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void forWoman() {
		this.setSize(360,600);
		this.setTitle("1인 칸막이 좌석 (여성전용)");
		this.setLayout(new GridLayout(5,5));
		this.setBackground(new Color(249,242,242));
		
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
				this.add(new JButton(PSEATFF[i][j]));
			}
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void forMan() {
		this.setSize(360,600);
		this.setTitle("1인 칸막이 좌석 (남성전용)");
		this.setLayout(new GridLayout(5,5));
		this.setBackground(new Color(249,242,242));
		
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
				this.add(new JButton(PSEATFM[i][j]));
			}
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void open() {
		this.setSize(360,600);
		this.setTitle("1인 오픈형 좌석");
		this.setLayout(new GridLayout(5,5));
		this.setBackground(new Color(249,242,242));
		
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
				this.add(new JButton(OSEAT[i][j]));
			}
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void studyRoom() { 
		this.setSize(360,600);
		this.setTitle("스터디룸");
		this.setLayout(new GridLayout(2,2));
		this.setBackground(new Color(249,242,242));
		int num = 65;
		
			for(int i = 0 ; i < SROOM.length ; i++) {
				SROOM[i] = (char)(num++) + "(4인실)";
				this.add(new JButton(SROOM[i]));
						
			}
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
				
	}	
	
	public void pj() {
		this.setSize(360,600);
		this.setTitle("주의 사항");
		this.setBackground(new Color(249,242,242));
		
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
		
		this.add(pro);
		this.add(dont);
		this.add(confirm);
		this.add(blank);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
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
	
	public void cbooking() {
		JTable table = new JTable(); // 예약정보 표
		JButton btn1 = new JButton(); // 예약변경 버튼
		JButton btn2 = new JButton(); // 예약취소 버튼
		JButton back = new JButton(); // 뒤로가기 버튼
		
		
		JRadioButton b1= new JRadioButton(" 버 튼 "); // 표 안에 삽입
		ButtonGroup bg = new ButtonGroup();

		// bg.add(b1);
		this.setSize(360, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		panel.setBackground(new Color(249, 242, 242)); 
		
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34,80,54,54);
		
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0,0,360,53);
		
		/*
		JLabel lTitle = new JLabel("예약정보");
		lTitle.setLocation(140, 80);
		lTitle.setSize(100, 54);
		*/
		
		// 폰트 설정
		Font font = new Font("HY견명조", Font.BOLD, 20);
		
		//lTitle.setFont(font);
		
		this.setTitle("예약정보");
		
		//this.add(lTitle);
		this.add(bar);
		this.add(image);
		this.add(b1);
		
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
