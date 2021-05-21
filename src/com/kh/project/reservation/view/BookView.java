package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import com.kh.project.reservation.model.vo.Account;

public class BookView extends JFrame implements ActionListener {	
	Account ac = new Account();
	
	//calendar
	private String may[][] = {{"****","****", "****","5월", "****","****","****"},{"일","월","화","수","목","금","토"},{" "," "," "," "," "," ","1일"},{"2일","3일","4일","5일","6일","7일","8일"},{"9일","10일","11일","12일","13일","14일","15일"},{"16일","17일","18일","19일","20일","21일","22일"},{"23일","24일","25일","26일","27일","28일","29일"},{"30일","31일"," ", " ", " ", " "," "}};
	private String june[][] = {{"****","****", "****","6월", "****","****","****"},{"일","월","화","수","목","금","토"},{" "," ","1일","2일","3일","4일","5일"},{"6일","7일","8일","9일","10일","11일","12일"},{"13일","14일","15일","16일","17일","18일","19일"},{"20일","21일","22일","23일","24일","25일","26일"},{"27일","28일","29일","30일"," "," "," "}};

	//seats
	private String PSEATFF[][] = new String [5][5]; //1인 칸막이 - 여
	private String PSEATFM[][] = new String [5][5]; //1인 칸막이 - 남
	private String OSEAT[][] = new String [5][5]; // 오픈형	
	
	//dropdowns
	private String yourDate;
	private String yourSeat;
	
	//buttons
	JButton block = new JButton("1인 칸막이 좌석");
	JButton open = new JButton("1인 오픈형 좌석");
	JButton company = new JButton("스터디룸");
		
	public BookView() {
		
	}
	
	public void monAndSeat() {
		JFrame mon = new JFrame();
		mon.setSize(360,600);
		mon.setBackground(new Color(249,242,242));
		mon.setTitle("예약일 선택");
		mon.setLayout(new GridLayout(15, 16));
		
		for(int i = 0 ; i < may.length ; i ++) {
			for(int j = 0 ; j < may[i].length ; j++) {
				mon.add(new JButton(may[i][j]));
				
			}
		}
		for(int i = 0 ; i <	june.length ; i ++) {
			for(int j = 0 ; j < june[i].length ; j++) {
				mon.add(new JButton(june[i][j])); 
			}
		}
	
		mon.setVisible(true);
		mon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//calendar output
		Date now = new Date();
		
		String[] selDate = { "5월 28일", "5월 29일", "5월 30일", "5월 31일", "6월 1일",
				"6월 2일", "6월 3일", "6월 4일", "6월 5일", "6월 6일" ,"6월 7일", "6월 8일",
				"6월 9일","6월 10일","6월 11일","6월 12일","6월 13일","6월 14일","6월 15일",
				"6월 16일","6월 17일","6월 18일","6월 19일","6월 20일","6월 21일","6월 22일",
				"6월 23일","6월 24일","6월 25일","6월 26일","6월 27일"
		};
		
		yourDate = (String)JOptionPane.showInputDialog(
				null,
				"오늘 기준으로 하단에 보이는 날짜만 선택이 가능합니다.",
				"예약일 선택",
				JOptionPane.INFORMATION_MESSAGE,
				null,
				selDate,
				"5월 28일"
				);
		mon.setVisible(false);
		cSeat();
	}	
		//drop down
		
	public void cSeat() {	
		JFrame seat = new JFrame();
 		seat.setVisible(true);
 		seat.setSize(360,600);
		seat.setTitle("좌석을 선택하세요.");
		seat.setBackground(new Color(249,242,242));

 		seat.add(block);
 		seat.add(open);
 		seat.add(company); 
		seat.setLayout(null);
		
		block.setLocation(40,170);
 		block.setSize(270,50);
 		
 		open.setLocation(40, 240);
 		open.setSize(270,50);
 		
 		company.setLocation(40, 310);
 		company.setSize(270,50);
 		
 		
 		block.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton block = (JButton)e.getSource();
 				if(block.getText().equals("1인 칸막이 좌석")) {
 					seat.setVisible(false);
 					forWomen();
 					
 				} 				
			}
 		
 		
 		});
 		
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton open = (JButton) e.getSource();
				if (open.getText().equals("1인 오픈형 좌석")) {
					seat.setVisible(false);
					open();

				}
			}

		});
		
		company.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton company = (JButton) e.getSource();
				if (company.getText().equals("스터디룸")) {
					seat.setVisible(false);
					studyRoom();
				}
			}

		});
 		seat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	public void forWomen() {
		JFrame ForWomen = new JFrame();
		ForWomen.setSize(360, 600);
		ForWomen.setTitle("1인 칸막이 좌석 (여성전용)");
		ForWomen.setLayout(new GridLayout(5, 5));
		ForWomen.setBackground(new Color(249, 242, 242));
		
		ForWomen.setVisible(true);
		ForWomen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int num = 97;

		// 초기화
		for (int i = 0; i < PSEATFF.length; i++) {
			for (int j = 0; j < PSEATFF[i].length; j++) {
				if (j % 2 == 1) {
					PSEATFF[i][j] = "거리두기";
				} else {
					PSEATFF[i][j] = "a , " + (char) (num++);

				}
			}
		}

		// 출력
		for (int i = 0; i < PSEATFF.length; i++) {
			for (int j = 0; j < PSEATFF[i].length; j++) {
				ForWomen.add(new JButton(PSEATFF[i][j]));
			}
		}
		String[] seats = { "a,a","a,b","a,c","a,d","a,e","a,f","a,g",
				"a,h","a,i","a,j","a,k","a,l","a,m","a,n","a,o"
		};
		
		yourSeat = (String)JOptionPane.showInputDialog(
				null,
				"하단에 보이는 좌석은 선택 가능합니다.",
				"예약 좌석 선택",
				JOptionPane.INFORMATION_MESSAGE,
				null,
				seats,
				"a,a"
				);
		ForWomen.setVisible(false);
		done();
		
	}

	public void forMen() {
		JFrame ForMen = new JFrame();

		ForMen.setSize(360, 600);
		ForMen.setTitle("1인 칸막이 좌석 (남성전용)");
		ForMen.setLayout(new GridLayout(5, 5));
		ForMen.setBackground(new Color(249, 242, 242));
		ForMen.setVisible(true);
		ForMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		int num = 97;

		// 초기화
		for (int i = 0; i < PSEATFM.length; i++) {
			for (int j = 0; j < PSEATFM[i].length; j++) {
				if (j % 2 == 1) {
					PSEATFM[i][j] = "거리두기";
				} else {
					PSEATFM[i][j] = "b, " + (char) (num++);

				}
			}
		}

		// 출력
		for (int i = 0; i < PSEATFM.length; i++) {
			for (int j = 0; j < PSEATFM[i].length; j++) {
				ForMen.add(new JButton(PSEATFM[i][j]));
			}
		}
		String[] seats = { "b,a","b,b","b,c","b,d","b,e","b,f","b,g",
				"b,h","b,i","b,j","b,k","b,l","b,m","b,n","b,o"
		};
		
		yourSeat = (String)JOptionPane.showInputDialog(
				null,
				"하단에 보이는 좌석은 선택 가능합니다.",
				"예약 좌석 선택",
				JOptionPane.INFORMATION_MESSAGE,
				null,
				seats,
				"b,a"
				);
		ForMen.setVisible(false);
		done();

		
	}

	public void open() {
		JFrame open = new JFrame();
		open.setSize(360, 600);
		open.setTitle("1인 오픈형 좌석");
		open.setLayout(new GridLayout(5, 5));
		open.setBackground(new Color(249, 242, 242));
		open.setVisible(true);
		open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int num = 97;

		// 초기화
		for (int i = 0; i < OSEAT.length; i++) {
			for (int j = 0; j < OSEAT[i].length; j++) {
				if (j % 2 == 1) {
					OSEAT[i][j] = "거리두기";
				} else {
					OSEAT[i][j] = "c, " + (char) (num++);

				}
			}
		}

		// 출력
		for (int i = 0; i < OSEAT.length; i++) {
			for (int j = 0; j < OSEAT[i].length; j++) {
				open.add(new JButton(OSEAT[i][j]));
			}
		}

		String[] seats = { "c,a","c,b","c,c","c,d","c,e","c,f","c,g",
				"c,h","c,i","c,j","c,k","c,l","c,m","c,n","c,o"
		};
		
		yourSeat = (String)JOptionPane.showInputDialog(
				null,
				"하단에 보이는 좌석은 선택 가능합니다.",
				"예약 좌석 선택",
				JOptionPane.INFORMATION_MESSAGE,
				null,
				seats,
				"c,a"
				);
		open.setVisible(false);
		done();
		

	}

	public void studyRoom() {
		JFrame study = new JFrame();
		study.setSize(360, 600);
		study.setTitle("스터디룸");
		study.setBackground(new Color(249,242,242));

		JButton A = new JButton("A");
		JButton B = new JButton("B");
		JButton C = new JButton("C");
		JButton D = new JButton("D");

		A.setLocation(40,100);
 		A.setSize(270,50);
 		
 		B.setLocation(40, 170);
 		B.setSize(270,50);
 		
 		C.setLocation(40, 240);
 		C.setSize(270,50);
		
 		D.setLocation(40, 310);
 		D.setSize(270,50);
		
 		study.add(A);
 		study.add(B);
 		study.add(C); 
 		study.add(D);
 		study.setLayout(null);
		
		study.setVisible(true);
		study.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] rooms = { "A","B","C","D"
		};
		
		yourSeat = (String)JOptionPane.showInputDialog(
				null,
				"예약 하고자 하는 방을 선택하세요.",
				"스터디룸 예약",
				JOptionPane.INFORMATION_MESSAGE,
				null,
				rooms,
				"A"
				);
		 study.setVisible(false);
		 pj();
	}

	public void pj() {
		JFrame pj = new JFrame();
		pj.setSize(360, 600);
		pj.setTitle("주의 사항");
		pj.setBackground(new Color(249, 242, 242));
		pj.setLayout(null);
		
		pj.setVisible(true);
		pj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JCheckBox pro = new JCheckBox("프로젝터 대여를 원하실 경우 체크하세요 ");
		pro.setLocation(40, 170);
		pro.setSize(270, 50);	

		JCheckBox dont = new JCheckBox("사용 인원이 4인 이하인 경우 체크하세요 ");
		dont.setLocation(40, 240);
		dont.setSize(270, 50);

		JButton confirm = new JButton("확                       인");
		confirm.setLocation(40, 310);
		confirm.setSize(270, 50);
		confirm.setBackground(new Color(188, 26, 135));

		pj.add(pro);
		pj.add(dont);
		pj.add(confirm);
		//dont 가 체크되어 있지 않으면 예약할 수 없고
		//pro 가 체크되어 있지 않으면 프로젝터를 -- 하지 말기.
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton confirm = (JButton)e.getSource();
				if(confirm.getText().equals("확                       인")) {
					pj.setVisible(false);
					done();
				}
			}
			
		});
	}

	public void done() {
		JOptionPane.showMessageDialog(
				null,
				" " + ac.getName() + "님께서 선택하신 일자 [" + yourDate + "] 에, \n 예약하신 좌석 [" + yourSeat + "] 으로 예약 되었습니다. \n 예약 취소 및 수정은 예약 정보 확인 탭에서 가능합니다.",		
				"예약 완료!!",
				JOptionPane.WARNING_MESSAGE
				);
		//메인화면으로
	}

	public void cbooking() {
		JTable table = new JTable(); // 예약정보 표
		JButton btn1 = new JButton(); // 예약변경 버튼
		JButton btn2 = new JButton(); // 예약취소 버튼
		JButton back = new JButton(); // 뒤로가기 버튼

		JRadioButton b1 = new JRadioButton(" 버 튼 "); // 표 안에 삽입
		ButtonGroup bg = new ButtonGroup();

		// bg.add(b1);
		this.setSize(360, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(new Color(249, 242, 242));

		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34, 80, 54, 54);

		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);

		/*
		 * JLabel lTitle = new JLabel("예약정보"); lTitle.setLocation(140, 80);
		 * lTitle.setSize(100, 54);
		 */

		// 폰트 설정
		Font font = new Font("HY견명조", Font.BOLD, 20);

		// lTitle.setFont(font);

		this.setTitle("예약정보");

		// this.add(lTitle);
		this.add(bar);
		this.add(image);
		this.add(b1);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}