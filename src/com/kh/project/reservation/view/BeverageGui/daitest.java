package com.kh.project.reservation.view.BeverageGui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kh.project.reservation.view.Update;

class MyDialog extends JDialog {

	JLabel label = new JLabel("수정 하시겠습니까?"); // 다이얼로그 문구
	JButton okBtn = new JButton("변경"); // 버튼 1
	JButton noBtn = new JButton("취소"); // 버튼 2

	boolean result;

	public MyDialog(JFrame frame, String title) {

		super(frame, title);

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
				result = true;

				if (result) {

					if (!Update.pw2.equals("")) {
						// 회원 비밀번호 = pw2;
						System.out.println("비밀번호가 변경 되었습니다");
					}
					if (!Update.pnum.equals("")) {
						// 회원 전화번호 = pnum;
						System.out.println("전화번호가 변경 되었습니다");
					}
					if (!Update.pay.equals("")) {
						// 회원 카드번호 = pay;
						System.out.println("카드번호가 변경 되었습니다");
					}
					setVisible(false);
				}
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
