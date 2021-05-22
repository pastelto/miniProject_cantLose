package com.kh.project.reservation.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.reservation.model.vo.Account;

public class checkBooking extends JFrame {
	BookView bv = new BookView();
	
	JLabel bar = new JLabel();
		
	// JLabel bar1 = new JLabel("예약정보");
	//JTable table = new JTable(); // 예약정보 표
	
	JButton btn1 = new JButton("예약 변경"); // 예약변경 버튼
	JButton btn2 = new JButton("예약 취소"); // 예약취소 버튼
	JTextField bInfo = new JTextField("님께서는 [" + bv.getYourDate() + "] 에 [" + bv.getYourSeat() + "] 좌석을 예약하셨습니다." );
	//JButton back = new JButton(); // 뒤로가기 버튼
	
	/*
	JRadioButton b1= new JRadioButton(" 버 튼 "); // 표 안에 삽입
	ButtonGroup bg = new ButtonGroup();
	bg.add(b1);
	*/
	
	JPanel cb = new JPanel();

	
	public checkBooking(Account account) {
		//super("checkBooking");
		//this.setLocationRelativeTo(null);
		
		this.setSize(360, 600);
		this.setLayout(null);
		cb.setBackground(new Color(249, 242, 242)); 
		this.setTitle("예약확인");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34,80,54,54);
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0,0,360,53);
		
		bInfo.setSize(270,50);
		bInfo.setLocation(40,170);
		
		btn1.setSize(270,50);
		btn1.setLocation(40, 240);
		
		btn2.setSize(270,50);
		btn2.setLocation(40, 310);
		
		
		JLabel lTitle = new JLabel("예약정보");
		lTitle.setLocation(140, 80);
		lTitle.setSize(100, 54);
		
		
		// 폰트 설정
		//Font font = new Font("맑은 고딕", Font.BOLD, 20);
		//lTitle.setFont(font);
		
		this.add(lTitle);
		this.add(cb);
		this.add(bar);
		this.add(image);
		this.add(bInfo);
		this.add(btn1);
		this.add(btn2);

		
		
		
	}
	
	
}
