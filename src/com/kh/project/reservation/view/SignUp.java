package com.kh.project.reservation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.project.reservation.controller.CheckAccount;
import com.kh.project.reservation.controller.UpdateAccount;
import com.kh.project.reservation.model.vo.Account;

public class SignUp extends JFrame {

   private ArrayList<Account> check = new ArrayList<>();
   private Account account = new Account();
   private CheckAccount ca = new CheckAccount();


   public SignUp() {

      super("SignUp");
      this.setSize(360, 600);
      this.setLocationRelativeTo(null);
      this.setLayout(null);

      JPanel SignUp = new JPanel();
      String id;
      String pw;
      String name;
      String idNum;
      String phNum;
      String cardN;
      String bank;
      String bankN;
      String idNTF; 
      String dbcheck;
     String yourDate;
     String yourSeat;

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
      JLabel l8 = new JLabel("-");
      JLabel l9 = new JLabel("회원가입");
      
      
      JTextField idTF = new JTextField();
      JPasswordField pwTF = new JPasswordField();
      JTextField nameTF = new JTextField();
      JTextField idNTF1 = new JTextField();
      JPasswordField idNTF2 = new JPasswordField();
      JTextField phone = new JTextField();
      JTextField bankNTF = new JTextField();

      /*JComboBox bankTF = new JComboBox();
      bankTF.addItem("신한");
      bankTF.addItem("농협");
      bankTF.addItem("국민");
      bankTF.addItem("우리");
      bankTF.addItem("카카오");*/
      String bank1[] = {"카드를 선택해 주세요","신한","농협","국민","우리","카카오","KB국민","하나","삼성","롯데"};
      JComboBox bankTF= new JComboBox(bank1);
      
      
      p.add(l1);
      p.add(l2);
      p.add(l3);
      p.add(l4);
      p.add(l5);
      p.add(l6);
      p.add(l7);
      p.add(l8);
      
      
      p.add(idTF);
      p.add(pwTF);
      p.add(nameTF);
      p.add(idNTF1);
      p.add(idNTF2);
      p.add(phone);
      p.add(bankTF);
      p.add(bankNTF);

      JButton j1 = new JButton("가입");
      JButton j2 = new JButton("취소");
      
      j1.setBackground(new Color(220, 118, 112)); // 버튼색
      j2.setBackground(new Color(220, 118, 112));// 버튼색
      j1.setForeground(Color.white);
      j2.setForeground(Color.white);
      
      p.add(j1);
      p.add(j2);
      
      JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
      image.setBounds(34,80,54,54);
      
      JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
      bar.setBounds(0,0,360,53);
      bar.add(l9);
      
      p.add(bar);
      p.add(image);
      
      Font font = new Font("맑은 고딕", Font.BOLD, 20);
      Font font2 = new Font("맑은 고딕", Font.PLAIN, 30);
      Font font3 = new Font("맑은 고딕", Font.BOLD, 12);
      
      j1.setFont(font3);
      j2.setFont(font3);
      
      l1.setBounds(120, 85, 45, 40);
      l2.setBounds(40, 140, 85, 40);
      l3.setBounds(40, 195, 65, 40);
      l4.setBounds(40, 250, 85, 40);
      l5.setBounds(40, 305, 65, 40);
      l6.setBounds(40, 360, 45, 40);
      l7.setBounds(40, 415, 65, 40);
      l8.setBounds(213, 243, 65, 40);
      l8.setFont(font2);
      l9.setBounds(30, -25, 100, 100);
      l9.setFont(font);
      l9.setForeground(Color.white);
      
      idTF.setBounds(180, 85, 140, 40);
      pwTF.setBounds(120, 140, 200, 40);
      nameTF.setBounds(120, 195, 200, 40);
      idNTF1.setBounds(120, 250, 90, 40);
      idNTF2.setBounds(230, 250, 90, 40);
      phone.setBounds(120, 305, 200, 40);
      bankTF.setBounds(120, 360, 200, 40);
      bankNTF.setBounds(120, 415, 200, 40);
      j1.setBounds(50, 485, 110, 35);
      j2.setBounds(200, 485, 110, 35);
      this.add(p);


      j1.addActionListener(new ActionListener() {  
         @SuppressWarnings("deprecation")
         @Override
         public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
         
            String idNTF = idNTF1.getText()+"-"+idNTF2.getText(); //111111-1111111
            
            if(idTF.getText().equals("")||pwTF.getText().equals("")|| nameTF.getText().equals("")||idNTF1.equals("")||
                  idNTF2.equals("")||phone.equals("")||bankTF.getSelectedItem().equals("카드를 선택해 주세요")||bankNTF.getText().equals(""))//빈칸일 경우
            {
               JOptionPane.showMessageDialog(null, "정보를 모두 입력해 주세요");
            } else if (idNTF1.getText().length() != 6 || idNTF2.getText().length() != 7) { // 글자갯수 제한
               JOptionPane.showMessageDialog(null, "정확한 주민번호를 입력해주세요!");
            } else if ((ca.checkId(idTF.getText())) && ca.checkIdNum(idNTF)) { // 아이디 주민번호 중복일경우
               JOptionPane.showMessageDialog(null, "이미 가입된 '아이디'와 '주민번호'입니다.");
            } else if ((ca.checkId(idTF.getText()))) { // 아이디중복일경우
               JOptionPane.showMessageDialog(null, "이미 가입된 '아이디'입니다.");
            } else if (ca.checkIdNum(idNTF)) { // 주민번호 중복일경우
               JOptionPane.showMessageDialog(null, "이미 가입된 '주민번호'입니다.");
            }
               else {ca.writeAccount(new Account(idTF.getText(), pwTF.getText(), nameTF.getText(), idNTF, 
                     phone.getText(), bankTF.getSelectedItem().toString(),bankNTF.getText(),0,0,0,0,1,null, 0 ,null, null));


                  ca.saveAccount();
                  
                  new CoffePop();
                  setVisible(false);
                  
            }
         }

      });
      
      idNTF1.addKeyListener(new KeyAdapter() { // 글자수 제한

         @Override
         public void keyTyped(KeyEvent e) {
            if(idNTF1.getText().length()>5) {
               e.consume(); // 타이핑한게 입력되지 않는다.
            JOptionPane.showMessageDialog(null, "글자수를 초과했습니다.");
            
         }
         }
      });
      
         idNTF2.addKeyListener(new KeyAdapter() { // 글자수 제한

            @Override
            public void keyTyped(KeyEvent e) {
               if(idNTF2.getText().length()>6) {
                  e.consume(); 
               JOptionPane.showMessageDialog(null, "글자수를 초과했습니다.");
               
            }
            }
         
      });
             
             j2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent T) {//로그인 페이지로 돌아감
                   setVisible(false);
                   new Login();
                }
             });
             
             j1.addMouseListener(new MouseAdapter() {

               @Override
               public void mouseEntered(MouseEvent e) {
                  j1.setBackground(new Color(128, 128, 128)); // 버튼색
               }

               @Override
               public void mouseExited(MouseEvent e) {
                  j1.setBackground(new Color(220, 118, 112)); // 버튼색
               } 
               
         });
             j2.addMouseListener(new MouseAdapter() {

               @Override
               public void mouseEntered(MouseEvent e) {
                  j2.setBackground(new Color(128, 128, 128)); // 버튼색
               }

               @Override
               public void mouseExited(MouseEvent e) {
                  j2.setBackground(new Color(220, 118, 112));// 버튼색
               } 
         });
             
          // 상단바 로고
            try {
               this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
            } catch (IOException e) {
                e.printStackTrace();
            }

             this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

}