package com.kh.project.reservation.view.BeverageGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.DrinkManager2;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class Drink extends JFrame {
	
	private Account ac = new Account();
	private DrinkManager2 dm = new DrinkManager2();

	JLabel title = new JLabel("음료메뉴");// 타이틀
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	JPanel cc = new JPanel();
	JPanel input = new JPanel(); // 레이블 박스
	JLabel cnum = new JLabel("수량을 선택하세요 :)");

	

	// 버튼
	JButton a = new JButton("아메리카노");
	JButton ia = new JButton("<html> &nbsp;	&nbsp; 아이스   <br>아메리카노</html>");
	JButton l = new JButton("카페라떼");
	JButton il = new JButton("<html> &nbsp;	 아이스   <br>카페라떼</html>");
	JButton c = new JButton("핫초코");
	JButton ic = new JButton("아이스초코");
	JButton st = new JButton("딸기우유");
	JButton lem = new JButton("레몬에이드");
	JButton in = new JButton("담기");
	JButton back = new JButton("< prev");
	JButton get = new JButton("구매");

	//콤보박스 
	String num[] = { "1", "2", "3", "4", "5" };
	JComboBox combo = new JComboBox(num);



	public Drink() {
	}

	public Drink(Account account) {
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

		// 버튼
		a.setLocation(50, 80);
		a.setBackground(new Color(248, 248, 248));
		a.setFocusPainted(false);
		a.setFont(a.getFont().deriveFont(12.0f));
		a.setSize(100, 50);

		ia.setLocation(200, 80);
		ia.setBackground(new Color(248, 248, 248));
		ia.setFocusPainted(false);
		ia.setFont(ia.getFont().deriveFont(12.0f));
		ia.setSize(100, 50);

		l.setLocation(50, 170);
		l.setBackground(new Color(248, 248, 248));
		l.setFocusPainted(false);
		l.setFont(l.getFont().deriveFont(12.0f));
		l.setSize(100, 50);

		il.setLocation(200, 170);
		il.setBackground(new Color(248, 248, 248));
		il.setFocusPainted(false);
		il.setFont(il.getFont().deriveFont(12.0f));
		il.setSize(100, 50);

		c.setLocation(50, 260);
		c.setBackground(new Color(248, 248, 248));
		c.setFocusPainted(false);
		c.setFont(c.getFont().deriveFont(12.0f));
		c.setSize(100, 50);

		ic.setLocation(200, 260);
		ic.setBackground(new Color(248, 248, 248));
		ic.setFocusPainted(false);
		ic.setFont(ic.getFont().deriveFont(12.0f));
		ic.setSize(100, 50);

		st.setLocation(50, 350);
		st.setBackground(new Color(248, 248, 248));
		st.setFocusPainted(false);
		st.setFont(st.getFont().deriveFont(12.0f));
		st.setSize(100, 50);

		lem.setLocation(200, 350);
		lem.setBackground(new Color(248, 248, 248));
		lem.setFocusPainted(false);
		lem.setFont(lem.getFont().deriveFont(12.0f));
		lem.setSize(100, 50);

		in.setLocation(40, 485);
		in.setBackground(new Color(146, 133, 132));
		in.setFocusPainted(false);
		in.setFont(in.getFont().deriveFont(17.0f));
		in.setSize(115, 37);

		back.setLocation(20, 530);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 25);
		
		get.setLocation(200, 485);
		get.setBackground(new Color(146, 133, 132));
		get.setFocusPainted(false);
		get.setFont(get.getFont().deriveFont(17.0f));
		get.setSize(115, 37);


		combo.setBounds(110, 450, 130, 27);
		combo.setFont(combo.getFont().deriveFont(14.0f));


		cnum.setLocation(100, 417);
		cnum.setFont(cnum.getFont().deriveFont(17.0f));
		cnum.setSize(300, 25);

		// 이벤트 효과
		a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "아메리카노";
					dm.menuget(str);

				}
			}
		});
		ia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "아이스아메리카노";
					dm.menuget(str);
				}
			}
		});
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "카페라떼";
					dm.menuget(str);

				}
			}
		});
		il.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "아이스카페라떼";
					dm.menuget(str);
				}
			}
		});
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "핫초코";
					dm.menuget(str);
				}
			}
		});
		ic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "아이스핫초코";
					dm.menuget(str);
				}
			}
		});
		st.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "딸기우유";
					dm.menuget(str);
				}
			}
		});
		lem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String str = "레몬에이드";
					dm.menuget(str);
				}
			}
		});
		in.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					int cc = count(); 

					String select = dm.select(account); // 
					System.out.println(select + " ㅈ드링크지유아이 셀렉트");// 테스트

					int total = dm.totalmoney(account);

					System.out.println("ㄴ셀렉트1!!!! : " + select);
					JOptionPane.showMessageDialog(null, "장바구니에 "+"\n"+select +"이 담겼습니다."+ "\n" +"결제하시려면 구매를 눌러주세요");

//					dialog = new MyDialog(new JFrame(), account, "장바구니");
//					dialog.setVisible(true);
				}
				
				
				
			}

		});
		get.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new DrinkBuy(account);
				}
			}
		});
		back.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new MenuChoice(ac);
					setVisible(false);
				}
			}
		});

		cc.add(bar);
		cc.add(a);
		cc.add(ia);
		cc.add(l);
		cc.add(il);
		cc.add(c);
		cc.add(ic);
		cc.add(st);
		cc.add(lem);
		cc.add(in);
		cc.add(cnum);
		cc.add(get);
		cc.add(back);
		cc.add(combo);

		this.add(cc);
		this.add(input);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//콤보박스 수량 넘기기
	public int count() {
		String change = combo.getSelectedItem().toString();
		dm.countsave(change);

		return Integer.valueOf(change);
	}

}


