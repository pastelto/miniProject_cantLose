package com.kh.project.reservation.view.BeverageGui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.project.reservation.controller.DrinkManager;
import com.kh.project.reservation.model.vo.Account;

public class DrinkBuy extends JFrame{
	
	JLabel title = new JLabel("음료메뉴");// 타이틀 
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	JPanel cc = new JPanel();
	JPanel input = new JPanel(); // 레이블 박스
	Account ac = new Account();
	DrinkManager dm = new DrinkManager();
	
	//버튼
	JButton a = new JButton("구매");
	JLabel list = new JLabel(dm.menusave());
	
	public DrinkBuy() {
		super("Beverage");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		cc.setBackground(new Color(249, 242, 242)); // 배경색 설정
		cc.setLayout(null);
		cc.setSize(getMaximumSize());
		
		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("Beverage  ");
		bar.setFont(bar.getFont().deriveFont(20.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);
		
		// 주문한 내용 // 레이블 -> 버튼 선택하면 똑같은 메뉴가 뜨게하기
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.BLACK), "주문한 내용");
		oneTb.setTitleColor(Color.BLACK);
		JPanel onePan = new JPanel();
		onePan.setLayout(null);
		onePan.setBorder(oneTb);
		onePan.setBounds(50, 80, 250, 300);
		onePan.setBackground(new Color(249, 242, 242));
		onePan.setFont(a.getFont().deriveFont(30.0f)); // 크기 왜 안바뀜 ㅠ
		
		
		a.setLocation(110, 470);
		a.setBackground(new Color(146, 133, 132));
		a.setFocusPainted(false);
		a.setFont(a.getFont().deriveFont(15.0f));
		a.setSize(125, 40);
		
		list.setLocation(140, 300);
		list.setFont(a.getFont().deriveFont(15.0f));
		list.setSize(125, 40);
		
		
		
		cc.add(bar);
		cc.add(onePan);
		cc.add(bar);
		cc.add(bar);
		cc.add(a);
		cc.add(list);
		
		
		this.add(onePan);
		
		this.add(cc);
		this.add(input);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
	}


}
