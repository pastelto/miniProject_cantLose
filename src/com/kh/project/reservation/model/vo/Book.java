package com.kh.project.reservation.model.vo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Book extends JFrame implements ActionListener{
	
	 //객체 가져오기	
	private Account ac = new Account();
		
	//달력
	private static final String MAY[][] = {{"일","월","화","수","목","금","토"},{" "," "," "," "," "," ","1일"},{"2일","3일","4일","5일","6일","7일","8일"},{"9일","10일","11일","12일","13일","14일","15일"},{"16일","17일","18일","19일","20일","21일","22일"},{"23일","24일","25일","26일","27일","28일","29일"},{"30일","31일"," ", " ", " ", " "," "}};
	private static final String JUNE[][] = {{"일","월","화","수","목","금","토"},{" "," ","1일","2일","3일","4일","5일"},{"6일","7일","8일","9일","10일","11일","12일"},{"13일","14일","15일","16일","17일","18일","19일"},{"20일","21일","22일","23일","24일","25일","26일"},{"27일","28일","29일","30일"," "," "," "},{" "," "," "," "," "," "," "}};

	//좌석
	private static final String PSEATFF[][] = new String [5][5]; //1인 칸막이 - 여
	private static final String PSEATFM[][] = new String [5][5]; //1인 칸막이 - 남
	private static final String OSEAT[][] = new String [5][5]; // 오픈형
	private static final String SROOM[] = new String [4]; // 스터디룸
	private static String bDate; //예약일
	private static String cSeat; //선택한 좌석 
	private Scanner sc = new Scanner(System.in);
	
	//프로젝터
	private int projector = 4;
		
		//생성자
		public Book() {}
		
		
		//달력 출력
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
		//선택 이후 bdate에 담기
		

		mainFrame1.setVisible(true);
		mainFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//mainFrame2.setVisible(true);
		//mainFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//각각 찍으면 문제 없음. 각 날짜 선택 이후 마우스 이벤트랑 5-6월 넘어다닐 수 있도록 하는 것, for 문으로 초기화
	
		}

		//예약일 선택 후 좌석 선택
		public void yourSeat() {
			System.out.println("*********** 좌석을 선택하세요 *********** ");
			System.out.println("1. 1인 칸막이 좌석");
			System.out.println("2. 1인 오픈형 좌석");
			System.out.println("3. 스터디룸");
			System.out.println("************************************ ");
			System.out.println();
			
			System.out.println("--------- 알립니다 -----------");
			System.out.println("사회적 거리두기를 위해 1인석 스터디룸의 최대 수용 인원은 13인 입니다.");
			System.out.println("스터디룸의 최대 수용 인원은 4인입니다.");
			System.out.println("---------------------------");
			System.out.println();

			
			System.out.print("선택하실 좌석 유형을 입력해주세요 : (번호만) ");
			int num = sc.nextInt();

			switch(num) {
			
			case 1:
				if(ac.getGender() == 'F' || ac.getGender() == 'f') {
					pSeatForWoman();
				}else {
					pSeatForMan();
				}
				
				break;
			case 2:
				oSeat();
				break;
			case 3:
				studyRoom();
				break;
			default : 
				break;
			
			}
		}

		//칸막이, 여성
		public void pSeatForWoman() {  
			System.out.println("******** 여성 전용 1인 칸막이 좌석 입니다. *********");
			System.out.println("*** 사회적 거리두기를 위해 연석 예약이 불가능합니다. ***");
			System.out.println();
			int num = 97;
			for (int i = 0; i < PSEATFF.length; i++) {
				for (int j = 0; j < PSEATFF[i].length; j++) {
					if (j % 2 == 1) {
						PSEATFF[i][j] = "[ 예약불가 ]";
						System.out.print(PSEATFF[i][j] + " ");

					} else {
						PSEATFF[i][j] = "[ a, " + (char)(num++) + " ]";
						System.out.print(PSEATFF[i][j] + " ");

					}
				}
				System.out.println();

			} 
			
			System.out.println();
			System.out.println("예약하실 좌석의 번호를 입력해주세요. (,포함) ");
			System.out.println("'back'을 입력하시면 이전 창으로 돌아갑니다.");
			String pick = sc.nextLine();
			
			if(pick.equalsIgnoreCase("back")) {
				yourSeat();
			}else {
				for (int i = 0; i < PSEATFF.length; i++) {
					for (int j = 0; j < PSEATFF[i].length; j++) {
						if(PSEATFF[i][j].contains(pick)) {
							//PSEATFF[i][j] = getName + "님이 예약하신 좌석입니다.";
						}
					}
				}
			}
			
			//선택 이후 Cseat에 담기
			cSeat = pick;
			Booked();



			
		}
		
		
		//칸막이, 남성
		public void pSeatForMan() {	
			System.out.println("******** 남성 전용 1인 칸막이 좌석 입니다. *********");
			System.out.println("*** 사회적 거리두기를 위해 연석 예약이 불가능합니다. ***");
			System.out.println();
			int num = 97;
			for (int i = 0; i < PSEATFM.length; i++) {
				for (int j = 0; j < PSEATFM[i].length; j++) {
					if (j % 2 == 1) {
						PSEATFM[i][j] = "[ 예약불가 ]";
						System.out.print(PSEATFM[i][j] + " ");

					} else {
						PSEATFM[i][j] = "[ b" + ", " + (char)(num++) + " ]";
						System.out.print(PSEATFM[i][j] + " ");

					}
				}
				System.out.println();

			} 
			
			System.out.println();
			System.out.println("예약하실 좌석의 번호를 입력해주세요. (,포함) ");
			System.out.println("'back'을 입력하시면 이전 창으로 돌아갑니다.");
			String pick = sc.nextLine();
			
			if(pick.equalsIgnoreCase("back")) {
				yourSeat();
			}else {
				for (int i = 0; i < PSEATFM.length; i++) {
					for (int j = 0; j < PSEATFM[i].length; j++) {
						if(PSEATFM[i][j].contains(pick)) {
							//PSEATFM[i][j] = getName + "님이 예약하신 좌석입니다.";
						}
					}
				}
			}

			cSeat = pick;
			Booked();

		}
		
		
		//오픈형
		public void oSeat() {	
			System.out.println("************ 1인 오픈형 좌석 입니다. ************");
			System.out.println("*** 사회적 거리두기를 위해 연석 예약이 불가능합니다. ***");
			System.out.println();
			int num = 97;
			for (int i = 0; i < OSEAT.length; i++) {
				for (int j = 0; j < OSEAT[i].length; j++) {
					if (j % 2 == 1) {
						OSEAT[i][j] = "[ 예약불가 ]";
						System.out.print(OSEAT[i][j] + " ");

					} else {
						OSEAT[i][j] = "[ c" + ", " + (char)(num++) + " ]";
						System.out.print(OSEAT[i][j] + " ");

					}
				}
				System.out.println();
				

			} 
			
			System.out.println();
			System.out.println("예약하실 좌석의 번호를 입력해주세요. (,포함) ");
			System.out.println("'back'을 입력하시면 이전 창으로 돌아갑니다.");
			String pick = sc.nextLine();
			
			if(pick.equalsIgnoreCase("back")) {
				yourSeat();
			}else {
				for (int i = 0; i < OSEAT.length; i++) {
					for (int j = 0; j < OSEAT[i].length; j++) {
						if(OSEAT[i][j].contains(pick)) {
							//OSEAT[i][j] = getName + "님이 예약하신 좌석입니다.";
						}
					}
				}
			}
			cSeat = pick;
			Booked();


		}
		
		
		//스터디룸
		public void studyRoom() { 
			int count = 4; 
			System.out.println("현재 선택 가능한 스터디 룸은 " + count + "개 입니다.");
			//SROOM
			for(int i = 0 ; i < SROOM.length ; i++) {
				SROOM[i] = (char)(65+i) + " ";
					
			}
			System.out.print("선택하실 스터디룸의 번호를 입력하세요 : ");
			String str = sc.nextLine();
			
			if(!str.equals(null)) {
				for(int i = 0 ; i < SROOM.length ; i++) {
					if(SROOM[i].contains(str)) {
						System.out.println(SROOM[i]= ac.getName() + "님께서 예약하신 좌석입니다.");
						
					}
				}
			}	
			
			System.out.println("프로젝터를 대여하시겠습니까? (y/n)");
			String yn = sc.nextLine();
			if(yn.contains("y")) {
				projector--;
			}
			cSeat = str;
			Booked();

			
		}
		
		
		//예약완료확인(창)
		public String Booked() { 
			return  " " +ac.getName() + "님께서 선택하신 일자 [" + bDate + "] 에, \n 예약하신 좌석 [" + cSeat + "] 으로 예약 되었습니다. \n  예약 취소 및 수정은 예약 정보 확인 탭에서 가능합니다."; 
		}

		
		
		//액션리스너~_~
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}



