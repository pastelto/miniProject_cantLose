
package com.kh.project.reservation.view;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.CheckAccount;
import com.kh.project.reservation.model.dao.MemberDao;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.BeverageGui.Drink;
import com.kh.project.reservation.view.Board.MList;
import com.kh.project.reservation.view.PrintGui.PrintServiceGui;
import com.kh.project.reservation.view.TicketGui.TicketGui;

public class MenuChoice extends JFrame {

	JLabel bar = new JLabel();
	JPanel mc = new JPanel();
	JButton b1 = new JButton("예		약");
	JButton b2 = new JButton("이용권 구매");
	JButton b3 = new JButton("음료 구매");
	JButton b4 = new JButton("프린트 서비스");
	JButton b5 = new JButton("예약정보 확인");
	JButton b6 = new JButton("내 정보");
	JButton b7 = new JButton("체크인 / 체크아웃");
	JButton b8 = new JButton("내 노트");
	JButton b9 = new JButton("로그아웃");
	JLabel userName = new JLabel();

	private CheckAccount ca = new CheckAccount();
	


	int xL, yL;
	Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit객체를 얻는다.
	Dimension screenSize = tk.getScreenSize();// 화면의 크기를 구한다.


	public MenuChoice(Account account) {

		// Menu 기본
		super("MenuChoice");
		this.setSize(360, 600);
		this.setLayout(null);
		mc.setBackground(new Color(249, 242, 242));
		mc.setLayout(null);
		mc.setSize(360, 600);
		// 화면 정중앙
		xL = screenSize.width / 2 - this.getWidth() / 2;
		yL = screenSize.height / 2 - this.getHeight() / 2;
		setLocation(xL, yL); // 화면 정중앙

		// 메뉴 타이틀
		this.setTitle("MENU");

		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("MENU  ");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);
		mc.add(bar);
		
		String accountName = account.getName().toString();
		userName = new JLabel("반갑습니다. " + accountName + "님");
		userName.setBounds(105, 100, 300, 50);
		userName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		
		JLabel humanIcon = new JLabel(new ImageIcon("images/humanIcon3.png"));
		humanIcon.setBounds(40,100,54,54);
		
		
		// 메뉴 버튼
		b1.setBounds(10, 180, 150, 50);
		b2.setBounds(180, 180, 150, 50);
		b3.setBounds(10, 240, 150, 50);
		b4.setBounds(180, 240, 150, 50);
		b5.setBounds(10, 300, 150, 50);
		b6.setBounds(180, 300, 150, 50);
		b7.setBounds(10, 360, 150, 50);
		b8.setBounds(180, 360, 150, 50);
		b9.setBounds(120, 500, 100, 30);

		// 메뉴 색상 --> 원하는대로 바꿔주세요~
		b1.setBackground(new Color(220, 118, 112)); // 택 (1) 색상 정하기
		b2.setBackground(new Color(220, 118, 112)); // 택 (2)
		b3.setBackground(new Color(220, 118, 112));
		b4.setBackground(new Color(220, 118, 112));
		b5.setBackground(new Color(220, 118, 112));
		b6.setBackground(new Color(220, 118, 112));
		b7.setBackground(new Color(220, 118, 112));
		b8.setBackground(new Color(220, 118, 112));
		b9.setBackground(new Color(220, 118, 112));

		b1.setForeground(Color.white); // 택 (1) 색상 정하기
		b2.setForeground(Color.white); // 택 (2)
		b3.setForeground(Color.white);
		b4.setForeground(Color.white);
		b5.setForeground(Color.white);
		b6.setForeground(Color.white);
		b7.setForeground(Color.white);
		b8.setForeground(Color.white);
		b9.setForeground(Color.white);
		
		b1.setFocusPainted(true);

		// 상단바 메뉴 폰트
		Font font = new Font("맑은 고딕", Font.BOLD, 15);

		// mTitle.setFont(font);
		bar.setFont(font);

		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 붙여넣기
		mc.add(bar);
		mc.add(b1);
		mc.add(b2);
		mc.add(b3);
		mc.add(b4);
		mc.add(b5);
		mc.add(b6);
		mc.add(b7);
		mc.add(b8);
		mc.add(b9);
		mc.add(humanIcon);
		mc.add(userName);

		this.add(mc);
		
 

		// 각 버튼 클릭시 연결 기능
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new BookView(account);
					setVisible(false);

				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b1.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b1.setBackground(new Color(220, 118, 112)); // 버튼색yu	
             } 
		});

		b2.addMouseListener(new MouseAdapter() { // 이용권구매
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new TicketGui(account);
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b2.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b2.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});

		b3.addMouseListener(new MouseAdapter() { // 음료 구매
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new Drink(account);
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b3.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b3.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});

		b4.addMouseListener(new MouseAdapter() { // 프린트
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new PrintServiceGui(account);
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b4.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b4.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});

		b5.addMouseListener(new MouseAdapter() { // 예약확인
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new BookView().checkBooking(account);
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b5.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b5.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});

		b6.addMouseListener(new MouseAdapter() { // 내정보
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new Check(account); 
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b6.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b6.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});

		b7.addMouseListener(new MouseAdapter() { // 체크인/체크아웃
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					new CheckIn(account);
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b7.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b7.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});

		b8.addMouseListener(new MouseAdapter() { // 내노트
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getButton() == 1) {
					new MList(account);
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b8.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b8.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});

		b9.addMouseListener(new MouseAdapter() { // 로그아웃 - 로그인화면
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					System.out.println(account.toString()); // 로그아웃 전 저장되었는지 확인 출력용
					new MemberDao().reSaveAccount(account);
					Login l = new Login();
					
					setVisible(false);
				}
			}
			 @Override
             public void mouseEntered(MouseEvent e) {
				 b9.setBackground(new Color(128, 128, 128)); // 버튼색
             }

             @Override
             public void mouseExited(MouseEvent e) {
            	 b9.setBackground(new Color(220, 118, 112)); // 버튼색
             } 
		});
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
