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

import com.kh.project.reservation.controller.DrinkManager;
import com.kh.project.reservation.controller.DrinkManager2;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Beverage;
import com.kh.project.reservation.view.MenuChoice;

public class DrinkBuy extends JFrame{
	
	JLabel title = new JLabel("음료메뉴");// 타이틀 
	Font font = new Font("함초롬돋움", Font.BOLD, 30);
	JPanel cc = new JPanel();
	JPanel input = new JPanel(); // 레이블 박스
	Account account = new Account();
	DrinkManager2 dm = new DrinkManager2();
	Beverage b = new Beverage();
	Drink d = new Drink();
	
	BuyDialog dialog;
	
	
	//버튼
	JButton a = new JButton("구매");
	//JLabel list = new JLabel(dm.menusave());
	//JLabel list = new JLabel("테스트");
	public DrinkBuy(Account account) {
		super("Beverage");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		cc.setBackground(new Color(249, 242, 242)); // 배경색 설정
		cc.setLayout(null);
		cc.setSize(getMaximumSize());
		dialog = new BuyDialog(new JFrame(), account , "결제");
	
		
		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("Beverage  ");
		bar.setFont(bar.getFont().deriveFont(20.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);
		
//		// 주문한 내용 // 레이블 -> 버튼 선택하면 똑같은 메뉴가 뜨게하기
//		TitledBorder oneTb = new TitledBorder(new LineBorder(Color.BLACK), "주문한 내용");
//		oneTb.setTitleColor(Color.BLACK);
//		JPanel onePan = new JPanel();
////		String order = dm.menusave();
//		
//		JLabel orderTotal = new JLabel(dm.menusave());
//		onePan.setLayout(null);
//		onePan.setBorder(oneTb);
//		onePan.setBounds(50, 80, 250, 300);
//		onePan.setBackground(new Color(249, 242, 242));
//		onePan.setFont(a.getFont().deriveFont(30.0f)); // 크기 왜 안바뀜 ㅠ
		
		//주문내용
		//String result = dm.menusave(select);
		
		
		String menu = dm.select(account);
		System.out.println(menu+ "드링크바이 지유아이");
		
		JLabel con = new JLabel(menu);
		
		con.setBounds(50, 120, 240, 50); // 레이블 위치 및 크기 지정
		con.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		con.setFont(con.getFont().deriveFont(15.0f));
		
		//총금액
		int num = dm.totalmoney(account);
		JLabel totalS = new JLabel("총금액 : "+ num);
		
		totalS.setBounds(50, 150, 240, 50); // 레이블 위치 및 크기 지정
		totalS.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		totalS.setFont(totalS.getFont().deriveFont(15.0f));
		
		
		a.setLocation(110, 470);
		a.setBackground(new Color(146, 133, 132));
		a.setFocusPainted(false);
		a.setFont(a.getFont().deriveFont(15.0f));
		a.setSize(125, 40);
		
		//list.setLocation(140, 410);
		//list.setFont(a.getFont().deriveFont(15.0f));
		//list.setSize(125, 40);
		//list.setVerticalTextPosition(JLabel.TOP);
		
		//이벤트 효과
		a.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					System.out.println(b.getTemp()); // 테스트
					//dm.buydrink();
					dialog.setVisible(true);
				}
			}
		});
		
		
		
		cc.add(bar);
		//cc.add(onePan);
		cc.add(bar);
		cc.add(bar);
		cc.add(a);
		cc.add(con);
		cc.add(totalS);
		//cc.add(list);
		
		
		//this.add(onePan);
		
		this.add(cc);
		this.add(input);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
	}


}
/*
//결제 다이얼로그 이상하게 나옴 일단 냅둠
class BuyDialog extends JDialog {


	DrinkManager dm = new DrinkManager();
	Beverage b = new Beverage();
	
	boolean result;

	public BuyDialog(JFrame frame,Account account, String title) {

		super(frame, title);
		setLocation(599,380); // 다이얼로그 위치
		setSize(270, 170); // 다이얼로그 창 크기
		
		//버튼
		JLabel label = new JLabel("<html> 사용가능한 쿠폰이  <br>"+"&nbsp; &nbsp; " +account.getCoupon() + "장 있습니다. <br>사용하시겠습니까?</html>"); // 다이얼로그 문구
		JButton okBtn = new JButton("OK"); // 버튼 1
		JButton noBtn = new JButton("NO"); // 버튼 2

		label.setBounds(0, 10, 250, 60); // 레이블 위치 및 크기 지정
		label.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
		label.setFont(label.getFont().deriveFont(14.0f));

		okBtn.setBounds(20, 80, 70, 30); // 버튼 위치 및 크기 지정
		okBtn.setBackground(new Color(220, 118, 112));

		noBtn.setBounds(160, 80, 70, 10); // 버튼 위치 및 크기 지정
		noBtn.setBackground(new Color(220, 118, 112));

		add(label);
		add(okBtn);
		add(noBtn);

		okBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼 클릭시 발생 할 이벤트
				result = true;
				
				if (result) {
				
					JOptionPane.showMessageDialog(null, "쿠폰을 사용하여 " + b.getDiscount() + "원 할인되었습니다. "); 
					JOptionPane.showMessageDialog(null, "<html> 남은 금액인 " + (b.getTemp() - b.getDiscount()) + "원은 <br>등록하신 " + account.getPay() + "로 자동결제 되었습니다</html>"); 
					new MenuChoice(account);
					setVisible(false);
				}
			}
		});

		noBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
	
				JOptionPane.showMessageDialog(null, "등록하신 "+ account.getPay() + "로 자동결제 되었습니다."); 
				setVisible(false);

				new MenuChoice(account);

			}

		});
	}

}*/

//결제 다이얼로그
class BuyDialog extends JDialog {

	Beverage b = new Beverage();
	DrinkManager dm = new DrinkManager();
	
	
	boolean result;

	public BuyDialog(JFrame frame,Account account, String title) {

		super(frame, title);
		setLocation(599,380); // 다이얼로그 위치
		setSize(270, 170); // 다이얼로그 창 크기
		setLayout(null); // 다이얼로그 프레임 종류
		
		JLabel label = new JLabel("<html> 사용가능한 쿠폰이  <br>"+"&nbsp; &nbsp; " +account.getCoupon() + "장 있습니다. <br>사용하시겠습니까?</html>"); // 다이얼로그 문구
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

		okBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// 버튼 클릭시 발생 할 이벤트
				result = true;
				
				if (result) {
				
					JOptionPane.showMessageDialog(null, "<html> 총 금액은 "+ b.getTemp()+"원 입니다.<br>쿠폰을 사용하여 " + b.getDiscount() + "원 할인되었습니다.</html> ");
					JOptionPane.showMessageDialog(null, "<html> 남은 금액인 " + (b.getTemp() - b.getDiscount()) + "원은 <br>등록하신 " + account.getPay() + "로 자동결제 되었습니다</html>"); 

					setVisible(false);
					
					new MenuChoice(account);
				}
			}
		});

		noBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
	
				JOptionPane.showMessageDialog(null, "<html> 결제금액은 "+ b.getTemp()+"원 입니다.<br> 등록하신 "+ account.getPay() + "로 자동결제 되었습니다.</html>"); 
				setVisible(false);

				new MenuChoice(account);
			}

		});
	}

}




