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
import javax.swing.JPanel;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class MemoList extends JFrame { // 메모 목록창

	JLabel bar = new JLabel();
	JPanel mM = new JPanel();
	JButton newM = new JButton("글쓰기"); // 새로 글 작성
	JButton editM = new JButton("수정"); // 글 수정
	JButton back = new JButton("뒤로가기"); // 뒤로가기 (or 메뉴)
	Account a = new Account();
	
	public MemoList() { // 패널1

		super("MemoList");
		// 패널 설정
		this.setSize(360, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setBackground(new Color(249, 242, 242));
		mM.setLayout(null);
		mM.setSize(360,600);
		
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
		

		// 버튼 위치
		newM.setBounds(30, 430, 80, 30);
		editM.setBounds(130, 430, 80, 30);
		back.setBounds(230, 500, 90, 30);

		// 패널에 붙이기
		mM.add(back);
		mM.add(newM);
		mM.add(editM);
		mM.add(bar);
		
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
				MenuChoice mc = new MenuChoice(a); 
				setVisible(false);
			}
		}

	});
		
		newM.addMouseListener(new MouseAdapter() { // 메뉴로 돌아가기
			@Override 
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new MyMemo(); 
					setVisible(false);
				}
			}

		});
		
		editM.addMouseListener(new MouseAdapter() { // 메뉴로 돌아가기
			@Override 
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					MyMemo mm = new MyMemo(); 
					mm.editM();
					setVisible(false);
				}
			}

		});
		this.add(mM);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}