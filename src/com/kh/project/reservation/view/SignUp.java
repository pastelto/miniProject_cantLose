package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

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

public class SignUp extends JFrame {

	private ArrayList<Account> check = new ArrayList<>();
	private Account account = new Account();
	private CheckAccount ca = new CheckAccount();
	Scanner sc = new Scanner(System.in);

	JPanel SignUp = new JPanel();
	JLabel SignUp2 = new JLabel();
	String id;
	String pw;
	String name;
	String idNum;
	String phNum;
	String cardN;
	String bank;
	String bankN;

	public SignUp() {

		super("SignUp");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		JLabel bar = new JLabel();
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setSize(getMaximumSize());
		p.setBackground(new Color(249, 242, 242));

		JLabel l1 = new JLabel("아이디");
		JLabel l2 = new JLabel("비밀번호");
		JLabel l3 = new JLabel("이름");
		JLabel l4 = new JLabel("주민번호");
		JLabel l5 = new JLabel("전화번호");
		JLabel l6 = new JLabel("은행");
		JLabel l7 = new JLabel("계좌번호");

		JTextField idTF = new JTextField();
		JPasswordField pwTF = new JPasswordField();
		JTextField nameTF = new JTextField();
		JPasswordField idNTF = new JPasswordField();
		JTextField phone = new JTextField();
		JTextField bankTF = new JTextField();
		JTextField bankNTF = new JTextField();

		p.add(bar);
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(idTF);
		p.add(pwTF);
		p.add(nameTF);
		p.add(idNTF);
		p.add(phone);
		p.add(bankTF);
		p.add(bankNTF);

		JButton j1 = new JButton("가입");
		JButton j2 = new JButton("취소");
		p.add(j1);
		p.add(j2);
		
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34,80,54,54);
		
		JLabel bar1 = new JLabel(new ImageIcon("images/bar.png"));
		bar1.setBounds(0,0,360,53);
		p.add(bar1);
		p.add(image);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		l1.setBounds(120, 85, 45, 40);
		l2.setBounds(40, 130, 85, 40);
		l3.setBounds(40, 170, 65, 40);
		l4.setBounds(40, 210, 85, 40);
		l5.setBounds(40, 250, 65, 40);
		l6.setBounds(40, 290, 45, 40);
		l7.setBounds(40, 330, 65, 40);
		idTF.setBounds(180, 90, 145, 30);
		pwTF.setBounds(120, 130, 205, 30);
		nameTF.setBounds(120, 170, 205, 30);
		idNTF.setBounds(120, 210, 205, 30);
		phone.setBounds(120, 250, 205, 30);
		bankTF.setBounds(120, 290, 205, 30);
		bankNTF.setBounds(120, 330, 205, 30);
		j1.setBounds(80, 400, 80, 30);
		j2.setBounds(195, 400, 80, 30);
		this.add(p);

		       j1.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
					
					
					if(idTF.getText().equals("")||pwTF.getText().equals("")|| nameTF.getText().equals("")||idNTF.getText().equals("")||
						bankTF.getText().equals("")||bankNTF.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "정보를 입력해 주세요");
					} else if( (ca.checkId(idTF.getText()))) { //아이디 주민번호 중복일경우
						JOptionPane.showMessageDialog(null, "이미 가입된 아이디 입니다.");
					} else if(ca.checkIdNum(idNTF.getText())) {
						JOptionPane.showMessageDialog(null, "이미 가입된 주민번호 입니다.");
					}
					else {ca.writeAccount(new Account(idTF.getText(), pwTF.getText(), nameTF.getText(), idNTF.getText(), 
							phone.getText(), bankTF.getText(),bankNTF.getText(),0,0,0,0,1 ));
					ca.saveAccount();
					
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
						setVisible(false);
						new Login();
					}
				}
				
					
			});
		       this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}    
}

