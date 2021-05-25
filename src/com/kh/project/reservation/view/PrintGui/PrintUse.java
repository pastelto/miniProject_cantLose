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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.PrintServiceManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class PrintUse extends JFrame {

	JLabel title = new JLabel("프린트 사용"); // 타이틀
	JLabel black = new JLabel("흑백 : "); // 흑백
	JLabel color = new JLabel("컬러 : "); // 컬러
	JLabel message = new JLabel("출력매수를 입력하시면 프린트코드가 발급됩니다.");
	JLabel message1 = new JLabel("흑백출력 1매");
	JLabel message2 = new JLabel("50점 차감");
	JLabel message3 = new JLabel("컬러출력 1매 100점 차감");
	JTextField bkPage = new JTextField(); // 흑백매수 입력
	JTextField clPage = new JTextField(); // 컬러매수 입력
	JButton prtPointUse = new JButton("프린트 하기"); // 프린트사용버튼
	JButton back = new JButton("뒤로"); // 뒤로
	JPanel ps = new JPanel();
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
	Font font3 = new Font("맑은 고딕", Font.BOLD, 20);
	PrintServiceManager psm = new PrintServiceManager();

	public PrintUse(Account account) {

		super("프린트포인트 사용");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		ps.setBackground(new Color(249, 242, 242)); // 배경색 설정
		ps.setLayout(null);
		ps.setSize(getMaximumSize());

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("프린트포인트 사용                 ");
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

		// 흑백 :
		black.setLocation(70, 150);
		black.setBackground(new Color(248, 248, 248));
		black.setSize(200, 50);
		black.setFont(font.deriveFont(15.0f));

		// 흑백 매수입력
		bkPage.setLocation(140, 150);
		bkPage.setBackground(new Color(248, 248, 248));
		bkPage.setSize(140, 50);
		bkPage.setToolTipText("흑백 매수 입력");

		// 컬러:
		color.setLocation(70, 220);
		color.setBackground(new Color(248, 248, 248));
		color.setSize(200, 50);
		color.setFont(font.deriveFont(15.0f));

		// 컬러 매수 입력
		clPage.setLocation(140, 220);
		clPage.setBackground(new Color(248, 248, 248));
		clPage.setSize(140, 50);
		clPage.setToolTipText("컬러 매수 입력");

		// 메세지
		message.setLocation(55, 75);
		message.setBackground(new Color(248, 248, 248));
		message.setSize(300, 100);
		message.setFont(font.deriveFont(11.0f));

		// 메세지1
		message1.setLocation(90, 260);
		message1.setBackground(new Color(248, 248, 248));
		message1.setSize(300, 100);
		message1.setFont(font.deriveFont(15.0f));

		// 메세지2
		message2.setLocation(194, 260);
		message2.setBackground(new Color(248, 248, 248));
		message2.setSize(300, 100);
		message2.setFont(font.deriveFont(15.0f));

		// 메세지3
		message3.setLocation(90, 300);
		message3.setBackground(new Color(248, 248, 248));
		message3.setSize(300, 100);
		message3.setFont(font.deriveFont(15.0f));

		// 프린트포인트 사용버튼
		prtPointUse.setLocation(110, 400);
		prtPointUse.setBackground(new Color(220, 118, 112));
		prtPointUse.setFocusPainted(false);
		prtPointUse.setForeground(Color.white);
		prtPointUse.setFont(font);
		prtPointUse.setSize(140, 40);

		// 이전 버튼
		back.setLocation(30, 480);
		back.setBackground(new Color(220, 118, 112));
		back.setFocusPainted(false);
		back.setFont(font);
		back.setForeground(Color.white);
		back.setSize(80, 35);

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
					new MenuChoice(account); // 메인메뉴
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
		ps.add(black);
		ps.add(bkPage);
		ps.add(color);
		ps.add(clPage);
		ps.add(message);
		ps.add(message1);
		ps.add(message2);
		ps.add(message3);
		ps.add(prtPointUse);
		ps.add(back);
		this.add(ps);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
