package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.CheckAccount;
import com.kh.project.reservation.model.vo.Account;

public class FindAccount extends JFrame{
	
	JPanel FindP = new JPanel();
	JLabel l1 = new JLabel("이   름");
	JLabel l2 = new JLabel("주민번호");
	JTextField Name = new JTextField();
	JTextField idNum1 = new JTextField();
	JPasswordField idNum2 = new JPasswordField();
	JLabel l3 = new JLabel("-");
	private CheckAccount ca = new CheckAccount();
	private ArrayList<Account> checkName = new ArrayList<>();
	private Account account = new Account();
	
	public FindAccount() {
		
		super("FindAccount");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		FindP.setLayout(null);
		FindP.setSize(getMaximumSize());
		FindP.setBackground(new Color(249, 242, 242)); // 배경색 설정
		
		JLabel image = new JLabel(new ImageIcon("images/logo.png"));
		image.setBounds(95, 95, 150, 140);
		
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0,0,360,53);
		FindP.add(bar);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 30);
		
		
		l3.setFont(font2);
		
		l1.setLocation(53, 255);
		l1.setSize(220, 45);
		
		Name.setLocation(110, 255);
		Name.setSize(200, 45);
		
		l2.setLocation(50, 315);
		l2.setSize(220, 45);
		
		idNum1.setLocation(110, 315);
		idNum1.setSize(90, 45);
		
		idNum2.setLocation(220, 315);
		idNum2.setSize(90, 45);
		
		l3.setLocation(204, 311);
		l3.setSize(220, 45);
		
		JButton j1 = new JButton("찾기");
		JButton j2 = new JButton("취소");
		FindP.add(j1);
		FindP.add(j2);
		
		j1.setBounds(50, 400, 110, 35);
		j2.setBounds(200, 400, 110, 35);
		
		FindP.add(l1);
		FindP.add(l2);
		FindP.add(Name);
		FindP.add(idNum1);
		FindP.add(idNum2);
		FindP.add(image);
		FindP.add(l3);
		
		this.add(FindP);
		
		 j1.addActionListener(new ActionListener() { // 찾기 버튼
				String idNum = idNum1.getText()+"-"+idNum2.getText();
				@Override
				public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
					
					if(Name.getText().equals("")||idNum1.getText().equals("")||idNum2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "정보를 입력해 주세요");
					}else if(idNum1.getText().length()!=6||idNum2.getText().length()!=7) { // 글자갯수 제한
							JOptionPane.showMessageDialog(null, "정확한 주민번호를 입력해주세요!");
					} else {ArrayList<Account> checkName = ca.find(Name.getText(),idNum); //아이디 주민번호 중복일경우
					
						if (checkName.isEmpty()) {
							JOptionPane.showMessageDialog(null, "일치하는 회원정보가 없습니다.");
						} 
						else {
							String id = checkName.get(0).getId();
							String pw = checkName.get(0).getPw();
							JOptionPane.showMessageDialog(null, "ID : "+id + ",     PW : "+pw);
					}
					}
				}
			});
		 
		 j2.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent T) {//로그인 페이지로 돌아감
	    		   setVisible(false);
	    		   new Login();
	    	   }
	       });
	       
		 
		 
		 // 상단바 로고
			try {
				this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
       this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	protected int Account(ArrayList<Account> arrayList) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
