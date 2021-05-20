package com.kh.project.reservation.view;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
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

public class SignUp extends JFrame {
	
	private static final JFrame JFrame = null;
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Account> list = new ArrayList<>();
	JLabel bar = new JLabel(); 
	JButton done = new JButton("입력 완료");
	JTextField idTF = new JTextField("아이디");
	JPasswordField pwTF= new JPasswordField("비밀번호");
	JTextField nameTF = new JTextField("이름");
	JPasswordField idNTF = new JPasswordField("주민번호");
	JTextField phone = new JTextField("전화번호");
	JTextField card = new JTextField("결제 방법 :     CARD");
	JTextField bankTF = new JTextField("결제 정보");
	JTextField bankNTF = new JTextField();
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Congraturation"); // 다이얼로그 문구
	JButton okBtn = new JButton("변경"); // 버튼 1
	JButton noBtn = new JButton("취소"); // 버튼 2
	
	JPanel SignUp= new JPanel(); 
	JLabel SignUp2= new JLabel(); 
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
		this.setSize(360,600);
		this.setLocationRelativeTo(null);

		JLabel bar = new JLabel();
		JPanel p = new JPanel();
		Label l1 = new Label("아이디");
		Label l2 = new Label("비밀번호");
		Label l3 = new Label("이름");
		Label l4 = new Label("주민번호");
		Label l5 = new Label("전화번호");
		Label l6 = new Label("결제 방법");
		Label l7 = new Label("결제 정보");

		JButton done = new JButton();
		JTextField idTF = new JTextField();
		JPasswordField pwTF = new JPasswordField();
		JTextField nameTF = new JTextField();
		JPasswordField idNTF = new JPasswordField();
		JTextField phone = new JTextField();
		JTextField card = new JTextField();
		JTextField bankTF = new JTextField();
		JTextField bankNTF = new JTextField();
			    	
			add(bar);
			        add(l1);
			        add(l2);
			        add(l3);
			        add(l4);
			        add(l5);
			        add(l6);
			        add(l7);
			        add(done);
			        add(idTF);
			        add(pwTF);
			        add(nameTF);
			        add(idNTF);
			        add(phone);
			        add(card);
			        add(bankTF);
			        add(bankNTF);
			   
			        JButton j1 = new JButton("저장");
			        JButton j2 = new JButton("취소");
			        add(j1);
			        add(j2);
			        l1.setBounds(40, 10, 40, 40);
			        l2.setBounds(40, 50, 40, 40);
			        l3.setBounds(40,90,60,40);
			        l4.setBounds(40, 130, 40, 40);
			        l5.setBounds(40, 170, 60, 40);
			        idTF.setBounds(120, 10, 200, 30);
			        pwTF.setBounds(120, 50, 200, 30);
			        nameTF.setBounds(120, 90, 200, 30);
			        idNTF.setBounds(120, 130, 280, 30);
			        phone.setBounds(120, 180, 280, 120);
			        card.setBounds(120, 130, 280, 30);
			        bankTF.setBounds(120, 180, 280, 120);
			        bankNTF.setBounds(120, 180, 280, 120);
			        j1.setBounds(125, 330, 80, 30);
			        j2.setBounds(240, 330, 80, 30); 
			    add(p);
				
				setTitle("회원가입");
		       setVisible(true);
		       
		       j1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
					try{
						BufferedWriter bos = new BufferedWriter(new FileWriter( id+ ".txt",true));
						bos.write(t1.getText()+"/");
						bos.write(t2.getText()+"/");
						bos.write(t3.getText()+"/");
						bos.write(t4.getText()+"/");
						bos.write(t5.getText()+"\r\n");
						bos.close();
						JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
						dispose();
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
					}
				}
			});
		       this.setVisible(true);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}    
}

