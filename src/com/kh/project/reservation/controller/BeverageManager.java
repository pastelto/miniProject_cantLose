package com.kh.project.reservation.controller;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BeverageManager extends JFrame {

	private int cnt = 0;
	private String show = "";

	public BeverageManager() {

		// 프레임설정
		super("음료메뉴");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(new Color(249, 242, 242));

		Panel pNorth = new Panel();
	    pNorth.setBackground(new Color(249, 242, 242));
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
		
		
		// 메뉴
		String menu[] = { "아메리카노", "아이스아메리카노", "카페라떼", "아이스카페라떼", "핫초코", "아이스초코", "딸기우유", "레몬에이드"};
		int price[] = { 2000, 2500, 2500, 3000, 3000, 3500, 3500, 2500 };
		JButton bt[] = new JButton[menu.length];
		TextField num[] = new TextField[menu.length];
		Button minus[] = new Button[menu.length];
		Button plus[] = new Button[menu.length];
		JButton ok[] = new JButton[menu.length];
		Label l[] = new Label[menu.length];
		ImageIcon icon[] = new ImageIcon[menu.length];

		// 버튼
		for (int i = 0; i < menu.length; i++) {

			// 음료
			bt[i] = new JButton(menu[i]);
			if (i < 3) {
				bt[i].setBounds(10 + i * 100, 40, 100, 100);
			} else {
				bt[i].setBounds(10 + (i - 4) * 100, 200, 100, 100);
			}
			icon[i] = new ImageIcon(i + "images/coffe.PNG");
			bt[i].setIcon(icon[i]);

			// 숫자 txt 버튼
			num[i] = new TextField("0");
			num[i].setBackground(Color.white);
			num[i].setEditable(false);
			num[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);

			// "-" 버튼
			minus[i] = new Button("-");
			minus[i].setBounds(bt[i].getX(), num[i].getY(), 20, 20);
			minus[i].setEnabled(false);

			// "+" 버튼
			plus[i] = new Button("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), num[i].getY(), 20, 20);
			plus[i].setEnabled(false);

			// 가격
			l[i] = new Label(price[i] + "원");
			l[i].setBounds(bt[i].getX() + 20, num[i].getY() - 25, 100, 20);

			// 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(bt[i].getX(), num[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);

			pNorth.add(bt[i]);
			pNorth.add(num[i]);
			pNorth.add(minus[i]);
			pNorth.add(plus[i]);
			pNorth.add(l[i]);
			pNorth.add(ok[i]);
		}

		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setText("   상품명        단가        수량        합계\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);

		// 남쪽
		Panel pSouth = new Panel();
		pSouth.setBackground(new Color(255, 255, 215));

		Button bt1 = new Button("주문");
		Button bt2 = new Button("초기화");
		Button bt3 = new Button("닫기");
		pSouth.add(bt1);
		pSouth.add(bt2);
		pSouth.add(bt3);

		// 주문버튼
		bt1.addActionListener(new ActionListener() {

			public void actionPerformed1(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					num[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");

				}
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// 초기화 버튼
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					num[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");

				}
			}
		});

		// bt3 닫기버튼

		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 컴포넌트
		this.add(pNorth, BorderLayout.NORTH);
		this.add(ta, BorderLayout.CENTER);
		this.add(pSouth, BorderLayout.SOUTH);
		this.setVisible(true);

		// 이벤트단
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			// 버튼 이벤트
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					cnt = 0;
				}
			});

			// "-" 버튼 이벤트
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (cnt > 0) {
						cnt = cnt - 1;
						num[j].setText(cnt + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cnt = cnt + 1;
					num[j].setText(cnt + "");
					ok[j].setEnabled(true);
					if (cnt > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			// 확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand();
					ta.append("   " + show + "       " + price[j] + "        " + cnt + "         " + price[j] * cnt
							+ "원" + "\n");
					ok[j].setEnabled(false);
				}
			});

		}

		// 끄기
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
