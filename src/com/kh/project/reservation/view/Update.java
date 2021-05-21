package com.kh.project.reservation.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update extends JFrame  {
	
	public Update() {}
	
	public Update(String id, String name, String idNum	) {

		this.setTitle("내 정보 수정");
		this.setSize(360, 600);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 360, 600);

		// 컴포넌트 생성

		JLabel label = new JLabel("내 정보 수정");
		JLabel lb1 = new JLabel("아이디");
		JLabel lb2 = new JLabel("비밀번호");
		JLabel lb3 = new JLabel("이름");
		JLabel lb4 = new JLabel("주민번호");
		JLabel lb5 = new JLabel("전화번호");
		JLabel lb6 = new JLabel("카드번호");
		JLabel lb7 = new JLabel("누적 이용 시간");
		JLabel lb8 = new JLabel("보유 커피 쿠폰");

		JLabel lb11 = new JLabel(id);
		JTextField lb12 = new JTextField();
		JLabel lb13 = new JLabel(name);
		JLabel lb14 = new JLabel(idNum);
		JTextField lb15 = new JTextField(); 
		JTextField lb16 = new JTextField();
		JLabel lb17 = new JLabel(); //누적 이용시간
		JLabel lb18 = new JLabel(); //보유 커피 쿠폰

		JButton noBtn = new JButton("취소");
		JButton okBtn = new JButton("확인");

		// 컴포넌트 크기 및 배치

		label.setBounds(130, 46, 96, 24);

		lb1.setBounds(18, 88, 100, 32);
		lb2.setBounds(18, 140, 100, 32);
		lb3.setBounds(18, 192, 100, 32);
		lb4.setBounds(18, 244, 100, 32);
		lb5.setBounds(18, 296, 100, 32);
		lb6.setBounds(18, 348, 100, 32);
		lb7.setBounds(18, 400, 100, 32);
		lb8.setBounds(18, 452, 100, 32);

		lb11.setBounds(130, 88, 200, 32);
		lb12.setBounds(130, 140, 200, 32);
		lb13.setBounds(130, 192, 200, 32);
		lb14.setBounds(130, 244, 200, 32);
		lb15.setBounds(130, 296, 200, 32);
		lb16.setBounds(130, 348, 200, 32);
		lb17.setBounds(130, 400, 200, 32);
		lb18.setBounds(130, 452, 200, 32);

		noBtn.setBounds(18, 504, 60, 24);
		okBtn.setBounds(269, 504, 60, 24);

		// 프레임에 패널 적용

		this.add(panel);

		// 패널에 컴포넌트 적용

		panel.add(label);
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);
		panel.add(lb6);
		panel.add(lb7);
		panel.add(lb8);

		panel.add(lb11);
		panel.add(lb12);
		panel.add(lb13);
		panel.add(lb14);
		panel.add(lb15);
		panel.add(lb16);
		panel.add(lb17);
		panel.add(lb18);

		panel.add(okBtn);
		panel.add(noBtn);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	
}
