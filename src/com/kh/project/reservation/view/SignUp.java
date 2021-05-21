package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.User;

public class SignUp extends JFrame {

	private Account account = new Account();
	private User user = new User();
	
	Scanner sc = new Scanner(System.in);
	ArrayList<User> list = new ArrayList<>();
	JLabel bar = new JLabel();
	JButton done = new JButton("입력 완료");
	JTextField idTF = new JTextField("아이디");
	JPasswordField pwTF = new JPasswordField("비밀번호");
	JTextField nameTF = new JTextField("이름");
	JPasswordField idNTF = new JPasswordField("주민번호");
	JTextField phone = new JTextField("전화번호");
	JTextField card = new JTextField("결제 방법 :     CARD");
	JTextField bankTF = new JTextField("결제 정보");
	JTextField bankNTF = new JTextField();
	JDialog dialog = new JDialog();
	JPanel singpuP = new JPanel();

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
		JLabel l6 = new JLabel("결제 방법");
		JLabel l7 = new JLabel("결제 정보");

		JButton done = new JButton();
		JTextField idTF = new JTextField();
		JPasswordField pwTF = new JPasswordField();
		JTextField nameTF = new JTextField();
		JPasswordField idNTF = new JPasswordField();
		JTextField phone = new JTextField();
		JTextField card = new JTextField();
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
		p.add(done);
		p.add(idTF);
		p.add(pwTF);
		p.add(nameTF);
		p.add(idNTF);
		p.add(phone);
		p.add(card);
		p.add(bankTF);
		p.add(bankNTF);

		JButton j1 = new JButton("저장");
		JButton j2 = new JButton("취소");
		p.add(j1);
		p.add(j2);
		l1.setBounds(40, 10, 40, 40);
		l2.setBounds(40, 50, 80, 40);
		l3.setBounds(40, 90, 60, 40);
		l4.setBounds(40, 130, 80, 40);
		l5.setBounds(40, 170, 60, 40);
		l6.setBounds(40, 210, 40, 40);
		l7.setBounds(40, 250, 60, 40);
		idTF.setBounds(120, 10, 200, 30);
		pwTF.setBounds(120, 50, 200, 30);
		nameTF.setBounds(120, 90, 200, 30);
		idNTF.setBounds(120, 130, 200, 30);
		phone.setBounds(120, 170, 280, 30);
		card.setBounds(120, 210, 280, 30);
		bankTF.setBounds(20, 250, 280, 30);
		bankNTF.setBounds(20, 250, 280, 30);
		j1.setBounds(125, 330, 80, 30);
		j2.setBounds(240, 330, 80, 30);
		this.add(p);

		       j1.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt",true))){
						user.setId(idTF.getText());
						user.setPw(pwTF.getText());
						user.setName(nameTF.getText());
						user.setIdNum(idNTF.getText());
						user.setpNum(phone.getText());
						user.setBank(bankTF.getText());
						user.setPay(bankNTF.getText());
						
						oos.writeObject(user);
						
						/*oos.write(idTF.getText()+"/");
						oos.write(pwTF.getText()+"/");
						oos.write(nameTF.getText()+"/");
						oos.write(idNTF.getText()+"/");
						oos.write(phone.getText()+"\r\n");
						oos.write(card.getText()+"/");
						oos.write(bankTF.getText()+"\r\n");
						oos.write(bankNTF.getText()+"\r\n"); */
						
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
						setVisible(false);
						new Login();
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
					}
				}
			});
		       this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}    
}

