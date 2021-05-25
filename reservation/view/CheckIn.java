package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.project.reservation.model.vo.Account;

public class CheckIn extends JFrame {

	JLabel name = new JLabel("조아혜 님"); // 이름
	JLabel title = new JLabel("CHECKIN & OUT"); // 타이틀
	JButton checkin = new JButton("체크인"); // 체크인버튼
	JButton checkout = new JButton("체크아웃"); // 체크아웃버튼
	JButton back = new JButton("< prev");
	JPanel cc = new JPanel();
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	Account a = new Account();
	
	public CheckIn() {

		super("checkIn & checkOut");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		cc.setBackground(new Color(249, 242, 242)); // 배경색 설정
		cc.setLayout(null);
		cc.setSize(getMaximumSize());

		// 사람이미지
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34, 135, 85, 54);

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("CHECHKIN & OUT  ");
		bar.setFont(bar.getFont().deriveFont(17.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		// 공부그림
		String imgPath = "images/checkout.png";
		ImageIcon originicon = new ImageIcon(imgPath);
		Image originImg = originicon.getImage();
		Image changedimg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(changedimg);

		JLabel out = new JLabel(icon);
		out.setBounds(50, 243, 50, 50);

		JLabel in = new JLabel(icon);
		in.setBounds(50, 325, 50, 100);

		// name 레이블
		name.setLocation(130, 135);
		name.setFont(name.getFont().deriveFont(30.0f)); // 글씨 크기 변경
		name.setSize(270, 54);
		name.setFont(font); // 폰트 변경 

		// 체크인 버튼
		checkin.setLocation(110, 240);
		checkin.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		// checkin.setBorderPainted(false); //버튼 테두리 설정
		checkin.setFocusPainted(false);// 포커스 표시 설정
		checkin.setFont(checkin.getFont().deriveFont(15.0f));
		checkin.setSize(140, 50);

		// 체크아웃 버튼
		checkout.setLocation(110, 350);
		checkout.setBackground(new Color(248, 248, 248));
		checkout.setFocusPainted(false);
		checkout.setFont(checkout.getFont().deriveFont(15.0f));
		checkout.setSize(140, 50);

		//이전 버튼 
		back.setLocation(30, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					MenuChoice mc = new MenuChoice(a);
					setVisible(false);
				}
			}
		});
		
		cc.add(name);
		cc.add(checkin);
		cc.add(checkout);
		cc.add(image);
		cc.add(bar);
		cc.add(back);
		cc.add(out);
		cc.add(in);
		cc.add(title);
		this.add(cc);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
