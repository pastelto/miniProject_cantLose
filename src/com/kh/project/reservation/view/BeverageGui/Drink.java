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
import com.kh.project.reservation.model.vo.Beverage;
import com.kh.project.reservation.view.MenuChoice;

public class Drink extends JFrame {

	JLabel title = new JLabel("음료메뉴");// 타이틀
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	JPanel cc = new JPanel();
	JPanel input = new JPanel(); // 레이블 박스
	JLabel cnum = new JLabel("수량을 선택하세요 :)");

	Account ac = new Account();
	DrinkManager2 dm = new DrinkManager2();
	Beverage bb = new Beverage();

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
	JButton m = new JButton("구매");
	// JTextField tf = new JTextField();
	// JLabel jl = new JLabel("수량을 숫자로 입력하세요 :)");
	String num[] = { "1", "2", "3", "4", "5" };
	JComboBox combo = new JComboBox(num);

//	MyDialog dialog;

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
		a.setLocation(50, 90);
		a.setBackground(new Color(248, 248, 248));
		a.setFocusPainted(false);
		a.setFont(a.getFont().deriveFont(12.0f));
		a.setSize(100, 50);

		b.setLocation(200, 90);
		b.setBackground(new Color(248, 248, 248));
		b.setFocusPainted(false);
		b.setFont(b.getFont().deriveFont(12.0f));
		b.setSize(100, 50);

		c.setLocation(50, 180);
		c.setBackground(new Color(248, 248, 248));
		c.setFocusPainted(false);
		c.setFont(c.getFont().deriveFont(12.0f));
		c.setSize(100, 50);

		d.setLocation(200, 180);
		d.setBackground(new Color(248, 248, 248));
		d.setFocusPainted(false);
		d.setFont(d.getFont().deriveFont(12.0f));
		d.setSize(100, 50);

		e.setLocation(50, 270);
		e.setBackground(new Color(248, 248, 248));
		e.setFocusPainted(false);
		e.setFont(e.getFont().deriveFont(12.0f));
		e.setSize(100, 50);

		f.setLocation(200, 270);
		f.setBackground(new Color(248, 248, 248));
		f.setFocusPainted(false);
		f.setFont(f.getFont().deriveFont(12.0f));
		f.setSize(100, 50);

		g.setLocation(50, 360);
		g.setBackground(new Color(248, 248, 248));
		g.setFocusPainted(false);
		g.setFont(g.getFont().deriveFont(12.0f));
		g.setSize(100, 50);

		h.setLocation(200, 360);
		h.setBackground(new Color(248, 248, 248));
		h.setFocusPainted(false);
		h.setFont(h.getFont().deriveFont(12.0f));
		h.setSize(100, 50);

		i.setLocation(220, 490);
		i.setBackground(new Color(146, 133, 132));
		i.setFocusPainted(false);
		i.setFont(i.getFont().deriveFont(17.0f));
		i.setSize(115, 37);

		k.setLocation(25, 520);
		k.setBackground(new Color(248, 248, 248));
		k.setFocusPainted(false);
		k.setFont(k.getFont().deriveFont(10.0f));
		k.setSize(70, 25);
		
		m.setLocation(30, 490);
		m.setBackground(new Color(146, 133, 132));
		m.setFocusPainted(false);
		m.setFont(m.getFont().deriveFont(17.0f));
		m.setSize(115, 37);

//		jl.setLocation(75, 430);
//		jl.setBackground(new Color(237, 243, 252));
//		jl.setFont(jl.getFont().deriveFont(16.0f));
//		jl.setSize(300, 30);
		combo.setBounds(120, 450, 130, 27);
		combo.setFont(combo.getFont().deriveFont(14.0f));
//		tf.setLocation(150, 470);
//		tf.setBackground(new Color(248, 248, 248));
//		tf.setFont(tf.getFont().deriveFont(17.0f));
//		tf.setSize(50, 30);

		cnum.setLocation(100, 420);
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
					int cc = count();

					int numS = 0;
					numS += cc;

					String select = dm.select(account); // 어레이리스트 버전

					System.out.println(select + " ㅈ드링크지유아이 셀렉트");// 테스트

					int total = dm.totalmoney(account);

					System.out.println("ㄴ셀렉트1!!!! : " + select);
					JOptionPane.showMessageDialog(null, "<html>음료가 담겼습니다.<br> 결제하시려면 구매를 눌러주세요");

//					dialog = new MyDialog(new JFrame(), account, "장바구니");
//					dialog.setVisible(true);
				}
				
				
				
			}

		});
		//구매
		m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new DrinkBuy(account);
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
		cc.add(cnum);
		cc.add(m);
		cc.add(k);
		// cc.add(tf);
		// cc.add(jl);
		cc.add(combo);

		this.add(cc);
		this.add(input);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public int count() {
		// 수량 넘기기
		String change = combo.getSelectedItem().toString();
		dm.countsave(change);

		return Integer.valueOf(change);
	}

}

////장바구니 다이얼로그
//class MyDialog extends JDialog {
//
//	Beverage b = new Beverage();
//	DrinkManager2 dm = new DrinkManager2();
//
//	// JLabel label = new JLabel(dm.menusave()+ "dldididi"); // 다이얼로그 문구
//	JLabel label2 = new JLabel("더 담으시겠습니까?"); // 다이얼로그 문구
//	JButton okBtn = new JButton("OK"); // 버튼 1
//	JButton noBtn = new JButton("NO"); // 버튼 2
//
//	boolean result;
//
//	public MyDialog(JFrame frame, Account account, String title) {
//
//		super(frame, title);
//		setLocation(610, 400); // 다이얼로그 위치
//		setSize(250, 150); // 다이얼로그 창 크기
//		setLayout(null); // 다이얼로그 프레임 종류
//
////		label.setBounds(0, 0, 240, 50); // 레이블 위치 및 크기 지정
////		label.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
////		label.setFont(label.getFont().deriveFont(15.0f));
//
//		label2.setBounds(0, 20, 240, 50); // 레이블 위치 및 크기 지정
//		label2.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
//		label2.setFont(label2.getFont().deriveFont(15.0f));
//
//		okBtn.setBounds(20, 60, 70, 30); // 버튼 위치 및 크기 지정
//		okBtn.setBackground(new Color(220, 118, 112));
//
//		noBtn.setBounds(140, 60, 70, 30); // 버튼 위치 및 크기 지정
//		noBtn.setBackground(new Color(220, 118, 112));
//
//		// add(label);
//		add(label2);
//		add(okBtn);
//		add(noBtn);
//
//		okBtn.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// 버튼 클릭시 발생 할 이벤트
//				result = true;
//
//				if (result) {
//
//					setVisible(false);
//				}
//			}
//		});
//
//		noBtn.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//
//				new DrinkBuy(account); // 이창 어케 꺼 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ어카운트 넣어야하나
//				setVisible(false);
//
//			}
//
//		});
//	}
//
//}
