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

import com.kh.project.reservation.controller.PrintServiceManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class PrintServiceGui extends JFrame {

	JLabel title = new JLabel("프린트서비스");// 타이틀
	JButton prtPointCharge = new JButton("포인트 충전"); // 프린트포인트 충전버튼
	JButton prtPointUse = new JButton("포인트 사용"); // 프린트포인트 사용버튼
	JButton back = new JButton("< prev");
	JPanel ps = new JPanel();
	Font font = new Font("맑은 고딕", Font.BOLD, 30);
	PrintServiceManager psm = new PrintServiceManager();

	public PrintServiceGui(Account account) {

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

		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 프린트 정보조회- account에서 가지고 온 포인트 정보 보여주기
		String point = Integer.toString(account.getPrintPoint());
		JLabel prtPointInfo = new JLabel("나의 포인트 : " + point + " 점");// 내 현재 포인트 정보
		prtPointInfo.setLocation(80, 140);
		prtPointInfo.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		prtPointInfo.setFont(prtPointInfo.getFont().deriveFont(17.0f));
		prtPointInfo.setSize(300, 100);

		// 프린트포인트 충전버튼
		prtPointCharge.setLocation(100, 240);
		prtPointCharge.setBackground(new Color(248, 248, 248));
		prtPointCharge.setFocusPainted(false);
		prtPointCharge.setFont(prtPointCharge.getFont().deriveFont(17.0f));
		prtPointCharge.setSize(140, 50);

		// 프린트포인트 사용버튼
		prtPointUse.setLocation(100, 340);
		prtPointUse.setBackground(new Color(248, 248, 248));
		prtPointUse.setFocusPainted(false);
		prtPointUse.setFont(prtPointUse.getFont().deriveFont(15.0f));
		prtPointUse.setSize(140, 50);

		// 이전 버튼
		back.setLocation(40, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);

		prtPointCharge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new PrintCharge(account);// 포인트 충전연결
					setVisible(false);
				}
			}
		});

		prtPointUse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new PrintUse(account);// 포인트 사용 연결
					setVisible(false);
				}
			}
		});

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					MenuChoice mc = new MenuChoice(account); // 메인메뉴
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
