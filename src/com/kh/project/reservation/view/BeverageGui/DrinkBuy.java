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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.DrinkManager2;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;


public class DrinkBuy extends JFrame {

	DrinkManager2 dm = new DrinkManager2();
	Drink d = new Drink();

	JLabel title = new JLabel("음료메뉴");// 타이틀
	BuyDialog dialog;

	public DrinkBuy(Account account) {
		super("Beverage");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);
		
		//패널설정
		JPanel cc = new JPanel();
		Font font = new Font("함초롬돋움", Font.BOLD, 30);
		cc.setBackground(new Color(249, 242, 242)); // 배경색 설정
		cc.setLayout(null);
		cc.setSize(getMaximumSize());
		dialog = new BuyDialog(new JFrame(), account, "결제");

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("Beverage  ");
		bar.setFont(bar.getFont().deriveFont(20.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);
//		
//		// 머그이미지
//		JLabel image = new JLabel(new ImageIcon("images/mug.png"));
//		image.setBounds(150, 300, 200, 200);

		// 장바구니라벨
		JLabel cart = new JLabel("<주문 내역>");
		cart.setBounds(50, 100, 240, 50); // 레이블 위치 및 크기 지정
		cart.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		cart.setFont(cart.getFont().deriveFont(30.0f));

		// 메뉴!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!왜
		String menu = dm.select(account);
		System.out.println(menu + "드링크바이 지유아이");
		JLabel con = new JLabel(menu);
		con.setBounds(50, 200, 240, 50); // 레이블 위치 및 크기 지정
		con.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		con.setFont(con.getFont().deriveFont(23.0f));

		// 총금액
		int num = dm.totalmoney(account);
		JLabel totalS = new JLabel("총 금액 : " + num + "원");
		totalS.setBounds(30, 350, 240, 50); // 레이블 위치 및 크기 지정
		totalS.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		totalS.setFont(totalS.getFont().deriveFont(20.0f));

		// 버튼
		JButton a = new JButton("구매");
		a.setLocation(110, 470);
		a.setBackground(new Color(146, 133, 132));
		a.setFocusPainted(false);
		a.setFont(a.getFont().deriveFont(15.0f));
		a.setSize(125, 40);

		// 이벤트 효과
		a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					dialog.setVisible(true);
				}
			}
		});

		cc.add(bar);
		cc.add(bar);
		cc.add(bar);
		cc.add(a);
		cc.add(con);
		cc.add(cart);
		cc.add(totalS);
//		cc.add(image);

		this.add(cc);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

//결제 다이얼로그
class BuyDialog extends JDialog {
	
	DrinkManager2 dm = new DrinkManager2();

	public BuyDialog(JFrame frame, Account account, String title) {

		super(frame, title);
		setLocation(599, 380); // 다이얼로그 위치
		setSize(270, 170); // 다이얼로그 창 크기
		setLayout(null); // 다이얼로그 프레임 종류

		JLabel label = new JLabel(
				"<html> 사용가능한 쿠폰이  <br>" + "&nbsp; &nbsp; " + account.getCoupon() + "장 있습니다. <br>사용하시겠습니까?</html>"); // 다이얼로그
																														// 문구
		JButton okBtn = new JButton("OK"); // 버튼 1
		JButton noBtn = new JButton("NO"); // 버튼 2

		label.setBounds(0, 10, 250, 60); // 레이블 위치 및 크기 지정
		label.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		label.setFont(label.getFont().deriveFont(14.0f));

		okBtn.setBounds(20, 80, 70, 30); // 버튼 위치 및 크기 지정
		okBtn.setBackground(new Color(220, 118, 112));

		noBtn.setBounds(160, 80, 70, 30); // 버튼 위치 및 크기 지정
		noBtn.setBackground(new Color(220, 118, 112));

		add(label);
		add(okBtn);
		add(noBtn);
		
		//다이얼로그에 넣을 변수들 
		int num = dm.totalmoney(account);// 총금액
		int discount = dm.buydrink(account); // 할인금액

	
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null,
						"<html> 총 금액은 " + num + "원 입니다.<br>쿠폰을 사용하여 " + discount + "원 할인되었습니다.</html> ");
				JOptionPane.showMessageDialog(null, "<html> 남은 금액인 " + (num - discount) + "원은 <br>등록하신 "
						+ account.getPay() + "로 자동결제 되었습니다</html>");

				setVisible(false);
				account.setBeverage(0); // 수량 다시 세팅
				
				// 사용한 쿠폰 갯수 만큼 변경 해주기
				// account.setCoupon(0);
				
				new MenuChoice(account);

			}
		});

		noBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JOptionPane.showMessageDialog(null,
						"<html> 결제금액은 " + num + "원 입니다.<br> 등록하신 " + account.getPay() + "로 자동결제 되었습니다.</html>");
				setVisible(false);
				account.setBeverage(0); // 수량 다시 세팅
				new MenuChoice(account);
			}

		});
	}
	
}
