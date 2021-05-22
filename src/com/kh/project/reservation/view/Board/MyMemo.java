package com.kh.project.reservation.view.Board;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyMemo extends JFrame {

	JLabel bar = new JLabel();
	JLabel mM1 = new JLabel();
	JButton saveM = new JButton("저장"); // 글 저장
	JLabel titleLabel = new JLabel("제목");
	JTextField title = new JTextField(40); // 메모 제목
	JTextArea memo = new JTextArea(); // 메모 내용
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

		// 제목 패널1
		titleLabel.setLocation(20, 50);
		titleLabel.setSize(50, 100);
		mM1.add(titleLabel);

		title.setLocation(60, 80);
		title.setSize(240, 30);
		title.setText("이곳에 20자 이내 제목을 입력하세요.");
		title.setToolTipText("이곳에 제목을 입력하세요");
		mM1.add(title);

		// 패널 2 (메모작성)

		memo.setLocation(20, 130);
		memo.setSize(300, 300);
		memo.setToolTipText("이곳에 메모를 입력하세요"); // 커서 올리면 가이드
		mM1.add(memo);

		// 2. 버튼 위치
		saveM.setBounds(90, 450, 150, 30);
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
		back.addMouseListener(new MouseAdapter() { // 메모 취소 후 메모 목록으로 돌아가기
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					JOptionPane.showMessageDialog(null, "메모가 취소되었습니다!", "취소", JOptionPane.WARNING_MESSAGE);
					new MemoList();
					setVisible(false);
				}
			}

		});

		// 메모 제목 & 내용 저장하기
		saveM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					newMemo();
					JOptionPane.showMessageDialog(null, "메모가 저장되었습니다!", "저장완료", JOptionPane.INFORMATION_MESSAGE);
					new MemoList();
					setVisible(false);
				}
			}

		});

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 메모 작성 및 저장
	protected void newMemo() {

		String t = title.getText();
		String fileTitle = t + ".txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileTitle));
			bw.write(memo.getText());
			bw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	protected void editM() {

	}



}

