package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.kh.project.reservation.model.vo.Account;

public class Drink extends JFrame{
	
	JLabel title = new JLabel("음료메뉴");// 타이틀 
	JButton checkout = new JButton("체크아웃");
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	JPanel cc = new JPanel();
	JPanel input = new JPanel(); // 레이블 박스
	Account ac = new Account();
	
	public Drink() {
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
		
		//버튼
		JButton a = new JButton("아메리카노");
		JButton b = new JButton("<html> &nbsp;	&nbsp; 아이스   <br>아메리카노</html>");
		JButton c = new JButton("카페라떼");
		JButton d = new JButton("<html> &nbsp;	 아이스   <br>카페라떼</html>");
		JButton e = new JButton("핫초코");
		JButton f = new JButton("아이스초코");
		JButton g = new JButton("딸기우유");
		JButton h = new JButton("레몬에이드");
		JButton i = new JButton("담기");
		JButton j = new JButton("구매");
		JButton k = new JButton("< prev");
		
		a.setLocation(50, 70);
		a.setBackground(new Color(248, 248, 248));
		a.setFocusPainted(false);
		a.setFont(a.getFont().deriveFont(12.0f));
		a.setSize(100, 40);
		
		b.setLocation(200, 70);
		b.setBackground(new Color(248, 248, 248));
		b.setFocusPainted(false);
		b.setFont(b.getFont().deriveFont(12.0f));
		b.setSize(100, 40);
		
		c.setLocation(50, 140);
		c.setBackground(new Color(248, 248, 248));
		c.setFocusPainted(false);
		c.setFont(c.getFont().deriveFont(12.0f));
		c.setSize(100, 40);
		
		d.setLocation(200, 140);
		d.setBackground(new Color(248, 248, 248));
		d.setFocusPainted(false);
		d.setFont(d.getFont().deriveFont(12.0f));
		d.setSize(100, 40);
		
		e.setLocation(50, 210);
		e.setBackground(new Color(248, 248, 248));
		e.setFocusPainted(false);
		e.setFont(e.getFont().deriveFont(12.0f));
		e.setSize(100, 40);

		f.setLocation(200, 210);
		f.setBackground(new Color(248, 248, 248));
		f.setFocusPainted(false);
		f.setFont(f.getFont().deriveFont(12.0f));
		f.setSize(100, 40);
		
		g.setLocation(50, 280);
		g.setBackground(new Color(248, 248, 248));
		g.setFocusPainted(false);
		g.setFont(g.getFont().deriveFont(12.0f));
		g.setSize(100, 40);

		h.setLocation(200, 280);
		h.setBackground(new Color(248, 248, 248));
		h.setFocusPainted(false);
		h.setFont(h.getFont().deriveFont(12.0f));
		h.setSize(100, 40);
		
		i.setLocation(30, 470);
		i.setBackground(new Color(146, 133, 132));
		i.setFocusPainted(false);
		i.setFont(i.getFont().deriveFont(15.0f));
		i.setSize(125, 40);

		j.setLocation(190, 470);
		j.setBackground(new Color(146, 133, 132));
		j.setFocusPainted(false);
		j.setFont(j.getFont().deriveFont(15.0f));
		j.setSize(125, 40);
		
		//이전버튼 
		k.setLocation(10, 530);
		k.setBackground(new Color(248, 248, 248));
		k.setFocusPainted(false);
		k.setFont(k.getFont().deriveFont(10.0f));
		k.setSize(70, 25);
		
		k.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new MenuChoice(ac);
					setVisible(false);
				}
			}
		});
		
		//콤보박스
		JComboBox combo = new JComboBox();
		combo.setLocation(50, 420);
		combo.setFont(combo.getFont().deriveFont(15.0f));
		combo.setBackground(new Color(248, 248, 248));
		combo.addItem("                           1잔");
		combo.addItem("                           2잔");
		combo.addItem("                           3잔");
		combo.addItem("                           4잔");
		combo.addItem("                           5잔");
		combo.setSize(250, 30);
		
		
		//주문한 내용 // 레이블 -> 버튼 선택하면 똑같은 메뉴가 뜨게하기
		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.BLACK),"주문한 내용");
		oneTb.setTitleColor(Color.BLACK);
		JPanel onePan = new JPanel();
		onePan.setLayout(null);
		onePan.setBorder(oneTb);
		onePan.setBounds(50,330,250,80);
		onePan.setBackground(new Color(249, 242, 242));
		
		
		
		

		JLabel la = new JLabel();
		la.setSize(250, 40);
		la.setLocation(50, 400);
		la.setFont(checkout.getFont().deriveFont(15.0f));
		la.setBackground(new Color(248, 248, 248));
		
		cc.add(bar);
		cc.add(a);
		cc.add(b);
		cc.add(c);
		cc.add(d);
		cc.add(e);
		cc.add(f);
		cc.add(g);
		cc.add(h);
		cc.add(i);
		cc.add(j);
		cc.add(combo);
		cc.add(la);
		cc.add(k);
		input.add(la);
		
	this.add(onePan);
		
		this.add(cc);
		this.add(input);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
