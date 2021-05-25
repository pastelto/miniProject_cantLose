
package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
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

import com.kh.project.reservation.controller.CheckAccount;
import com.kh.project.reservation.controller.MaximManager;
import com.kh.project.reservation.model.vo.Account;


public class Login extends JFrame { 

   private Account account = new Account();
   private CheckAccount ca = new CheckAccount();
   
   public Login() {

      super("Login");
      this.setSize(360, 600);
      this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
      this.setLayout(null);

      JButton login = new JButton("로그인");
      JButton signUp = new JButton("회원가입");
      JLabel idL = new JLabel("ID : ");
      JLabel pwL = new JLabel("PW : ");
      JTextField logTF = new JTextField();
      JPasswordField pwTF = new JPasswordField();
      JPanel loginP = new JPanel();
      JLabel find = new JLabel("ID/PW 찾기");
      
      loginP.setBackground(new Color(249, 242, 242)); // 배경색 설정

      JLabel image = new JLabel(new ImageIcon("images/logo.png"));
      image.setBounds(95, 40, 150, 140);



		
		MaximManager bm1 = new MaximManager();
		String mm = bm1.maxim();
		JLabel m = new JLabel(mm);
		m.setLocation(10, 200);
		m.setSize(360, 70);
		loginP.add(m);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 12);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
		
		m.setFont(font);
		idL.setFont(font2);
		

      login.setBackground(new Color(220, 118, 112)); // 버튼색
      signUp.setBackground(new Color(220, 118, 112));// 버튼색
      login.setForeground(Color.white);
      signUp.setForeground(Color.white);

      
      login.setFont(font);
      signUp.setFont(font);
      
      loginP.setLayout(null);
      loginP.setSize(getMaximumSize());


      logTF.setLocation(90, 290);
      logTF.setSize(220, 45);
      idL.setLocation(53, 290);
      idL.setSize(220, 45);

      pwTF.setLocation(90, 350);
      pwTF.setSize(220, 45);
      pwL.setLocation(50, 350);
      pwL.setSize(220, 45);
      logTF.setOpaque(true);

      login.setLocation(40, 430);
      login.setSize(270, 40);

      signUp.setLocation(40, 440);
      signUp.setSize(270, 54);
      signUp.setLocation(40, 480);
      signUp.setSize(270, 40);

      find.setLocation(245, 385);
      find.setSize(270, 54);
      find.setOpaque(false);
      find.setForeground(new Color(225, 118, 112));
      
      loginP.add(logTF);
      loginP.add(pwTF);
      loginP.add(login);
      loginP.add(signUp);
      loginP.add(image);
      loginP.add(idL);
      loginP.add(pwL);
      loginP.add(find);
      
      this.add(loginP);
      
      
      login.addActionListener(new ActionListener() { // 로그인 클릭시 일치하면 여기

         @SuppressWarnings("deprecation")
         @Override
         public void actionPerformed(ActionEvent e1) {// 로그인 할때
            

            if(logTF.getText().equals("")||pwTF.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요!");
            }
            else {ArrayList<Account> check= ca.searchAccount(logTF.getText(), pwTF.getText());   
            
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
      
      find.addMouseListener(new MouseAdapter() { // 아이디 비밀번호 찾기

         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {
               new FindAccount();
               setVisible(false);
         }
         }

         @Override
         public void mouseEntered(MouseEvent e) { // 마우스 올리면 회색
            find.setForeground(Color.DARK_GRAY);
            }

         @Override
         public void mouseExited(MouseEvent e) { // 마우스 나가면 원래대로
            find.setForeground(new Color(225, 118, 112));
         }
         
         }); 
      login.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseEntered(MouseEvent e) {
            login.setBackground(new Color(128, 128, 128)); // 버튼색
         }

         @Override
         public void mouseExited(MouseEvent e) {
            login.setBackground(new Color(220, 118, 112)); // 버튼색
         } 
         
   });
      signUp.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseEntered(MouseEvent e) {
            signUp.setBackground(new Color(128, 128, 128)); // 버튼색
         }

         @Override
         public void mouseExited(MouseEvent e) {
            signUp.setBackground(new Color(220, 118, 112));// 버튼색
         } 
   });
      
      // 상단바 로고
            try {
               this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
            } catch (IOException e) {
               e.printStackTrace();
            }


      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);

   }


}
