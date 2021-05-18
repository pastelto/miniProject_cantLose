package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
	HashMap<String, Account> account = new HashMap<>();
	JButton login = new JButton("로그인");
	JButton signout = new JButton("회원가입");
	JTextField logTF = new JTextField();
	JPasswordField pwTF = new JPasswordField();
	JPanel loginP = new JPanel();

	
	String pw="";
	String id="";
	
	
	public Login() {


		super("Login");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		loginP.setBackground(new Color(249, 242, 242)); // 배경색 설정

		JLabel image = new JLabel(new ImageIcon("images/logo.png"));
		image.setBounds(95, 50, 150, 150);

		
		/* Image icon = new ImageIcon("images/커피.png").getImage().getScaledInstance(100,
		 * 100, 0); imLabel = new JLabel(new ImageIcon(icon));
		 * imLabel.setBounds(100,100,100,100);
		 */// 이건 왜 안됨,,,,? */

		loginP.setLayout(null);
		loginP.setSize(getMaximumSize());

		logTF.setLocation(40, 230);
		logTF.setSize(270, 54);

		pwTF.setLocation(40, 300);
		pwTF.setSize(270, 54);
		logTF.setOpaque(true);

		login.setLocation(40, 370);
		login.setSize(270, 54);

		signout.setLocation(40, 440);
		signout.setSize(270, 54);

		loginP.add(logTF);
		loginP.add(pwTF);
		loginP.add(login);
		loginP.add(signout);
		loginP.add(image);
		this.add(loginP);
		
		id = logTF.getText();
		pw = pwTF.getText(); //?????왜 줄쳐지는거지...
		
		login.addMouseListener(new MouseAdapter() { // 로그인 클릭시 일치하면 여기

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					//if(id.equals(ca.checkId(id))&&pw.equals(ca.checkPw(pw))) { // 일치하는지 확인하는 부분 
					new MenuChoice();
					setVisible(false);
					} else {
						// 불일치시에 팝업창 뜨기 -"아이디, 비밀번호를 확인해 주세요."
						
					//}
				}

			}
		});


		signout.addMouseListener(new MouseAdapter() { // 회원가입 여기

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
						new SignUp();
						setVisible(false);
			} 
			}
		}); 




		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
