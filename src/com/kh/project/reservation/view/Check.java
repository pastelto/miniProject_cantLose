
package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.project.reservation.model.vo.Account;

public class Check extends JFrame {

	public Check() {
	}

	public Check(Account account) {

		  try {
              	this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
           } catch (IOException e) {
        	   e.printStackTrace();
           }
		  
		  
		this.setTitle("내 정보");
		this.setBounds(100, 100, 360, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 360, 600);
		panel.setBackground(new Color(249, 242, 242));

		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 16);
		
		
		// 컴포넌트 생성

		JLabel label = new JLabel("내 정보 확인");
		JLabel lb1 = new JLabel("아이디");
		JLabel lb2 = new JLabel("비밀번호");
		JLabel lb3 = new JLabel("이름");
		JLabel lb4 = new JLabel("주민번호");
		JLabel lb5 = new JLabel("전화번호");
		JLabel lb6 = new JLabel("계좌번호");
		JLabel lb7 = new JLabel("누적 이용 시간");
		JLabel lb8 = new JLabel("보유 커피 쿠폰");

		JLabel lb11 = new JLabel(account.getId());
		JLabel lb12 = new JLabel("*********");
		JLabel lb13 = new JLabel(account.getName());
		JLabel lb14 = new JLabel(account.getIdNum());
		JLabel lb15 = new JLabel(account.getpNum());
		JLabel lb16 = new JLabel(account.getBank()+" "+account.getPay());
		JLabel lb17 = new JLabel(account.getTotalH()/60 + "분"); // 누적이용시간
		JLabel lb18 = new JLabel(account.getCoupon() + "장"); // 보유 커피 쿠폰

		JButton backBtn = new JButton("뒤로");
		JButton updateBtn = new JButton("정보 수정");

		// 컴포넌트 크기 및 배치

		label.setBounds(130, 46, 96, 24);
		label.setFont(font3);
		
		lb1.setBounds(18, 88, 100, 32);
		lb1.setOpaque(true);
		lb1.setHorizontalAlignment(JLabel.CENTER);
		lb1.setBackground(new Color(220, 118, 112));
		lb1.setFont(font2);
		
		lb2.setBounds(18, 140, 100, 32);
		lb2.setOpaque(true);
		lb2.setHorizontalAlignment(JLabel.CENTER);
		lb2.setBackground(new Color(220, 118, 112));
		lb2.setFont(font2);
		
		lb3.setBounds(18, 192, 100, 32);
		lb3.setOpaque(true);
		lb3.setHorizontalAlignment(JLabel.CENTER);
		lb3.setBackground(new Color(220, 118, 112));
		lb3.setFont(font2);
		
		lb4.setBounds(18, 244, 100, 32);
		lb4.setOpaque(true);
		lb4.setHorizontalAlignment(JLabel.CENTER);
		lb4.setBackground(new Color(220, 118, 112));
		lb4.setFont(font2);
		
		lb5.setBounds(18, 296, 100, 32);
		lb5.setOpaque(true);
		lb5.setHorizontalAlignment(JLabel.CENTER);
		lb5.setBackground(new Color(220, 118, 112));
		lb5.setFont(font2);
		
		lb6.setBounds(18, 348, 100, 32);
		lb6.setOpaque(true);
		lb6.setHorizontalAlignment(JLabel.CENTER);
		lb6.setBackground(new Color(220, 118, 112));
		lb6.setFont(font2);
		
		lb7.setBounds(18, 400, 100, 32);
		lb7.setOpaque(true);
		lb7.setHorizontalAlignment(JLabel.CENTER);
		lb7.setBackground(new Color(220, 118, 112));
		lb7.setFont(font);
		
		lb8.setBounds(18, 452, 100, 32);
		lb8.setOpaque(true);
		lb8.setHorizontalAlignment(JLabel.CENTER);
		lb8.setBackground(new Color(220, 118, 112));
		lb8.setFont(font);
		
		lb11.setBounds(130, 88, 200, 32);
		lb11.setFont(font);
		lb12.setBounds(130, 140, 200, 32);
		lb12.setFont(font);
		lb13.setBounds(130, 192, 200, 32);
		lb13.setFont(font);
		lb14.setBounds(130, 244, 200, 32);
		lb14.setFont(font);
		lb15.setBounds(130, 296, 200, 32);
		lb15.setFont(font);
		lb16.setBounds(130, 348, 200, 32);
		lb16.setFont(font);
		lb17.setBounds(130, 400, 200, 32);
		lb17.setFont(font);
		lb18.setBounds(130, 452, 200, 32);
		lb18.setFont(font);

		backBtn.setBounds(18, 504, 60, 24);
		backBtn.setBackground(new Color(220, 118, 112));
		backBtn.setForeground(Color.white);
		
		updateBtn.setBounds(229, 504, 100, 24);
		updateBtn.setBackground(new Color(220, 118, 112));
		updateBtn.setForeground(Color.white);
		// 프레임에 패널 적용

		this.add(panel);

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

		panel.add(backBtn);
		panel.add(updateBtn);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 이벤트

		updateBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Update(account); 
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				updateBtn.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				updateBtn.setBackground(new Color(220, 118, 112)); // 버튼색
			} 

		});
		
		backBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new MenuChoice(account);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				backBtn.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backBtn.setBackground(new Color(220, 118, 112)); // 버튼색
			} 
		});

	}


	
}

