package com.kh.project.reservation.view.BeverageGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.DrinkManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class Drink extends JFrame{
	
	JLabel title = new JLabel("음료메뉴");// 타이틀 
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	JPanel cc = new JPanel();
	JPanel input = new JPanel(); // 레이블 박스
	Account ac = new Account();
	DrinkManager dm = new DrinkManager();

	// 버튼
	JButton a = new JButton("아메리카노");
	JButton b = new JButton("<html> &nbsp;	&nbsp; 아이스   <br>아메리카노</html>");
	JButton c = new JButton("카페라떼");
	JButton d = new JButton("<html> &nbsp;	 아이스   <br>카페라떼</html>");
	JButton e = new JButton("핫초코");
	JButton f = new JButton("아이스초코");
	JButton g = new JButton("딸기우유");
	JButton h = new JButton("레몬에이드");
	JButton i = new JButton("담기");
	JButton k = new JButton("< prev");
	JTextField tf = new JTextField();
	JLabel jl = new JLabel("수량을 숫자로 입력하세요 :)");

	
	
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

		/*//이거뭐지
		JLabel la = new JLabel();
		la.setSize(250, 40);
		la.setLocation(50, 400);
		la.setFont(la.getFont().deriveFont(15.0f));
		la.setBackground(new Color(248, 248, 248));
		*/

		// 버튼
		a.setLocation(50, 70);
		a.setBackground(new Color(248, 248, 248));
		a.setFocusPainted(false);
		a.setFont(a.getFont().deriveFont(12.0f));
		a.setSize(100, 60);

		b.setLocation(200, 70);
		b.setBackground(new Color(248, 248, 248));
		b.setFocusPainted(false);
		b.setFont(b.getFont().deriveFont(12.0f));
		b.setSize(100, 60);

		c.setLocation(50, 160);
		c.setBackground(new Color(248, 248, 248));
		c.setFocusPainted(false);
		c.setFont(c.getFont().deriveFont(12.0f));
		c.setSize(100, 60);

		d.setLocation(200, 160);
		d.setBackground(new Color(248, 248, 248));
		d.setFocusPainted(false);
		d.setFont(d.getFont().deriveFont(12.0f));
		d.setSize(100, 60);

		e.setLocation(50, 250);
		e.setBackground(new Color(248, 248, 248));
		e.setFocusPainted(false);
		e.setFont(e.getFont().deriveFont(12.0f));
		e.setSize(100, 60);

		f.setLocation(200, 250);
		f.setBackground(new Color(248, 248, 248));
		f.setFocusPainted(false);
		f.setFont(f.getFont().deriveFont(12.0f));
		f.setSize(100, 60);

		g.setLocation(50, 340);
		g.setBackground(new Color(248, 248, 248));
		g.setFocusPainted(false);
		g.setFont(g.getFont().deriveFont(12.0f));
		g.setSize(100, 60);

		h.setLocation(200, 340);
		h.setBackground(new Color(248, 248, 248));
		h.setFocusPainted(false);
		h.setFont(h.getFont().deriveFont(12.0f));
		h.setSize(100, 60);
		
		i.setLocation(230, 500);
		i.setBackground(new Color(146, 133, 132));
		i.setFocusPainted(false);
		i.setFont(i.getFont().deriveFont(15.0f));
		i.setSize(100, 40);
		
		k.setLocation(10, 530);
		k.setBackground(new Color(248, 248, 248));
		k.setFocusPainted(false);
		k.setFont(k.getFont().deriveFont(10.0f));
		k.setSize(70, 25);
		
		jl.setLocation(75, 430);
		jl.setBackground(new Color(237, 243, 252));
		jl.setFont(jl.getFont().deriveFont(16.0f));
		jl.setSize(300, 30);
		
		tf.setLocation(150, 470);
		tf.setBackground(new Color(248, 248, 248));
		tf.setFont(tf.getFont().deriveFont(17.0f));
		tf.setSize(50, 30);
		
		
		
		//이벤트 효과
		a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "아메리카노";
				dm.menuget(str);
				}
			}
		});
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "아이스아메리카노";
				dm.menuget(str);
				}
			}
		});
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "카페라떼";
				dm.menuget(str);
				}
			}
		});
		d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "아이스카페라떼";
				dm.menuget(str);
				}
			}
		});
		e.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "핫초코";
				dm.menuget(str);
				}
			}
		});
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "아이스핫초코";
				dm.menuget(str);
				}
			}
		});
		g.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "딸기우유";
				dm.menuget(str);
				}
			}
		});
		h.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				String str = "레몬에이드";
				dm.menuget(str);
				}
			}
		});
		i.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					count();
					dm.select();
					
				}
			}
		});
		k.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
				new MenuChoice(ac);
					setVisible(false);
				}
			}
		});
		
		String count = tf.getText();
		
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


		cc.add(k);
		cc.add(tf);
		cc.add(jl);
		
		

		this.add(cc);
		this.add(input);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void count() {
		//수량 넘기기 
		String count = tf.getText();
				System.out.println("이거 드링크에 메소드에서 수량 넘기기"+count);
				
				dm.countsave(count);
	}
	
}

