package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Menu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.reservation.model.vo.Account;


public class Login extends JFrame {

	HashMap<String, Account> account = new HashMap<>();
	JButton login = new JButton("로그인");
	JButton signout = new JButton("회원가입"); 
	JTextField logTF = new JTextField();
	JPasswordField pwTF= new JPasswordField();
	JPanel loginP= new JPanel(); 
	
	public Login () {
			
			super("Login");
			this.setSize(360,600);
			this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
			this.setLayout(null);
			
			loginP.setBackground(new Color(249, 242, 242)); // 배경색 설정
			
			
			
			
			
			
			
			
			//imgTest = new ImageIcon("images/logo.png");
			JLabel image = new JLabel(new ImageIcon("images/logo.png"));
			//image.setBounds(95,50,150,150);
			/*Image icon = new ImageIcon("images/커피.png").getImage().getScaledInstance(100, 100, 0);
			imLabel = new JLabel(new ImageIcon(icon)); 
			imLabel.setBounds(100,100,100,100); */// 이건 왜 안됨,,,,?
			

			loginP.setLayout(null);
			loginP.setSize(getMaximumSize());
			
			logTF.setLocation(40,230);
			logTF.setSize(270,54);
			
			pwTF.setLocation(40,300);
			pwTF.setSize(270,54);
			logTF.setOpaque(true);
			
			login.setLocation(40,370);
			login.setSize(270,54);
			
			signout.setLocation(40,440);
			signout.setSize(270,54);
			
			
			loginP.add(logTF);
			loginP.add(pwTF);
			loginP.add(login);
			loginP.add(signout);
			loginP.add(image);
			this.add(loginP);
			
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			
			login.addMouseListener(new MouseAdapter() { // 로그인 클릭시 일치하면 여기

				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton()==1) {
						new Menu();
						setVisible(false);
					}
				}
				
			});
			
			signout.addMouseListener(new MouseAdapter() { // 회원가입 여기

				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton()==1) {
						new SignUp();
						setVisible(false);
					}
				}
				
			});

		
			
		}

	}

