package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.InOutManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.InOut;

public class CheckIn extends JFrame {

   InOutManager iom = new InOutManager();
   InOut io = new InOut();
   Account account = new Account();
   InDialog dialog;
   
   // 버튼
   JLabel title = new JLabel("CHECKIN & OUT"); // 타이틀
   JButton checkin = new JButton("체크인"); // 체크인버튼
   JButton checkout = new JButton("체크아웃"); // 체크아웃버튼
   JButton back = new JButton("뒤로");
   JPanel cc = new JPanel();
   Font font = new Font("맑은 고딕", Font.BOLD, 11);
   Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
   Font font3 = new Font("맑은 고딕", Font.BOLD, 20);
   Font font4 = new Font("맑은 고딕", Font.BOLD, 25);

   String start = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(io.getCheckIn());

   public CheckIn(Account account) {
      super("checkIn & checkOut");   
      this.setSize(360, 600);
      this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
      this.setLayout(null);
      
      cc.setBackground(new Color(249, 242, 242)); // 배경색 설정
      cc.setLayout(null);
      cc.setSize(getMaximumSize());
      dialog = new InDialog(new JFrame(), account, "체크인");
      
      // 로고
      try {
         this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
      } catch (IOException e) {
         e.printStackTrace();
      }

      // 사람이미지
      JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
      image.setBounds(44, 130, 85, 54);

      // 상단바
      JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
      bar.setBounds(0, 0, 360, 53);
      bar.setText("Check In & Check Out");
      bar.setFont(font3);
      bar.setForeground(Color.white);
      bar.setHorizontalTextPosition(JLabel.CENTER);
      bar.setVerticalTextPosition(JLabel.CENTER);

      // 공부그림
      String imgPath = "images/checkout.png";
      ImageIcon originicon = new ImageIcon(imgPath);
      Image originImg = originicon.getImage();
      Image changedimg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
      ImageIcon icon = new ImageIcon(changedimg);

      //책그림
      JLabel out = new JLabel(icon);
      out.setBounds(50, 243, 50, 50);
      JLabel in = new JLabel(icon);
      in.setBounds(50, 325, 50, 100);

      // name 레이블
      JLabel name = new JLabel(account.getName() + " 님"); // 이름
      name.setLocation(138, 132);
      name.setFont(font4);
      name.setSize(270, 54);
      

      // 체크인 버튼
      checkin.setLocation(110, 240);
      checkin.setBackground(new Color(220, 118, 112)); // 버튼 색상 변경
      checkin.setFocusPainted(false);// 포커스 표시 설정
      checkin.setForeground(Color.white);
      checkin.setFont(font2);
      checkin.setSize(140, 50);

      // 체크아웃 버튼
      checkout.setLocation(110, 350);
      checkout.setBackground(new Color(220, 118, 112));
      checkout.setFocusPainted(false);
      checkout.setForeground(Color.white);
      checkout.setFont(font2);
      checkout.setSize(140, 50);

      // 이전 버튼
      back.setLocation(30, 500);
      back.setBackground(new Color(220, 118, 112));
      back.setFocusPainted(false);
      back.setForeground(Color.white);
      back.setFont(font);
      back.setSize(70, 30);

      // 이벤트 효과
      checkin.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {

               if (!(account.getYourDate() == null)) {//예약 정보가 존재 한다면
                  if (account.getdbCheck() == null) {
                     String ss = iom.checkin(account); // 체크인 시간 잡아주는
                     System.out.println("체크인시간 : " + ss);

                     dialog.setVisible(true); // 체크인 다이얼로그

                     String result = iom.changecheck(account);// 상태 바꾸기
                     System.out.println("체크인 후 바뀐정보 : " + account.toString());

                  } else if (account.getdbCheck().equals("체크인")) {
                     JOptionPane.showMessageDialog(null,
                           "<html> 이미 체크인 하셨습니다. <br>체크인 시간: " + start + "</htnml>");
                  }

               } else {
                  //예약 정보가 없다면 
                  JOptionPane.showMessageDialog(null, "확인 가능한 예약정보가 없습니다. 예약 후 체크인 해주세요");

                  new BookView(account);
                  setVisible(false);

               }

            }

         }

      });
      checkin.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨
         @Override
         public void mouseEntered(MouseEvent e) {
            checkin.setBackground(new Color(128, 128, 128)); // 버튼색
         }
         @Override
         public void mouseExited(MouseEvent e) {
            checkin.setBackground(new Color(220, 118, 112)); // 버튼색
         }

      });
      checkout.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {

               if (account.getdbCheck().equals("")) {
                  JOptionPane.showMessageDialog(null, "체크인한 기록이 없습니다.");
                  setVisible(false);
               } else if (account.getdbCheck().equals("체크인")) {
                  
                  String ss = iom.checkout(account); //체크아웃 시간 
                  System.out.println("체크아웃시간 : " + ss);
                  
                  String total = iom.usetime(account);//이용시간
                  System.out.println("이용시간 : " + total);
                  
                  JOptionPane.showMessageDialog(null, "<html> 체크아웃 하시겠습니까? <br>" + ss);         
                  JOptionPane.showMessageDialog(null, "<html>체크아웃 되었습니다.  <br> 이용 시간: " + total);
                  
                  String result = iom.changecheck(account);// 상태 바꾸기
                  System.out.println("체크아웃 후 바뀐정보 :" + account.toString());
                  
                  
                  iom.changecheck(account); // 상태바꾸기
                  
                  new MenuChoice(account);
                  
               
                  
               }
               setVisible(false);
            }
         }
      });
      checkout.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨
         @Override
         public void mouseEntered(MouseEvent e) {
            checkout.setBackground(new Color(128, 128, 128)); // 버튼색
         }
         @Override
         public void mouseExited(MouseEvent e) {
            checkout.setBackground(new Color(220, 118, 112)); // 버튼색
         }

      });
      back.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() == 1) {

               new MenuChoice(account);

               setVisible(false);
            }
         }
      });
      back.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨
         @Override
         public void mouseEntered(MouseEvent e) {
            back.setBackground(new Color(128, 128, 128)); // 버튼색
         }
         @Override
         public void mouseExited(MouseEvent e) {
            back.setBackground(new Color(220, 118, 112)); // 버튼색
         }

      });

      cc.add(name);
      cc.add(checkin);
      cc.add(checkout);
      cc.add(image);
      cc.add(bar);
      cc.add(back);
      cc.add(out);
      cc.add(in);
      cc.add(title);
      this.add(cc);

      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   
   }
//체크인 다이얼로그
   class InDialog extends JDialog {
      
      

      InOutManager iom = new InOutManager();
      InOut io = new InOut();

      public InDialog(JFrame frame, Account account, String title) {
         
      

         super(frame, title);
         setLocation(600, 380); // 다이얼로그 위치
         setSize(260, 210); // 다이얼로그 창 크기
         setLayout(null); // 다이얼로그 프레임 종류
         JLabel check = new JLabel("체크인 하시겠습니까?");

         

         long ss = io.getCheckIn();// 시간
         JLabel time = new JLabel(start); // 시간

         JButton okBtn = new JButton("OK"); // 버튼 1

         check.setBounds(20, 30, 210, 30);
         check.setHorizontalAlignment(JLabel.CENTER);
         check.setFont(check.getFont().deriveFont(17.0f));
         
         time.setBounds(-50, 50, 350, 60);
         time.setHorizontalAlignment(JLabel.CENTER);
         time.setFont(time.getFont().deriveFont(15.0f));

         okBtn.setBounds(85, 110, 70, 30); // 버튼 위치 및 크기 지정
         okBtn.setBackground(new Color(220, 118, 112));
         okBtn.setForeground(Color.white);
         
         okBtn.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨
            @Override
            public void mouseEntered(MouseEvent e) {
               okBtn.setBackground(new Color(128, 128, 128)); // 버튼색
            }
            @Override
            public void mouseExited(MouseEvent e) {
               okBtn.setBackground(new Color(220, 118, 112)); // 버튼색
            }

         });

         add(okBtn);
         add(check);
         add(time);

         okBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               JOptionPane.showMessageDialog(null, "<html>체크인 되었습니다. <br>체크인 시간: " + start);
               setVisible(false);

            }
         });

      }

   
   }
   
   
   
   
}
