package com.kh.project.reservation.view.TicketGui;

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

import com.kh.project.reservation.controller.TicketManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class TicketGui extends JFrame {
	JLabel title = new JLabel("이용권구매"); // 타이틀
	JButton oneSeatDay = new JButton("1인석(일일권)"); // 1인석(일일권)
	JButton oneSeatMonth = new JButton("1인석(기간권)"); // 1인석(기간권)
	JButton stdR = new JButton("스터디룸"); // 스터디룸
	JButton back = new JButton("< prev");
	JPanel t = new JPanel();
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	TicketManager tm = new TicketManager();

	public TicketGui(Account account) {

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

		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 1인석(일일권)
		oneSeatDay.setLocation(110, 140);
		oneSeatDay.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		oneSeatDay.setFocusPainted(false);// 포커스 표시 설정
		oneSeatDay.setFont(oneSeatDay.getFont().deriveFont(15.0f));
		oneSeatDay.setSize(140, 50);
		
		// 1인석(기간권)
		oneSeatMonth.setLocation(110, 240);
		oneSeatMonth.setBackground(new Color(248, 248, 248)); 
		oneSeatMonth.setFocusPainted(false);
		oneSeatMonth.setFont(oneSeatDay.getFont().deriveFont(15.0f));
		oneSeatMonth.setSize(140, 50);

		// 스터디룸
		stdR.setLocation(110, 340);
		stdR.setBackground(new Color(248, 248, 248));
		stdR.setFocusPainted(false);
		stdR.setFont(stdR.getFont().deriveFont(15.0f));
		stdR.setSize(140, 50);

		// 이전 버튼
		back.setLocation(30, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);

		oneSeatDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new OneSeatDay(account);// 1인석(일일권)
					setVisible(false);
				}
			}
		});
		
		oneSeatMonth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new OneSeatMonth(account);// 1인석(기간권)
					setVisible(false);
				}
			}
		});

		stdR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new StdRoom(account);// 스터디룸
					setVisible(false);
				}
			}
		});

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					MenuChoice mc = new MenuChoice(account);
					setVisible(false);
				}
			}
		});

		t.add(bar);
		t.add(title);
		t.add(oneSeatDay);
		t.add(oneSeatMonth);
		t.add(stdR);
		t.add(back);
		this.add(t);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
