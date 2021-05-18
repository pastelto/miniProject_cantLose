package com.kh.project.reservation.view.Board;

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
import javax.swing.JTextArea;

import com.kh.project.reservation.view.MenuChoice;

public class MyMemo extends JFrame {

	JLabel bar = new JLabel();
	JLabel mM1 = new JLabel();
	JButton saveM = new JButton("저장"); // 글 저장
	JButton back = new JButton("취소"); // 뒤로가기 (or 메뉴)

	public MyMemo() { // 패널 2

		// 패널 설정
		this.setSize(360, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(new Color(249, 242, 242));
		mM1.setLayout(null);
		mM1.setSize(360, 600);

		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("내 노트  "); // 글씨색 바꾸고 싶다..
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		// 상단바 메뉴 폰트
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		// 폰트
		bar.setFont(font);

		// 타이틀
		this.setTitle("내 노트  ");

		// 패널 2 (메모작성)
		JTextArea memo = new JTextArea();
		memo.setLocation(20, 100);
		memo.setSize(300, 300);
		memo.setToolTipText("이곳에 입력하세요"); // 커서 올리면 가이드
		mM1.add(memo);

		// 2. 버튼 위치
		saveM.setBounds(90, 430, 150, 30);
		back.setBounds(230, 500, 90, 30);

		// 패널에 붙이기
		mM1.add(bar);
		mM1.add(saveM);
		mM1.add(back);

		this.add(mM1);

		// 상단바 로고
		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 마우스 효과	
		back.addMouseListener(new MouseAdapter() { // 메뉴로 돌아가기
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new MemoList();
					setVisible(false);
				}
			}

		});

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
