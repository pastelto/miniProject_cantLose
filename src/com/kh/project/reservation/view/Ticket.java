package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.TicketManager;

public class Ticket extends JFrame{
	JLabel title = new JLabel("이용권구매"); // 타이틀
	JButton oneSeat = new JButton("1인석"); // 1인석
	JButton stdR = new JButton("스터디룸"); // 스터디룸
	JButton back = new JButton("< prev");
	JPanel t = new JPanel();
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	TicketManager tm = new TicketManager();
	
	
	public Ticket() {

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
		bar.setText("이용권 구매");
		bar.setFont(bar.getFont().deriveFont(17.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		
		// 1인석
		oneSeat.setLocation(110, 140);
		oneSeat.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		// checkin.setBorderPainted(false); //버튼 테두리 설정
		oneSeat.setFocusPainted(false);// 포커스 표시 설정
		oneSeat.setFont(oneSeat.getFont().deriveFont(15.0f));
		oneSeat.setSize(140, 50);

		// 스터디룸
		stdR.setLocation(110, 240);
		stdR.setBackground(new Color(248, 248, 248));
		stdR.setFocusPainted(false);
		stdR.setFont(stdR.getFont().deriveFont(15.0f));
		stdR.setSize(140, 50);
		
		//이전 버튼 
		back.setLocation(30, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);

		oneSeat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					// 1인석
					setVisible(false);
				}
			}
		});
		
		stdR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					 //  스터디룸
					setVisible(false);
				}
			}
		});
		
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					MenuChoice mc = new MenuChoice();
					setVisible(false);
				}
			}
		});
		
		t.add(bar);
		t.add(title);
		t.add(oneSeat);
		t.add(stdR);
		t.add(back);
		this.add(t);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}
	
	
}
