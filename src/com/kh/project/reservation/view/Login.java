
package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.BoardManager;
import com.kh.project.reservation.controller.CheckAccount;
import com.kh.project.reservation.model.vo.Account;


public class Login extends JFrame { 

	private Scanner sc = new Scanner(System.in);
	private Account account = new Account();
	JButton login = new JButton("로그인");
	JButton signUp = new JButton("회원가입");
	JLabel idL = new JLabel("ID : ");
	JLabel pwL = new JLabel("PW : ");
	JTextField logTF = new JTextField();
	JPasswordField pwTF = new JPasswordField();
	JPanel loginP = new JPanel();
	CheckAccount ca = new CheckAccount();
	
	
	public Login() {

		super("Login");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);

		loginP.setBackground(new Color(249, 242, 242)); // 배경색 설정

		JLabel image = new JLabel(new ImageIcon("images/logo.png"));
		image.setBounds(95, 40, 150, 140);


		
		
		BoardManager bm1 = new BoardManager();
		String mm = bm1.maxim();
		JLabel m = new JLabel(mm);
		m.setLocation(10, 200);
		m.setSize(360, 70);
		loginP.add(m);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		m.setFont(font);
		
		/* Image icon = new ImageIcon("images/커피.png").getImage().getScaledInstance(100,
		 * 100, 0); imLabel = new JLabel(new ImageIcon(icon));
		 * imLabel.setBounds(100,100,100,100);
		 */// 이건 왜 안됨,,,,? */

		loginP.setLayout(null);
		loginP.setSize(getMaximumSize());

		logTF.setLocation(90, 290);
		logTF.setSize(220, 45);
		idL.setLocation(50, 290);
		idL.setSize(220, 45);

		pwTF.setLocation(90, 360);
		pwTF.setSize(220, 45);
		pwL.setLocation(50, 360);
		pwL.setSize(220, 45);
		logTF.setOpaque(true);

		login.setLocation(40, 430);
		login.setSize(270, 40);

		signUp.setLocation(40, 440);
		signUp.setSize(270, 54);
		signUp.setLocation(40, 480);
		signUp.setSize(270, 40);

		loginP.add(logTF);
		loginP.add(pwTF);
		loginP.add(login);
		loginP.add(signUp);
		loginP.add(image);
		loginP.add(idL);
		loginP.add(pwL);
		this.add(loginP);
		
		/*id = logTF.getText();
		
		id = logTF.getText();
		pw = pwTF.getText(); //?????왜 줄쳐지는거지...
		
		login.addMouseListener(new MouseAdapter() { // 로그인 클릭시 일치하면 여기

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					//if(id.equals(ca.checkId(id))&&pw.equals(ca.checkPw(pw))) { // 일치하는지 확인하는 부분 
					new MenuChoice();
					setVisible(false);
					} else {
						// 불일치시에 팝업창 뜨기 -"아이디, 비밀번호를 확인해 주세요."
						
					//}
				}
			}
		}); 

		signout.addMouseListener(new MouseAdapter() { // 회원가입 여기

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
						new SignUp();
						setVisible(false);
			} 
			}
		});  */

		
		login.addActionListener(new ActionListener() { // 로그인 클릭시 일치하면 여기

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e1) {// 로그인 할때
				

				if(logTF.getText().equals("")||pwTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요!");
				}
				else {ArrayList<Account> check= ca.searchAccount(logTF.getText(),pwTF.getText());	
				
					if (check.isEmpty()) {
						JOptionPane.showMessageDialog(null, "회원 가입이 필요합니다.");
						new SignUp();
						setVisible(false);
					} 
					else {
						
						JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
						 //new MenuChoice();
						 System.out.println(check.get(0));
						 new MenuChoice(check.get(0));
							setVisible(false);
						}
				}
					
	
					
					
						/*Account account = ca.checkIdnPw(logTF.getText(),pwTF.getText());
						if(account == null) {		
							System.out.println("조회된 게시글이 없습니다.");
							JOptionPane.showMessageDialog(null, "회원가입이 필요합니다.2");
						}else {		*/		
							
							
						/*while ((Account)oss.readObject()!=-1) {
							list.add((Account)oss.readObject());
							System.out.println(list.get(i));
							i++; */
							
					/*} catch (EOFException e2) {
						int i = 0;
						while (true) {
							if (logTF.getText().equals(list.get(i).getId())
									&& pwTF.getText().equals(list.get(i).getPw())) {
								JOptionPane.showMessageDialog(null, "로그인이 되었습니다!!");
							 new MenuChoice();
							 setVisible(false);
								break;
							} else {
								JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다.");
							}
							i++;
						}
					} catch (ClassNotFoundException e3) {
						JOptionPane.showMessageDialog(null, "회원가입이 필요합니다.2");
					} catch (IOException e4) {
						JOptionPane.showMessageDialog(null, "회원가입이 필요합니다.");
					}
				}*/
			}
		});


		signUp.addMouseListener(new MouseAdapter() { // 회원가입 여기

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
						new SignUp();
						setVisible(false);
			} 
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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}

