package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.CheckAccount;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.reservation.view.MenuChoice;
import com.kh.project.reservation.reservation.view.SignUp;

public class Login extends JFrame {

	Scanner sc = new Scanner(System.in);
	HashMap<String, Account> account = new HashMap<>();
	JButton login = new JButton("로그인");
	JButton signUp = new JButton("회원가입");
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

		signUp.setLocation(40, 440);
		signUp.setSize(270, 54);

		loginP.add(logTF);
		loginP.add(pwTF);
		loginP.add(login);
		loginP.add(signUp);
		loginP.add(image);
		this.add(loginP);
		
		/*id = logTF.getText();
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
		});  */

		
		login.addActionListener(new ActionListener() { // 로그인 클릭시 일치하면 여기

			@Override
			public void actionPerformed(ActionEvent e2) {//로그인 할때 
				// TODO Auto-generated method stub
				try{
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader(id+".txt"));
					while((s=bos.readLine())!=null){
						array=s.split("/");
					if(logTF.getText().equals(array[0])&&pwTF.getText().equals(array[1]))
					{
						JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
						MenuChoice menu = new MenuChoice();
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
					}
					}
					bos.close();
					dispose();
				}catch (IOException e){
					JOptionPane.showMessageDialog(null, "회원가입이 필요합니다.");
				}
			}
		});

		signUp.addMouseListener(new MouseAdapter() { // 회원가입 여기

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

