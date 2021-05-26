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
	JButton back = new JButton("뒤로");
	JPanel ps = new JPanel();
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
	Font font3 = new Font("맑은 고딕", Font.BOLD, 20);

	PrintServiceManager psm = new PrintServiceManager();

	public PrintServiceGui(Account account) {

		super("프린트서비스");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		ps.setBackground(new Color(249, 242, 242)); // 배경색 설정
		ps.setLayout(null);
		ps.setSize(getMaximumSize());

		// name 레이블
		JLabel name = new JLabel(account.getName() + " 님 의"); // 이름
		name.setLocation(130, 135);
		name.setFont(font3); // 폰트 변경
		name.setSize(270, 54);

		// 사람이미지
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34, 135, 85, 54);

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("프린트 서비스 ");
		bar.setFont(font3);
		bar.setForeground(Color.white);
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
		JLabel prtPointInfo = new JLabel("현재 프린트 포인트 : " + point + " 점");// 내 현재 포인트 정보
		prtPointInfo.setLocation(60, 160);
		prtPointInfo.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		prtPointInfo.setFont(prtPointInfo.getFont().deriveFont(16.0f));
		prtPointInfo.setSize(300, 100);

		// 프린트포인트 충전버튼
		prtPointCharge.setLocation(100, 260);
		prtPointCharge.setBackground(new Color(220, 118, 112));
		prtPointCharge.setFocusPainted(false);
		prtPointCharge.setForeground(Color.white);
		prtPointCharge.setFont(font);
		prtPointCharge.setSize(140, 50);

		// 프린트포인트 사용버튼
		prtPointUse.setLocation(100, 340);
		prtPointUse.setBackground(new Color(220, 118, 112));
		prtPointUse.setFocusPainted(false);
		prtPointUse.setForeground(Color.white);
		prtPointUse.setFont(font);
		prtPointUse.setSize(140, 50);

		// 이전 버튼
		back.setLocation(40, 500);
		back.setBackground(new Color(220, 118, 112));
		back.setFocusPainted(false);
		back.setForeground(Color.white);
		back.setFont(font);
		back.setSize(80, 35);

		prtPointCharge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new PrintCharge(account);// 포인트 충전연결
					setVisible(false);
				}
			}
		});

		prtPointCharge.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				prtPointCharge.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				prtPointCharge.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});

		prtPointUse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new PrintUse(account);// 포인트 사용연결
					setVisible(false);
				}
			}
		});

		prtPointUse.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				prtPointUse.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				prtPointUse.setBackground(new Color(220, 118, 112)); // 버튼색
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

		back.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				back.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});
		ps.add(bar);
		ps.add(title);
		ps.add(prtPointInfo);
		ps.add(prtPointCharge);
		ps.add(prtPointUse);
		ps.add(back);
		ps.add(image);
		ps.add(name);
		this.add(ps);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
