package com.kh.project.reservation.view.BeverageGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.DrinkManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class Drink extends JFrame {

	private DrinkManager dm = new DrinkManager();

	JLabel title = new JLabel("음료메뉴");// 타이틀
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	Font font2 = new Font("맑은 고딕", Font.BOLD, 13);
	Font font3 = new Font("맑은 고딕", Font.BOLD, 20);
	JPanel cc = new JPanel();
	JPanel input = new JPanel(); // 레이블 박스

	// 버튼
	JButton a = new JButton("아메리카노");
	JButton ia = new JButton("<html> &nbsp;	&nbsp; 아이스   <br>아메리카노</html>");
	JButton l = new JButton("카페라떼");
	JButton il = new JButton("<html> &nbsp;	 아이스   <br>카페라떼</html>");
	JButton c = new JButton("핫초코");
	JButton ic = new JButton("아이스초코");
	JButton st = new JButton("딸기우유");
	JButton lem = new JButton("레몬에이드");
	JButton in = new JButton("장바구니");
	JButton back = new JButton("뒤로");
	JButton get = new JButton("구매");
	JButton coupon = new JButton("쿠폰사용");

	// 콤보박스
	String num[] = { "수량을 선택하세요", "1", "2", "3", "4", "5" };
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
		
		//로고
		try {
            this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
         } catch (IOException e) {
            e.printStackTrace();
         }

		// 쿠폰 띄어주기
		JLabel mycoupon = new JLabel("나의 쿠폰 갯수 : " + account.getCoupon() + " 장 ");
		mycoupon.setLocation(90, 400);
		mycoupon.setFont(mycoupon.getFont().deriveFont(17.0f));
		mycoupon.setSize(300, 25);

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("Beverage ");
		bar.setForeground(Color.white);
		bar.setFont(font3);
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
		ia.setFont(font);
		ia.setSize(100, 50); 

		l.setLocation(50, 160);
		l.setBackground(new Color(248, 248, 248));
		l.setFocusPainted(false);
		l.setFont(font);
		l.setSize(100, 50);

		il.setLocation(200, 160);
		il.setBackground(new Color(248, 248, 248));
		il.setFocusPainted(false);
		il.setFont(font);
		il.setSize(100, 50);

		c.setLocation(50, 250);
		c.setBackground(new Color(248, 248, 248));
		c.setFocusPainted(false);
		c.setFont(font);
		c.setSize(100, 50);

		ic.setLocation(200, 250);
		ic.setBackground(new Color(248, 248, 248));
		ic.setFocusPainted(false);
		ic.setFont(font);
		ic.setSize(100, 50);

		st.setLocation(50, 340);
		st.setBackground(new Color(248, 248, 248));
		st.setFocusPainted(false);
		st.setFont(font);
		st.setSize(100, 50);

		lem.setLocation(200, 340);
		lem.setBackground(new Color(248, 248, 248));
		lem.setFocusPainted(false);
		lem.setFont(font);
		lem.setSize(100, 50);

		in.setLocation(20, 485);
		in.setBackground(new Color(220, 118, 112));
		in.setFocusPainted(false);
		in.setForeground(Color.white);
		in.setFont(font);
		in.setSize(100, 30);

		back.setLocation(20, 530);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(font2);
		back.setSize(70, 25);

		get.setLocation(230, 485);
		get.setBackground(new Color(220, 118, 112));
		get.setFocusPainted(false);
		get.setForeground(Color.white);
		get.setFont(font2);
		get.setSize(100, 30);

		coupon.setLocation(125, 485);
		coupon.setBackground(new Color(220, 118, 112));
		coupon.setFocusPainted(false);
		coupon.setForeground(Color.white);
		coupon.setFont(font2);
		coupon.setSize(100, 30);

		combo.setBounds(100, 440, 160, 27);
		combo.setFont(font2);

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
					count(); // 콤보박스 수량 넘기기
					String select = dm.select(account); // 옵션에 장바구니 띄우려고
					dm.totalmoney(account); //계산

					JOptionPane.showMessageDialog(null, "장바구니에 " + "\n" + select + "이 담겼습니다.");

				}

			}

		});
		in.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨
			@Override
			public void mouseEntered(MouseEvent e) {
				in.setBackground(new Color(128, 128, 128)); // 버튼색
			}
			@Override
			public void mouseExited(MouseEvent e) {
				in.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});
		get.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					int num = dm.totalmoney(account);// 총금액
					JOptionPane.showMessageDialog(null,
							"<html> 결제금액은 " + num + "원 입니다.<br> 등록하신 " + account.getPay() + "로 자동결제 되었습니다.</html>");
				}
				
				account.setBeverage(0);
				
				setVisible(false);
				new MenuChoice(account);
			}
		});
		get.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨
			@Override
			public void mouseEntered(MouseEvent e) {
				get.setBackground(new Color(128, 128, 128)); // 버튼색
			}
			@Override
			public void mouseExited(MouseEvent e) {
				get.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});

		coupon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					int num = dm.totalmoney(account);// 총금액
					int discount = dm.buydrink(account); // 할인금액

					JOptionPane.showMessageDialog(null,
							"<html> 총 금액은 " + num + "원 입니다.<br>쿠폰을 사용하여 " + discount + "원 할인되었습니다.</html> ");
					JOptionPane.showMessageDialog(null, "<html> 남은 금액인 " + (num - discount) + "원은 <br>등록하신 "
							+ account.getPay() + "로 자동결제 되었습니다</html>");
				}
				
				account.setBeverage(0);
				account.setCoupon(0); // 쿠폰쓴거 차감
				
				new MenuChoice(account);
				setVisible(false);
			}
		});
		coupon.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				coupon.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				coupon.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});

		back.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new MenuChoice(account);
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
		cc.add(get);
		cc.add(back);
		cc.add(combo);
		cc.add(coupon);
		cc.add(mycoupon);

		this.add(cc);
		this.add(input);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 콤보박스 수량 넘기기
	public int count() {
		String change = combo.getSelectedItem().toString();
		dm.countsave(change);

		return Integer.valueOf(change);
	}

}
