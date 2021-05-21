
package com.kh.project.reservation.view;

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

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.Board.MemoList;
import com.kh.project.reservation.view.PrintGui.PrintServiceGui;
import com.kh.project.reservation.view.TicketGui.TicketGui;


public class MenuChoice extends JFrame {

	JLabel bar = new JLabel();
	JPanel mc = new JPanel();
	JButton b1 = new JButton("예		약");
	JButton b2 = new JButton("이용권 구매");
	JButton b3 = new JButton("음료 구매");
	JButton b4 = new JButton("프린트 서비스");
	JButton b5 = new JButton("예약정보 확인");
	JButton b6 = new JButton("내 정보");
	JButton b7 = new JButton("체크인 / 체크아웃");
	JButton b8 = new JButton("내 노트");
	JButton b9 = new JButton("로그아웃");
	
	

	
	public MenuChoice(Account account) {

		// Menu 기본
		super("MenuChoice");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		mc.setBackground(new Color(249, 242, 242));
		mc.setLayout(null);
		mc.setSize(360, 600);

		// 메뉴 타이틀
		this.setTitle("MENU");

		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("MENU  "); // 글씨색 바꾸고 싶다..
		bar.setHorizontalTextPosition(JLabel.CENTER); 
		bar.setVerticalTextPosition(JLabel.CENTER);
		
		JLabel image = new JLabel(new ImageIcon("images/logo.png"));
		image.setLocation(10, 300);
		image.setSize(100, 100);
		
		// 메뉴 버튼		
		b1.setBounds(10, 80, 150, 50);
		b2.setBounds(180, 80, 150, 50);
		b3.setBounds(10, 140, 150, 50);
		b4.setBounds(180, 140, 150, 50);
		b5.setBounds(10, 200, 150, 50);
		b6.setBounds(180, 200, 150, 50);
		b7.setBounds(10, 260, 150, 50);
		b8.setBounds(180, 260, 150, 50);
		b9.setBounds(120, 500, 100, 30);

		// 메뉴 색상 --> 원하는대로 바꿔주세요~
		b1.setBackground(new Color(220, 118, 112)); // 택 (1) 색상 정하기
		b2.setBackground(new Color(220, 118, 112)); // 택 (2)
		b3.setBackground(new Color(220, 118, 112));
		b4.setBackground(new Color(220, 118, 112));
		b5.setBackground(new Color(220, 118, 112));
		b6.setBackground(new Color(220, 118, 112));
		b7.setBackground(new Color(220, 118, 112));
		b8.setBackground(new Color(220, 118, 112));
		b9.setBackground(new Color(220, 118, 112));
		
		b1.setFocusPainted(true);
		
		// 상단바 메뉴 폰트
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		
		//mTitle.setFont(font);
		bar.setFont(font);
		
		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG"))); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// 붙여넣기
		this.add(bar);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(b7);
		this.add(b8);
		this.add(b9);
		this.add(mc);
		this.add(image);

		// 각 버튼 클릭시 연결 기능
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new BookView();
					setVisible(false);
				}
			}
		});
		
		b2.addMouseListener(new MouseAdapter() { // 이용권구매
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new TicketGui();// 이용권구매
					setVisible(false);
				}
			}
		});
		
		b3.addMouseListener(new MouseAdapter() { // 음료 구매
			@Override
			public void mouseClicked(MouseEvent e) { 
				if (e.getButton() == 1) {
					new Drink();
					setVisible(false);
				}
			}
		});
		
		b4.addMouseListener(new MouseAdapter() { // 프린트
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new PrintServiceGui();// 프린트
					setVisible(false);
				}
			}
		});
		
		b5.addMouseListener(new MouseAdapter() { // 예약확인
			@Override
			public void mouseClicked(MouseEvent e) { 
				if (e.getButton() == 1) {
					new checkBooking();
					setVisible(false);
				}
			}
		});
		
		b6.addMouseListener(new MouseAdapter() { // 내정보
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					// 내정보
					setVisible(false);
					new Check(account);
				}
			}
		});
		
		b7.addMouseListener(new MouseAdapter() { // 체크인/체크아웃
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new CheckIn();
					setVisible(false);
				}
			}
		});
		
		b8.addMouseListener(new MouseAdapter() { // 내노트
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == 1) {
					new MemoList();
					setVisible(false);
				}
			}
		});
		
		b9.addMouseListener(new MouseAdapter() { // 로그아웃 - 로그인화면
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					Login l = new Login();

					setVisible(false);
				}
			}
		});

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

