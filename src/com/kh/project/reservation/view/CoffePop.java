package com.kh.project.reservation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.UpdateAccount;

class CoffePop extends JFrame {

	public CoffePop() {

		super("Congraturation");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		JLabel label = new JLabel("Congratulation"); // 다이얼로그 문구
		JLabel label2 = new JLabel("가입을 축하드립니다."); // 다이얼로그 문구
		JLabel label3 = new JLabel("커피 쿠폰 10% 할인권이 발급되었습니다."); // 다이얼로그 문구
		JLabel label4 = new JLabel("로그인 후 이용해주세요!"); // 다이얼로그 문구
		
		JButton okBtn = new JButton("확인"); // 버튼 
		JPanel coffeeP = new JPanel();
		
		coffeeP.setBackground(new Color(249, 242, 242)); // 배경색 설정
		coffeeP.setLayout(null);
		coffeeP.setSize(getMaximumSize());
		coffeeP.setBackground(new Color(249, 242, 242));
		
		JLabel image = new JLabel(new ImageIcon("images/coffe-cup.png"));
		image.setBounds(85, 60, 180, 170);
		
		label.setBounds(-33, 260, 400, 50); // 레이블 위치 및 크기 지정
		label.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		label.setForeground(new Color(220, 118, 112));
		
		label2.setBounds(35, 307, 200, 50); // 레이블 위치 및 크기 지정
		label2.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		
		label3.setBounds(20, 330, 300, 50); // 레이블 위치 및 크기 지정
		label3.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		
		label4.setBounds(-29, 348, 300, 50); // 레이블 위치 및 크기 지정
		label4.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		
		okBtn.setBounds(50, 430, 250, 45); // 버튼 위치 및 크기 지정
		okBtn.setBackground(new Color(220, 118, 112));
		okBtn.setForeground(Color.white);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 34);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 18);
		Font font3 = new Font("맑은 고딕", Font.PLAIN, 13);
		
		label.setFont(font);
		label2.setFont(font2);
		label3.setFont(font3);
		label4.setFont(font3);
		label2.setForeground(Color.gray);
		label3.setForeground(Color.gray);
		label4.setForeground(Color.gray);
		
		coffeeP.add(label);
		coffeeP.add(label2);
		coffeeP.add(label3);
		coffeeP.add(label4);
		
		coffeeP.add(okBtn);
		coffeeP.add(image);
		this.add(coffeeP);
		
		okBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new Login();
				setVisible(false);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				okBtn.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				okBtn.setBackground(new Color(220, 118, 112)); // 버튼색
			} 

		}); 

	
	// 상단바 로고
	try {
		this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
}

}
