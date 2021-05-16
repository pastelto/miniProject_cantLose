package com.kh.project.reservation.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Check extends JFrame {

	public Check() {}
	public Check(String id,String name, String idNum, 
			 String pNum, String bank, String pay) {
		
		this.setTitle("내 정보");
		this.setBounds(100,100,360,600);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,360,600);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 컴포넌트 생성
		
		JLabel label = new JLabel("내 정보 확인");
		JLabel lb1 = new JLabel("아이디");
		JLabel lb2 = new JLabel("비밀번호");
		JLabel lb3 = new JLabel("이름");
		JLabel lb4 = new JLabel("주민번호");	
		JLabel lb5 = new JLabel("전화번호");
		JLabel lb6 = new JLabel("카드번호");
		JLabel lb7 = new JLabel("누적 이용 시간");
		JLabel lb8 = new JLabel("보유 커피 쿠폰");
		
		JLabel lb11 = new JLabel(id);
		JLabel lb12 = new JLabel("*********");
		JLabel lb13 = new JLabel(name);
		JLabel lb14 = new JLabel(idNum);
		JLabel lb15 = new JLabel(pNum);
		JLabel lb16 = new JLabel(pay);
		JLabel lb17 = new JLabel(); // 누적이용시간
		JLabel lb18 = new JLabel(); // 보유 커피 쿠폰
		
		JButton backBtn = new JButton("뒤로");
		JButton updateBtn = new JButton("정보 수정");
		
		// 컴포넌트 크기 및 배치 
		
		label.setBounds(130, 46, 96, 24);
		
		lb1.setBounds(18, 88,100, 32);
		lb2.setBounds(18, 140,100, 32);
		lb3.setBounds(18, 192,100, 32);
		lb4.setBounds(18, 244,100, 32);
		lb5.setBounds(18, 296,100, 32);
		lb6.setBounds(18, 348,100, 32);
		lb7.setBounds(18, 400,100, 32);
		lb8.setBounds(18, 452,100, 32);
		
		lb11.setBounds(130, 88, 200, 32);
		lb12.setBounds(130, 140, 200, 32);
		lb13.setBounds(130, 192, 200, 32);
		lb14.setBounds(130, 244, 200, 32);
		lb15.setBounds(130, 296, 200, 32);
		lb16.setBounds(130, 348, 200, 32);
		lb17.setBounds(130, 400, 200, 32);
		lb18.setBounds(130, 452, 200, 32);

		backBtn.setBounds(18, 504, 60, 24);
		updateBtn.setBounds(229, 504, 100, 24);
		
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
		
		panel.add(backBtn);
		panel.add(updateBtn);
		
		// 이벤트
		
		updateBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Update();
			}
			
		});
		
		
		
		
	}
	public static void main(String args[]) {
		new Check();
	}

}
