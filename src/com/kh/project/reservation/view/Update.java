
package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.UpdateAccount;
import com.kh.project.reservation.model.vo.Account;

public class Update extends JFrame {
	static String pw2;
	static String pnum;
	static String pay;
	static boolean flag = false;

	static JFrame jframe = new JFrame();
	MyDialog dialog;

	public Update() {
	}

	public Update(Account account) {

		jframe.setTitle("내 정보 수정");
		jframe.setBounds(100, 100, 360, 600);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(360, 600);
		panel.setBackground(new Color(249, 242, 242));
		// 컴포넌트 생성

		dialog = new MyDialog(new JFrame(), account, "수정");

		JLabel label = new JLabel("내 정보 수정");
		JLabel lb1 = new JLabel("아이디");
		JLabel lb2 = new JLabel("비밀번호");
		JLabel lb3 = new JLabel("이름");
		JLabel lb4 = new JLabel("주민번호");
		JLabel lb5 = new JLabel("전화번호");
		JLabel lb6 = new JLabel("카드번호");
		JLabel lb7 = new JLabel("누적 이용 시간");
		JLabel lb8 = new JLabel("보유 커피 쿠폰");

		JLabel lb11 = new JLabel(account.getId());
		JTextField lb12 = new JTextField();
		JLabel lb13 = new JLabel(account.getName());
		JLabel lb14 = new JLabel(account.getIdNum());
		JTextField lb15 = new JTextField();
		JTextField lb16 = new JTextField();
		JLabel lb17 = new JLabel(account.getTotalH() + ""); // 누적 이용시간
		JLabel lb18 = new JLabel(account.getCoupon() + "장"); // 보유 커피 쿠폰

		JButton noBtn = new JButton("취소");
		JButton okBtn = new JButton("확인");

		// 컴포넌트 크기 및 배치

		label.setBounds(130, 46, 96, 24);

		lb1.setBounds(18, 88, 100, 32);
		lb1.setOpaque(true);
		lb1.setHorizontalAlignment(JLabel.CENTER);
		lb1.setBackground(new Color(220, 118, 112));

		lb2.setBounds(18, 140, 100, 32);
		lb2.setOpaque(true);
		lb2.setHorizontalAlignment(JLabel.CENTER);
		lb2.setBackground(new Color(220, 118, 112));

		lb3.setBounds(18, 192, 100, 32);
		lb3.setOpaque(true);
		lb3.setHorizontalAlignment(JLabel.CENTER);
		lb3.setBackground(new Color(220, 118, 112));

		lb4.setBounds(18, 244, 100, 32);
		lb4.setOpaque(true);
		lb4.setHorizontalAlignment(JLabel.CENTER);
		lb4.setBackground(new Color(220, 118, 112));

		lb5.setBounds(18, 296, 100, 32);
		lb5.setOpaque(true);
		lb5.setHorizontalAlignment(JLabel.CENTER);
		lb5.setBackground(new Color(220, 118, 112));

		lb6.setBounds(18, 348, 100, 32);
		lb6.setOpaque(true);
		lb6.setHorizontalAlignment(JLabel.CENTER);
		lb6.setBackground(new Color(220, 118, 112));

		lb7.setBounds(18, 400, 100, 32);
		lb7.setOpaque(true);
		lb7.setHorizontalAlignment(JLabel.CENTER);
		lb7.setBackground(new Color(220, 118, 112));

		lb8.setBounds(18, 452, 100, 32);
		lb8.setOpaque(true);
		lb8.setHorizontalAlignment(JLabel.CENTER);
		lb8.setBackground(new Color(220, 118, 112));

		lb11.setBounds(130, 88, 200, 32);
		lb12.setBounds(130, 140, 200, 32);
		lb13.setBounds(130, 192, 200, 32);
		lb14.setBounds(130, 244, 200, 32);
		lb15.setBounds(130, 296, 200, 32);
		lb16.setBounds(130, 348, 200, 32);
		lb17.setBounds(130, 400, 200, 32);
		lb18.setBounds(130, 452, 200, 32);

		noBtn.setBounds(18, 504, 60, 24);
		noBtn.setBackground(new Color(220, 118, 112));
		okBtn.setBounds(269, 504, 60, 24);
		okBtn.setBackground(new Color(220, 118, 112));

		// 프레임에 패널 적용

		jframe.add(panel);

		// 패널에 컴포넌트 적용

		panel.add(label);
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);
		panel.add(lb6);
		panel.add(lb7);
		panel.add(lb8);

		panel.add(lb11);
		panel.add(lb12);
		panel.add(lb13);
		panel.add(lb14);
		panel.add(lb15);
		panel.add(lb16);
		panel.add(lb17);
		panel.add(lb18);

		panel.add(okBtn);
		panel.add(noBtn);

		// 이벤트구현
		okBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				pw2 = lb12.getText(); // 입력받은 비밀번호
				pnum = lb15.getText(); // 입력 받은 전화번호
				pay = lb16.getText(); // 입력 받은 카드 번호

				dialog.setVisible(true);

				

			}

		});
		noBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				new Check(account);
				setVisible(false);
			}

		});

		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MyDialog extends JDialog {

	JLabel label = new JLabel("수정 하시겠습니까?"); // 다이얼로그 문구
	JButton okBtn = new JButton("변경"); // 버튼 1
	JButton noBtn = new JButton("취소"); // 버튼 2

	public MyDialog(JFrame frame, Account account, String title) {

		super(frame, title);
		setLocation(200, 300); // 다이얼로그 위치
		setSize(150, 150); // 다이얼로그 창 크기
		setLayout(null); // 다이얼로그 프레임 종류

		label.setBounds(0, 0, 150, 50); // 레이블 위치 및 크기 지정
		label.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬

		okBtn.setBounds(10, 50, 60, 30); // 버튼 위치 및 크기 지정
		okBtn.setBackground(new Color(220, 118, 112));

		noBtn.setBounds(80, 50, 60, 30); // 버튼 위치 및 크기 지정
		noBtn.setBackground(new Color(220, 118, 112));

		add(label);
		add(okBtn);
		add(noBtn);

		okBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼 클릭시 발생 할 이벤트

				// 회원 비밀번호 = pw2;
				System.out.println("비밀번호가 변경 되었습니다" + Update.pw2);
				new UpdateAccount().update(account, Update.pw2, Update.pnum, Update.pay);

				Update.jframe.setVisible(false);
				setVisible(false);
				Update.flag = true;
				new Check(account);

			}
		});

		noBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);

			}

		});
	}

}
