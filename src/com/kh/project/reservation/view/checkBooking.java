package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.project.reservation.model.vo.Account;

public class checkBooking extends JFrame {
	BookView bv = new BookView();
	
	JLabel bar = new JLabel();
		
	// JLabel bar1 = new JLabel("예약정보");
	//JTable table = new JTable(); // 예약정보 표
	
	JButton modify = new JButton("예약 변경"); // 예약변경 버튼
	JButton cancel = new JButton("예약 취소"); // 예약취소 버튼
	//JButton back = new JButton(); // 뒤로가기 버튼
	
	/*
	JRadioButton b1= new JRadioButton(" 버 튼 "); // 표 안에 삽입
	ButtonGroup bg = new ButtonGroup();
	bg.add(b1);
	*/
	
	JPanel cb = new JPanel();

	
	public checkBooking(Account account) {
		
		JFrame bSearch = new JFrame();
		bSearch.setLocationRelativeTo(null);

		bSearch.setSize(360, 600);
		cb.setLayout(null);
		cb.setBackground(new Color(249, 242, 242)); 
		
		bSearch.setTitle("예약확인");
		
		bSearch.setVisible(true);
		bSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
		image.setBounds(34,80,54,54);
		JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0,0,360,53);
		
		JLabel bInfo = new JLabel("님께서는 [" + bv.getYourDate() + "] 에 [" + bv.getYourSeat() + "] 좌석을 예약하셨습니다." );

		
		bInfo.setSize(270,50);
		bInfo.setLocation(40,170);
		
		modify.setSize(270,50);
		modify.setLocation(40, 240);
		
		cancel.setSize(270,50);
		cancel.setLocation(40, 310);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		JLabel lTitle = new JLabel("예약정보");
		lTitle.setLocation(140, 80);
		lTitle.setSize(100, 54);
		lTitle.setFont(font);

		cb.add(lTitle);
		cb.add(bar);
		cb.add(image);
		/*
		bSearch.add(lTitle);
		bSearch.add(bar);
		bSearch.add(image);
		*/
		cb.add(bInfo);
		cb.add(modify);
		cb.add(cancel);
		bSearch.add(cb);

		
		/*
		 * company.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
	JButton company = (JButton) e.getSource();
	if (company.getText().equals("스터디룸")) {
	seat.setVisible(false);
	studyRoom();
	}
	}
	
	});
	seat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
		 * 
		 */
		
		modify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton modify = (JButton)e.getSource();
				if(modify.getText().equals("예약 변경")) {
					JOptionPane.showMessageDialog(
							null,
							"기존 예약은 삭제되었으며 재 예약을 위해 예약화면으로 돌아갑니다.",
							"예약 변경",
							JOptionPane.PLAIN_MESSAGE
							);
					bSearch.setVisible(false);
					//컨트롤러에서 해당 회원의 예약 내역을 지우고 예약 초기 창으로 보내기.
					new BookView(account);
					
				}
			}
			
		});
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton cancel = (JButton)e.getSource();
				if(cancel.getText().equals("예약 취소")) {
					JOptionPane.showMessageDialog(
							null,
							"예약 취소가 완료되었습니다.",
							"예약 취소",
							JOptionPane.PLAIN_MESSAGE
							);
					bSearch.setVisible(false);
					//컨트롤러에서 해당 회원의 예약 내역을 지우고
					new MenuChoice(account);				
					}
			}
			
		});
	}
}
