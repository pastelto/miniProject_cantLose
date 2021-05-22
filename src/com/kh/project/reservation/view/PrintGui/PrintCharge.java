package com.kh.project.reservation.view.PrintGui;

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
import javax.swing.JTextField;

import com.kh.project.reservation.controller.PrintServiceManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class PrintCharge extends JFrame {

	JLabel title = new JLabel("프린트 충전"); // 타이틀
	JLabel message = new JLabel("충전할 금액을 입력해주세요."); 
	JTextField count = new JTextField();
	JButton prtPointCharge = new JButton("포인트 충전"); // 프린트포인트 충전버튼
	JButton back = new JButton("< prev");
	JPanel ps = new JPanel();
	Font font = new Font("맑은 고딕", Font.BOLD, 30);
	PrintServiceManager psm = new PrintServiceManager();
	
	

	public PrintCharge(Account account) {

		super("프린트 충전");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		ps.setBackground(new Color(249, 242, 242)); // 배경색 설정
		ps.setLayout(null);
		ps.setSize(getMaximumSize());

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("프린트 충전");
		bar.setFont(bar.getFont().deriveFont(17.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 메세지 라벨 위치
		message.setLocation(85, 140);
		message.setBackground(new Color(248, 248, 248));
		message.setSize(200, 50);
		message.setFont(font.deriveFont(15.0f));

		// 프린트포인트 입력
		count.setLocation(110, 240);
		count.setBackground(new Color(248, 248, 248));
		count.setSize(140, 50);
		count.setToolTipText("충전할 금액 입력");

		// 프린트포인트 충전버튼
		prtPointCharge.setLocation(110, 340);
		prtPointCharge.setBackground(new Color(248, 248, 248));
		prtPointCharge.setFocusPainted(false);
		prtPointCharge.setSize(140, 50);

		// 이전 버튼
		back.setLocation(30, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);

		prtPointCharge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					psm.prtPointCharge(account, Integer.valueOf(count.getText())); // 포인트 충전연결
					new PrintServiceGui(account);
					setVisible(false);
				}
			}
		});

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new MenuChoice(account); // 메인메뉴
					setVisible(false);
				}
			}
		});
		ps.add(bar);
		ps.add(title);
		ps.add(prtPointCharge);
		ps.add(back);
		ps.add(count);
		ps.add(message);
		this.add(ps);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
