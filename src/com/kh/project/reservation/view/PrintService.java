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

import com.kh.project.reservation.controller.PrintServiceManager;

public class PrintService extends JFrame{

	JLabel title = new JLabel("프린트서비스"); // 타이틀
	JButton prtPointInfo = new JButton("포인트 조회"); // 프린트포인트 조회버튼
	JButton prtPointCharge = new JButton("포인트 충전"); // 프린트포인트 충전버튼
	JButton prtPointUse = new JButton("포인트 사용"); // 프린트포인트 사용버튼
	JButton back = new JButton("< prev");
	JPanel ps = new JPanel();
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	PrintServiceManager psm = new PrintServiceManager();
	
	
	public PrintService() {

		super("프린트서비스");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		ps.setBackground(new Color(249, 242, 242)); // 배경색 설정
		ps.setLayout(null);
		ps.setSize(getMaximumSize());

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("프린트서비스");
		bar.setFont(bar.getFont().deriveFont(17.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		
		// 프린트 정보조회 버튼
		prtPointInfo.setLocation(110, 140);
		prtPointInfo.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		// checkin.setBorderPainted(false); //버튼 테두리 설정
		prtPointInfo.setFocusPainted(false);// 포커스 표시 설정
		prtPointInfo.setFont(prtPointInfo.getFont().deriveFont(15.0f));
		prtPointInfo.setSize(140, 50);

		// 프린트포인트 충전버튼
		prtPointCharge.setLocation(110, 240);
		prtPointCharge.setBackground(new Color(248, 248, 248));
		prtPointCharge.setFocusPainted(false);
		prtPointCharge.setFont(prtPointCharge.getFont().deriveFont(15.0f));
		prtPointCharge.setSize(140, 50);
		
		// 프린트포인트 사용버튼
		prtPointUse.setLocation(110, 340);
		prtPointUse.setBackground(new Color(248, 248, 248));
		prtPointUse.setFocusPainted(false);
		prtPointUse.setFont(prtPointUse.getFont().deriveFont(15.0f));
		prtPointUse.setSize(140, 50);

		//이전 버튼 
		back.setLocation(30, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);

		prtPointInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					psm.prtPointInfo();// 포인트조회 연결
					setVisible(false);
				}
			}
		});
		
		prtPointCharge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					 //  포인트 충전연결
					setVisible(false);
				}
			}
		});
		
		prtPointUse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					// 포인트 사용 연결
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
		ps.add(bar);
		ps.add(title);
		ps.add(prtPointInfo);
		ps.add(prtPointCharge);
		ps.add(prtPointUse);
		ps.add(back);
		this.add(ps);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}
	
	
	
	
}
