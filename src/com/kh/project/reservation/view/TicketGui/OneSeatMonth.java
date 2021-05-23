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
import javax.swing.JTextField;

import com.kh.project.reservation.controller.PrintServiceManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;
import com.kh.project.reservation.view.PrintGui.PrintServiceGui;

public class OneSeatMonth extends JFrame {

	JLabel title = new JLabel("1인석 이용권"); // 타이틀
	JLabel black = new JLabel("흑백 : "); // 흑백
	JLabel color = new JLabel("컬러 : "); // 컬러
	JTextField bkPage = new JTextField(); // 흑백매수 입력
	JTextField clPage = new JTextField(); // 컬러매수 입력
	JButton prtPointUse = new JButton("프린트 하기"); // 프린트사용버튼
	JButton back = new JButton("< prev"); // 뒤로
	JPanel ps = new JPanel();
	Font font = new Font("맑은 고딕", Font.BOLD, 30);
	PrintServiceManager psm = new PrintServiceManager();

	public OneSeatMonth(Account account) {

		super("프린트 사용");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		ps.setBackground(new Color(249, 242, 242)); // 배경색 설정
		ps.setLayout(null);
		ps.setSize(getMaximumSize());

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("프린트 사용");
		bar.setFont(bar.getFont().deriveFont(17.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 흑백 :
		black.setLocation(70, 150);
		black.setBackground(new Color(248, 248, 248));
		black.setSize(200, 50);
		black.setFont(font.deriveFont(15.0f));

		// 흑백 매수입력
		bkPage.setLocation(150, 150);
		bkPage.setBackground(new Color(248, 248, 248));
		bkPage.setSize(140, 50);
		bkPage.setToolTipText("흑백 매수 입력");

		// 컬러:
		color.setLocation(70, 220);
		color.setBackground(new Color(248, 248, 248));
		color.setSize(200, 50);
		color.setFont(font.deriveFont(15.0f));

		// 컬러 매수 입력
		clPage.setLocation(150, 220);
		clPage.setBackground(new Color(248, 248, 248));
		clPage.setSize(140, 50);
		clPage.setToolTipText("컬러 매수 입력");

		// 프린트포인트 사용버튼
		prtPointUse.setLocation(110, 340);
		prtPointUse.setBackground(new Color(248, 248, 248));
		prtPointUse.setFocusPainted(false);
		prtPointUse.setSize(140, 50);

		// 이전 버튼
		back.setLocation(30, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);

		prtPointUse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					psm.prtPointUse(account, Integer.valueOf(bkPage.getText()), Integer.valueOf(clPage.getText())); // 포인트
					new PrintServiceGui(account); // 프린트메인
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
		ps.add(black);
		ps.add(bkPage);
		ps.add(color);
		ps.add(clPage);
		ps.add(prtPointUse);
		ps.add(back);
		this.add(ps);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
