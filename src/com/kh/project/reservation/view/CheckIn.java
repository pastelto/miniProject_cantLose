package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.imageio.metadata.IIOMetadata;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
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


	

	public CheckIn(Account account) {

		super("checkIn & checkOut");
		this.setSize(360, 600);
		this.setLocationRelativeTo(null); // 창 가운데로 켜지게 설정
		this.setLayout(null);
		
		//버튼
		JLabel name = new JLabel(account.getName()+" 님"); // 이름
		JLabel title = new JLabel("CHECKIN & OUT"); // 타이틀
		JButton checkin = new JButton("체크인"); // 체크인버튼
		JButton checkout = new JButton("체크아웃"); // 체크아웃버튼
		JButton back = new JButton("< prev");
		JPanel cc = new JPanel();
		Font font = new Font("함초롬돋움", Font.BOLD, 30);


		cc.setBackground(new Color(249, 242, 242)); // 배경색 설정
		cc.setLayout(null);
		cc.setSize(getMaximumSize());
		dialog = new InDialog(new JFrame(), account , "체크인");
		
		// 사람이미지
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34, 135, 85, 54);

		// 상단바
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText("CHECHKIN & OUT  ");
		bar.setFont(bar.getFont().deriveFont(17.0f));
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		// 공부그림
		String imgPath = "images/checkout.png";
		ImageIcon originicon = new ImageIcon(imgPath);
		Image originImg = originicon.getImage();
		Image changedimg = originImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(changedimg);

		JLabel out = new JLabel(icon);
		out.setBounds(50, 243, 50, 50);

		JLabel in = new JLabel(icon);
		in.setBounds(50, 325, 50, 100);

		// name 레이블
		name.setLocation(130, 135);
		name.setFont(name.getFont().deriveFont(30.0f)); // 글씨 크기 변경
		name.setSize(270, 54);
		name.setFont(font); // 폰트 변경 

		// 체크인 버튼
		checkin.setLocation(110, 240);
		checkin.setBackground(new Color(248, 248, 248)); // 버튼 색상 변경
		// checkin.setBorderPainted(false); //버튼 테두리 설정
		checkin.setFocusPainted(false);// 포커스 표시 설정
		checkin.setFont(checkin.getFont().deriveFont(15.0f));
		checkin.setSize(140, 50);

		// 체크아웃 버튼
		checkout.setLocation(110, 350);
		checkout.setBackground(new Color(248, 248, 248));
		checkout.setFocusPainted(false);
		checkout.setFont(checkout.getFont().deriveFont(15.0f));
		checkout.setSize(140, 50);

		//이전 버튼 
		back.setLocation(30, 500);
		back.setBackground(new Color(248, 248, 248));
		back.setFocusPainted(false);
		back.setFont(back.getFont().deriveFont(10.0f));
		back.setSize(70, 30);
		
		
		
		//이벤트 효과
		checkin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					
					if(account.getDbcheck() == null) {
						iom.checkInPrint();//-> 시간 정해줌 
						dialog.setVisible(true); // 체크인 다이얼로그
						
					}else if(account.getDbcheck().equals("체크인")) {
						String ss = io.getCheckIn();
						
						JOptionPane.showMessageDialog(null, "이미 체크인 하셨습니다. 체크인 시간: " + ss); 
					}else if(account.getDbcheck().equals("체크인불가")) {
						JOptionPane.showMessageDialog(null, "체크아웃하여 재입실이 불가합니다."); 
						setVisible(false);
					}
				
				}
			}
		});
		checkout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					
					if(account.getDbcheck().equals("")) {
						JOptionPane.showMessageDialog(null, "체크인한 기록이 없습니다."); 
						setVisible(false);
					}else if(account.getDbcheck().equals("체크인")) {
						//체크아웃 다이얼로그
					}					
					setVisible(false);
				}
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
	


}


//체크인 다이얼로그
class InDialog extends JDialog {
	
	InOutManager iom = new InOutManager();
	InOut io = new InOut();

	public InDialog(JFrame frame,Account account, String title) {

		super(frame, title);
		setLocation(600,380); // 다이얼로그 위치
		setSize(260, 210); // 다이얼로그 창 크기
		setLayout(null); // 다이얼로그 프레임 종류
		
		JLabel seat = new JLabel("1인석 {a,b}"); // 좌석 -> 가져오기
		JLabel check = new JLabel("체크인 하시겠습니까?");
		
		//String ss = iom.checkInPrint();//시간
		//JLabel time = new JLabel(ss); // 시간 

		String ss =io.getCheckIn();//시간
		JLabel time = new JLabel(ss); // 시간 
		
		
		JButton okBtn = new JButton("OK"); // 버튼 1
		
		seat.setBounds(25, 10, 210, 30);
		seat.setHorizontalAlignment(JLabel.CENTER);
		seat.setFont(seat.getFont().deriveFont(20.0f));
		
		check.setBounds(20, 50, 210, 30);
		check.setHorizontalAlignment(JLabel.CENTER);
		check.setFont(check.getFont().deriveFont(17.0f));
		
		time.setBounds(-50, 70, 350, 60);
		time.setHorizontalAlignment(JLabel.CENTER);
		time.setFont(time.getFont().deriveFont(15.0f));

		okBtn.setBounds(85, 130, 70, 30); // 버튼 위치 및 크기 지정
		okBtn.setBackground(new Color(220, 118, 112));

		add(seat);
		add(okBtn);
		add(check);
		add(time);
		

		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				account.setDbcheck("체크인");
				System.out.println(  account.toString()   ); //체크인 상태 변경 확인 
				setVisible(false);
				
			}
		});

	}

}

