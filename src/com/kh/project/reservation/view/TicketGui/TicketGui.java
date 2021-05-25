package com.kh.project.reservation.view.TicketGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.TicketManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;
import com.kh.project.reservation.view.PrintGui.PrintServiceGui;

public class TicketGui extends JFrame {
	JLabel title = new JLabel("이용권"); // 타이틀
	JLabel oneSeat = new JLabel("1인 좌석 : "); // 1인좌석 :
	JLabel stdRoom = new JLabel("스터디룸 : "); // 스터디룸 :
	JLabel message1 = new JLabel("*이용권 구매안내* ");
	JLabel message2 = new JLabel("1인좌석 1매 5000원(구매수량에 따른 할인률적용)");
	JLabel message3 = new JLabel("스터디룸 1시간 이용시 10000원");
	JLabel message4 = new JLabel("스터디룸 최대 4인까지 이용가능");
	JTextField oneSeatT = new JTextField(); // 1인좌석 수량 입력
	JTextField stdRoomT = new JTextField(); // 스터디룸 수량 입력
	JButton oneSeatP = new JButton("구매"); // 1인좌석 구매버튼
	JButton stdRoomP = new JButton("구매"); // 스터디룸 구매버튼
	JButton back = new JButton("뒤로"); // 뒤로
	JPanel t = new JPanel();
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	Font font1 = new Font("맑은 고딕", Font.BOLD, 10);
	Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
	Font font3 = new Font("맑은 고딕", Font.BOLD, 20);

	TicketManager tm = new TicketManager();

	public TicketGui(Account account) {

		super("이용권 구매");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		t.setBackground(new Color(249, 242, 242)); // 배경색 설정
		t.setLayout(null);
		t.setSize(getMaximumSize());

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("이용권 구매                        ");
		bar.setFont(font3);
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel name = new JLabel(account.getName() + " 님의"); // 이름
		name.setLocation(130, 120);
		name.setFont(font3); // 글씨 크기 변경
		name.setSize(270, 54);

		// 사람이미지
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34, 120, 85, 54);

		// 티켓정보 - account에서 가지고 온 이용권 정보 보여주기
		String str1 = Integer.toString(account.getOneSeat());
		String str2 = Integer.toString(account.getStdRoom());
		JLabel oneSeatInfo = new JLabel("보유한 1인좌석  이용권: " + str1 + " 매");// 내 현재 1인석 수량
		JLabel strInfo = new JLabel("보유한 스터디룸 이용권: " + str2 + " 매");// 내 현재 스터디룸 수량

		oneSeatInfo.setLocation(60, 150);
		oneSeatInfo.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		oneSeatInfo.setFont(font2);
		oneSeatInfo.setSize(300, 100);

		strInfo.setLocation(60, 180);
		strInfo.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		strInfo.setFont(font2);
		strInfo.setSize(300, 100);

		// 1인좌석:
		oneSeat.setLocation(50, 270);
		oneSeat.setBackground(new Color(248, 248, 248));
		oneSeat.setSize(80, 30);
		oneSeat.setFont(font2);

		// 1인좌석 수량입력
		oneSeatT.setLocation(130, 270);
		oneSeatT.setBackground(new Color(248, 248, 248));
		oneSeatT.setSize(80, 30);
		oneSeatT.setToolTipText("티켓 수량 입력");

		// 1인좌석 구매버튼
		oneSeatP.setLocation(220, 270);
		oneSeatP.setBackground(new Color(220, 118, 112));
		oneSeatP.setForeground(Color.white);
		oneSeatP.setFont(font);
		oneSeatP.setFocusPainted(false);
		oneSeatP.setSize(60, 30);

		// 스터디룸 :
		stdRoom.setLocation(50, 310);
		stdRoom.setBackground(new Color(248, 248, 248));
		stdRoom.setSize(80, 30);
		stdRoom.setFont(font2);

		// 스터디룸 수량 입력
		stdRoomT.setLocation(130, 310);
		stdRoomT.setBackground(new Color(248, 248, 248));
		stdRoomT.setSize(80, 30);
		stdRoomT.setToolTipText("티켓 수량 입력");

		// 스터디룸 구매버튼
		stdRoomP.setLocation(220, 310);
		stdRoomP.setBackground(new Color(220, 118, 112));
		stdRoomP.setForeground(Color.white);
		stdRoomP.setFont(font);
		stdRoomP.setFocusPainted(false);
		stdRoomP.setSize(60, 30);

		// 메세지1
		message1.setLocation(130, 330);
		message1.setBackground(new Color(248, 248, 248));
		message1.setSize(300, 100);
		message1.setFont(font1);

		// 메세지2
		message2.setLocation(50, 350);
		message2.setBackground(new Color(248, 248, 248));
		message2.setSize(300, 100);
		message2.setFont(font1);

		// 메세지3
		message3.setLocation(50, 370);
		message3.setBackground(new Color(248, 248, 248));
		message3.setSize(450, 100);
		message3.setFont(font1);

		// 메세지4
		message4.setLocation(50, 390);
		message4.setBackground(new Color(248, 248, 248));
		message4.setSize(450, 100);
		message4.setFont(font1);

		// 이전 버튼
		back.setLocation(40, 500);
		back.setBackground(new Color(220, 118, 112));
		back.setFocusPainted(false);
		back.setForeground(Color.white);
		back.setFont(font);
		back.setSize(80, 35);

		oneSeatP.addMouseListener(new MouseAdapter() { // 1인석
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					tm.oneSeatP(account, Integer.valueOf(oneSeatT.getText()));
					new TicketGui(account);
					setVisible(false);
				}
			}
		});

		oneSeatP.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				oneSeatP.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				oneSeatP.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});

		stdRoomP.addMouseListener(new MouseAdapter() { // 스터디룸
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					tm.strPrice(account, Integer.valueOf(stdRoomT.getText()));
					new TicketGui(account);
					setVisible(false);
				}
			}
		});

		stdRoomP.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				stdRoomP.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				stdRoomP.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new MenuChoice(account); // 메인메뉴
					setVisible(false);
				}
			}
		});

		back.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				back.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});

		t.add(bar);
		t.add(title);
		t.add(image);
		t.add(name);
		t.add(oneSeatInfo);
		t.add(strInfo);
		t.add(oneSeat);
		t.add(oneSeatT);
		t.add(stdRoom);
		t.add(stdRoomT);
		t.add(oneSeatP);
		t.add(stdRoomP);
		t.add(message1);
		t.add(message2);
		t.add(message3);
		t.add(message4);
		t.add(back);
		this.add(t);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
