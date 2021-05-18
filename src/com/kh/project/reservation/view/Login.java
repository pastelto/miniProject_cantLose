package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import com.kh.project.reservation.controller.CheckAccount;

import com.kh.project.reservation.controller.BoardManager;

import com.kh.project.reservation.model.vo.Account;

public class Login extends JFrame { 

	Scanner sc = new Scanner(System.in);
	CheckAccount ca = new CheckAccount();
	HashMap<String, Account> account = new HashMap<>();
	JButton login = new JButton("로그인");
	JButton signout = new JButton("회원가입");
	JTextField logTF = new JTextField();
	JPasswordField pwTF = new JPasswordField();
	JPanel loginP = new JPanel();

	String pw;
	String id;

	
	public Login () {
			
			super("Login");
			this.setSize(360,600);
			this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
			this.setLayout(null);
			
			loginP.setBackground(new Color(249, 242, 242)); // 배경색 설정
			
			JLabel id = new JLabel("ID : ");
			JLabel pw = new JLabel("PW : ");
			
			
			
			
			
			
			//imgTest = new ImageIcon("images/logo.png");
			JLabel image = new JLabel(new ImageIcon("images/logo.png"));
		     image.setBounds(95, 40, 150, 150);
			/*Image icon = new ImageIcon("images/커피.png").getImage().getScaledInstance(100, 100, 0);
			imLabel = new JLabel(new ImageIcon(icon)); 
			imLabel.setBounds(100,100,100,100); */// 이건 왜 안됨,,,,?
			
			
			BoardManager bm1 = new BoardManager();
			String mm = bm1.maxim();
			JLabel m = new JLabel(mm);
			m.setLocation(30, 180);
			m.setSize(360, 54);

			loginP.setLayout(null);
			loginP.setSize(getMaximumSize());
			
			logTF.setLocation(120,280);
			logTF.setSize(200,54);
			
			id.setLocation(40, 280);
			id.setSize(200, 54);
			
			pwTF.setLocation(120,350);
			pwTF.setSize(200,54);
			pw.setLocation(40, 350);
			pw.setSize(200, 54);
			logTF.setOpaque(true);
			
			login.setLocation(50,420);
			login.setSize(120,54);
			
			signout.setLocation(190,420);
			signout.setSize(120,54);
			
			
			loginP.add(logTF);
			loginP.add(pwTF);
			loginP.add(login);
			loginP.add(signout);
			loginP.add(image);
			

			loginP.add(id);
			loginP.add(pw);
			loginP.add(m);
			this.add(loginP);
			
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			login.addMouseListener(new MouseAdapter() { // 로그인 클릭시 일치하면 여기

				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton()==1) {
						new MenuChoice();
						setVisible(false);
					}

				}
		
//		logTF.addKeyListener(new KeyAdapter() { // 로그인 id 키보드 입력시
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				String id = e.getID();
//				ca.checkId(id);
//			}
//			
//		});
//		
//		pwTF.addKeyListener(new KeyAdapter() { // 로그인 pw 키보드 입력시
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				String pw = sc.nextLine();
//				ca.checkPw(pw);
//			}
//			
//		});

//		login.addMouseListener(new MouseAdapter() { // 로그인 클릭시 일치하면 여기
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (e.getButton() == 1) {
//					if(ca.checkId(id.equals(ca.checkId("id")) &&pw.equals(ca.checkPw("pw")))) { // 일치하는지 확인
//					new MenuChoice();
//					setVisible(false);
//					} else {
//						// 불일치시에 팝업창 뜨기
//					}
//				}
//			}
//		});

		
//
//		signout.addMouseListener(new MouseAdapter() { // 회원가입 여기
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (e.getButton() == 1) {
//					new SignUp();
//					setVisible(false);
//				} 
//			}
//
//		});
//
//

			

}
	}
}

