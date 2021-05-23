package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Book;

public class BookView extends JFrame implements ActionListener {
	
	Account ac = new Account();	
	Book bk = new Book(ac);
	ReservationManager bm = new ReservationManager();

	//calendar
	private String may[][] = {{"****","****", "****","5월", "****","****","****"},{"일","월","화","수","목","금","토"},{" "," "," "," "," "," ","1일"},{"2일","3일","4일","5일","6일","7일","8일"},{"9일","10일","11일","12일","13일","14일","15일"},{"16일","17일","18일","19일","20일","21일","22일"},{"23일","24일","25일","26일","27일","28일","29일"},{"30일","31일"," ", " ", " ", " "," "}};
	private String june[][] = {{"****","****", "****","6월", "****","****","****"},{"일","월","화","수","목","금","토"},{" "," ","1일","2일","3일","4일","5일"},{"6일","7일","8일","9일","10일","11일","12일"},{"13일","14일","15일","16일","17일","18일","19일"},{"20일","21일","22일","23일","24일","25일","26일"},{"27일","28일","29일","30일"," "," "," "}};
	
	//seats
	private String PSEATFF[][] = new String [5][5]; //1인 칸막이 - 여
	private String PSEATFM[][] = new String [5][5]; //1인 칸막이 - 남
	private String OSEAT[][] = new String [5][5]; // 오픈형 
	
	private String yourDate;
	private String yourSeat;
	
	//buttons
	JButton block = new JButton("1인 칸막이 좌석");
	JButton open = new JButton("1인 오픈형 좌석");
	JButton company = new JButton("스터디룸");

	/*
	//checkBox
	JCheckBox pro = new JCheckBox("프로젝터 대여를 원하실 경우 체크하세요 ");
	JCheckBox dont = new JCheckBox("사용 인원이 4인 이하인 경우 체크하세요 ");
	*/
	
	//for color
	JPanel panel = new JPanel();

	public BookView() {
	}
	
	public BookView(Account account) {
	//if(bm.ynTicket() == true) {
		
	JFrame viewDao = new JFrame();
	
	viewDao.setSize(360,600);
	viewDao.setTitle("예약일 선택");
	viewDao.setLocationRelativeTo(null);
	viewDao.setVisible(true);
	viewDao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	panel.setLayout(new GridLayout(15, 16));
	panel.setBackground(new Color(249,242,242));
	
	/* 넣을까 말까?
	for(int i = 0 ; i < may.length ; i ++) {
	for(int j = 0 ; j < may[i].length ; j++) {
		panel.add(new JButton(may[i][j]));

	}
	}
	for(int i = 0 ; i < june.length ; i ++) {
	for(int j = 0 ; j < june[i].length ; j++) {
		panel.add(new JButton(june[i][j])); 
	}
	}
	*/
	
	viewDao.add(panel);
	
	//calendar output@@@@@@@@2
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
	JOptionPane.PLAIN_MESSAGE,
	null,
	selDate,
	"5월 28일"
	);
	viewDao.setVisible(false);
	cSeat();
	/*}else {
		JOptionPane.showMessageDialog(
				null, 
				"이용권 구매 이후 예약 가능합니다.",
				"이용권이 없습니다",
				JOptionPane.PLAIN_MESSAGE, 
				null
				);
			
		new Ticket(); 
	}
	*/
	
	} 


	public void cSeat() { 
	JFrame seat = new JFrame();
	seat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	seat.setVisible(true);
	
	seat.setSize(360,600);
	seat.setLocationRelativeTo(null);
	seat.setTitle("좌석을 선택하세요.");
	panel.setLayout(null);
	panel.setBackground(new Color(249,242,242));

	block.setLocation(40,170);
	block.setSize(270,50);

	open.setLocation(40, 240);
	open.setSize(270,50);

	company.setLocation(40, 310);
	company.setSize(270,50);
	
	seat.add(block);
	seat.add(open);
	seat.add(company); 
	seat.add(panel);

	block.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
	JButton block = (JButton)e.getSource();
	if(block.getText().equals("1인 칸막이 좌석")) {
		seat.setVisible(false);
		
			forWomen();
			//forMen();

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
	
	}

	public void forWomen() {
	JFrame ForWomen = new JFrame();
	ForWomen.setSize(360, 600);
	ForWomen.setTitle("1인 칸막이 좌석 (여성전용) 좌석 배치도");
	panel.setLayout(new GridLayout(5, 5));
	panel.setBackground(new Color(249, 242, 242));
	ForWomen.setLocationRelativeTo(null);
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
	panel.add(new JButton(PSEATFF[i][j]));
	}
	
	ForWomen.add(panel);
	
	}
	
	yourSeat = (String)JOptionPane.showInputDialog(
	null,
	"하단에 보이는 좌석은 선택 가능합니다.",
	"예약 좌석 선택",
	JOptionPane.PLAIN_MESSAGE,
	null,
	bm.getSeatsFF(),
	"1인 칸막이 좌석 (여성전용) a,a"
	);
	ForWomen.setVisible(false);
	done();

	}
	
	public void forMen() {
	JFrame ForMen = new JFrame();
	ForMen.setSize(360, 600);
	ForMen.setTitle("1인 칸막이 좌석 (남성전용) 좌석 배치도");
	panel.setLayout(new GridLayout(5, 5));
	panel.setBackground(new Color(249, 242, 242));
	ForMen.setLocationRelativeTo(null);
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
	panel.add(new JButton(PSEATFM[i][j]));
	}
	}
	ForMen.add(panel);
	
	yourSeat = (String)JOptionPane.showInputDialog(
	null,
	"하단에 보이는 좌석은 선택 가능합니다.",
	"예약 좌석 선택",
	JOptionPane.PLAIN_MESSAGE,
	null,
	bm.getSeatsFM(),
	"1인 칸막이 좌석 (남성전용) b,a"
	);
	ForMen.setVisible(false);
	done();
	

	}
	
	public void open() {
	JFrame open = new JFrame();
	open.setSize(360, 600);
	open.setTitle("1인 오픈형 좌석, 좌석 배치도");
	panel.setLayout(new GridLayout(5, 5));
	panel.setBackground(new Color(249, 242, 242));
	open.setLocationRelativeTo(null);
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
	panel.add(new JButton(OSEAT[i][j]));
	}
	}
	open.add(panel);
	
	yourSeat = (String)JOptionPane.showInputDialog(
	null,
	"하단에 보이는 좌석은 선택 가능합니다.",
	"예약 좌석 선택",
	JOptionPane.PLAIN_MESSAGE,
	null,
	bm.getSeatsFO(),
	"1인 오픈형 좌석 c,a"
	);
	open.setVisible(false);
	done();

	}

	public void studyRoom() {
	JFrame study = new JFrame();
	study.setSize(360, 600);
	study.setTitle("스터디룸 좌석 배치도");
	study.setLocationRelativeTo(null);
	panel.setLayout(null);
	panel.setBackground(new Color(249,242,242));
	
	/*
	JButton A = new JButton("스터디룸 A");
	JButton B = new JButton("스터디룸 B");
	JButton C = new JButton("스터디룸 C");
	JButton D = new JButton("스터디룸 D");
	
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
	*/
	study.add(panel);
	study.setVisible(true);
	study.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	yourSeat = (String)JOptionPane.showInputDialog(
	null,
	"예약 하고자 하는 방을 선택하세요.",
	"스터디룸 예약",
	JOptionPane.PLAIN_MESSAGE,
	null,
	bm.getRooms(),
	"스터디룸 A (최대 4인)"
	);
	study.setVisible(false);
	done();
	}
	
	/*public void pj() {
	JFrame pj = new JFrame();
	pj.setSize(360, 600);
	pj.setTitle("주의 사항");
	pj.setLayout(null);
	pj.setBackground(new Color(249, 242, 242));
	 

	pj.setVisible(true);
	pj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	pro.setLocation(40, 170);
	pro.setSize(270, 50); 
	 
	dont.setLocation(40, 240);
	dont.setSize(270, 50);

	 
	JButton confirm = new JButton("확                       인");
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
	if(confirm.getText().equals("확                       인")) {
	pj.setVisible(false);
	done();
	}/*else {
	JOptionPane.showMessageDialog(
	null,
	"4인 초과는 예약하실 수 없습니다.",
	"경고",
	JOptionPane.ERROR_MESSAGE

	);


	}*//*
	}

	});

	}
	*/
	
	public void done() {
		bk.setYourDate(yourDate);
		bk.setYourSeat(yourSeat);
		
	JOptionPane.showMessageDialog(
	null,
	"선택하신 일자 [ 2021년 " + bk.getYourDate() + " ] 에, \n 예약하신 좌석 [ " + bk.getYourSeat() + " ] 으로 예약 되었습니다. \n 예약 취소 및 수정은 예약 정보 확인 탭에서 가능합니다.", 
	"예약 완료!!",
	JOptionPane.PLAIN_MESSAGE
	);
	
	//new ReservationManager();
	new MenuChoice(ac);
	}
	
	/*
	public void checkBooking() {
		try {
			//!yourSeat.equals(null)&&!yourDate.equals(null)
				lookUp();
			
		}catch(NullPointerException e){
				JOptionPane.showMessageDialog(null, 
						"예약 이후 예약정보 확인이 가능합니다.", 
						"예약 정보가 없습니다",
						JOptionPane.PLAIN_MESSAGE,
					null);
				new MenuChoice(ac);

			}
		}
	*/	
	
	JFrame bSearch = new JFrame();

	public void checkBooking() {

		JButton modify = new JButton("예약 변경"); 
		JButton cancel = new JButton("예약 취소"); 
		JButton prev = new JButton("< 뒤로가기");  
		
		bSearch.setSize(360, 600);
		panel.setLayout(null);
		panel.setBackground(new Color(249, 242, 242));
		bSearch.setTitle("예약확인");
		bSearch.setLocationRelativeTo(null);
		
		bSearch.setVisible(true);
		bSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34, 80, 54, 54);
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);

		JLabel bInfo = new JLabel("<html>" + ac.getName() + "님께서는 [" + bk.getYourDate() + "] 에" + "<br>" + "[" + bk.getYourSeat()
				+ "] 좌석을" + "<br>" + "예약하셨습니다.</html>");
		bInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		bInfo.setSize(270, 100);
		bInfo.setLocation(70, 125);

		prev.setSize(70, 40);
		prev.setLocation(10,500);
		
		modify.setSize(270, 50);
		modify.setLocation(40, 240);

		cancel.setSize(270, 50);
		cancel.setLocation(40, 310);

		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		JLabel lTitle = new JLabel("예약정보");
		lTitle.setLocation(140, 80);
		lTitle.setSize(100, 54);
		lTitle.setFont(font);
		
		panel.add(prev);
		panel.add(lTitle);
		panel.add(bar);
		panel.add(image);
		panel.add(bInfo);
		panel.add(modify);
		panel.add(cancel);
		bSearch.add(panel);
		

		modify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton modify = (JButton) e.getSource();
				if (modify.getText().equals("예약 변경")) {
					JOptionPane.showMessageDialog(null, "기존 예약은 삭제되었으며 재 예약을 위해 예약화면으로 돌아갑니다.", "예약 변경",
							JOptionPane.PLAIN_MESSAGE);
					bSearch.setVisible(false);
					bk.setYourDate(null);
					bk.setYourSeat(null);
					new BookView(ac);

				}
			}

		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton cancel = (JButton) e.getSource();
				if (cancel.getText().equals("예약 취소")) {
					JOptionPane.showMessageDialog(null, "예약 취소가 완료되었습니다.", "예약 취소", JOptionPane.PLAIN_MESSAGE);
					bSearch.setVisible(false);
					bk.setYourDate(null);
					bk.setYourSeat(null);
					new MenuChoice(ac);
				}
			}

		});
		
		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton prev = (JButton) e.getSource();
				if(prev.getText().equals("< 뒤로가기")){
				new MenuChoice(ac);

				}
				
			}
			
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub

	}
	
}