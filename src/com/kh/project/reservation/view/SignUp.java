package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	
	JLabel bar = new JLabel(); 
	JButton done = new JButton("입력 완료");
	JTextField idTF = new JTextField("아이디");
	JPasswordField pwTF= new JPasswordField("비밀번호");
	JPasswordField idNTF = new JPasswordField("주민법호");
	JTextField phone = new JTextField("전화번호");
	JTextField card = new JTextField("결제 방법 :     CARD");
	JTextField bankTF = new JTextField("결제 정보");
	JTextField bankNTF = new JTextField();
	
	JPanel SignUp= new JPanel(); 
	JLabel SignUp2= new JLabel(); 
	
	public SignUp() {
		
		super("SignUp");
		this.setSize(360,600);
		this.setLocationRelativeTo(null);  // 창 가운데로 켜지게 설정
		this.setLayout(null);
		SignUp.setBackground(new Color(249, 242, 242)); // 배경색 설정
				
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34,80,54,54);
		
		SignUp.setLayout(null);
		SignUp.setSize(getMaximumSize());
		
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0,0,360,53);
		
		idTF.setLocation(100,80);
		idTF.setSize(210,54);
		
		pwTF.setLocation(40,145);
		pwTF.setSize(270,54);
		
		idNTF.setLocation(40,210);
		idNTF.setSize(270,54);
		
		phone.setLocation(40,275);
		phone.setSize(270,54);
		
		card.setLocation(40,340);
		card.setSize(270,54);
		
		bankTF.setLocation(40,405);
		bankTF.setSize(80,54);
		
		bankNTF.setLocation(130,405);
		bankNTF.setSize(180,54);
		
		done.setLocation(40,470);
		done.setSize(270,54);
		
		SignUp.add(image);
		SignUp.add(idTF);
		SignUp.add(pwTF);
		SignUp.add(idNTF);
		SignUp.add(phone);
		SignUp.add(card);
		SignUp.add(idTF);
		SignUp.add(bankTF);
		SignUp.add(bankNTF);
		SignUp.add(bar);
		SignUp.add(done);
		
		this.add(SignUp);
		
		done.addMouseListener(new MouseAdapter() { // 회원가입 클릭시 일치하면 여기

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==1) {
				
				}
				JLabel popupCoffee = new JLabel();
				popupCoffee.setBounds(20,110,280,333);
				
			} 
		
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
