package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Book;

public class BookView extends JFrame implements ActionListener {

	private String yourDate;
	private String yourSeat;

	// buttons
	JButton block = new JButton("1인 칸막이 좌석");
	JButton open = new JButton("1인 오픈형 좌석");
	JButton company = new JButton("스터디룸");
	JLabel bar = new JLabel(new ImageIcon("images/bar.png"));

	// for color
	JPanel panel = new JPanel();
	JFrame bSearch = new JFrame();

	public BookView() {
	}

	public BookView(Account account) {
		// if(bm.ynTicket() == true) {

		JFrame viewDao = new JFrame();
		viewDao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewDao.setVisible(true);
		viewDao.setSize(360, 600);
		viewDao.setLocationRelativeTo(null);

		bar.setBounds(0, 0, 360, 53);
		bar.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		bar.setText("예약일 선택");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		viewDao.add(panel);
		panel.add(bar);
		panel.setLayout(null);
		panel.setBackground(new Color(249, 242, 242));

		// calendar
		String[] selDate = { "5월 28일", "5월 29일", "5월 30일", "5월 31일", "6월 1일", "6월 2일", "6월 3일", "6월 4일", "6월 5일",
				"6월 6일", "6월 7일", "6월 8일", "6월 9일", "6월 10일", "6월 11일", "6월 12일", "6월 13일", "6월 14일", "6월 15일",
				"6월 16일", "6월 17일", "6월 18일", "6월 19일", "6월 20일", "6월 21일", "6월 22일", "6월 23일", "6월 24일", "6월 25일",
				"6월 26일", "6월 27일" };

		yourDate = (String) JOptionPane.showInputDialog(null, "오늘 기준으로 하단에 보이는 날짜만 선택이 가능합니다.", " ",
				JOptionPane.PLAIN_MESSAGE, null, selDate, "5월 28일");
		viewDao.setVisible(false);
		cSeat(account);
		/*
		 * }else { JOptionPane.showMessageDialog( null, "이용권 구매 이후 예약 가능합니다.",
		 * "이용권이 없습니다", JOptionPane.PLAIN_MESSAGE, null --> 문자열로 받는다 );
		 * 
		 * new Ticket(); }
		 */

	}

	public void cSeat(Account account) {
		JFrame seat = new JFrame();
		seat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		seat.setVisible(true);
		seat.setSize(360, 600);
		seat.setLocationRelativeTo(null);

		bar.setBounds(0, 0, 360, 53);
		bar.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		bar.setText("좌석을 선택하세요.");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		seat.add(bar);
		panel.setLayout(null);
		panel.setBackground(new Color(249, 242, 242));

		block.setLocation(40, 170);
		block.setSize(270, 50);

		open.setLocation(40, 240);
		open.setSize(270, 50);

		company.setLocation(40, 310);
		company.setSize(270, 50);

		seat.add(block);
		seat.add(open);
		seat.add(company);
		seat.add(panel);

		block.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton block = (JButton) e.getSource();
				if (block.getText().equals("1인 칸막이 좌석")) {
					seat.setVisible(false);
					if (account.getIdNum().charAt(7) == '2' || account.getIdNum().charAt(7) == '4') {
						forWomen(account);

					} else {
						forMen(account);

					}

				}

			}

		});

		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton open = (JButton) e.getSource();
				if (open.getText().equals("1인 오픈형 좌석")) {
					seat.setVisible(false);
					open(account);

				}
			}

		});

		company.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton company = (JButton) e.getSource();
				if (company.getText().equals("스터디룸")) {
					seat.setVisible(false);
					studyRoom(account);
				}
			}

		});

	}

	public void forWomen(Account account) {
		ReservationManager bm = new ReservationManager(account);

		JFrame ForWomen = new JFrame();
		ForWomen.setSize(360, 600);

		bar.setBounds(0, 0, 360, 53);
		bar.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		bar.setText("1인 칸막이 좌석 (여성전용)");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		panel.add(bar);
		panel.setBackground(new Color(249, 242, 242));
		ForWomen.add(panel);
		ForWomen.setLocationRelativeTo(null);
		ForWomen.setVisible(true);
		ForWomen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
				JOptionPane.PLAIN_MESSAGE, null, bm.getSeatsFF(), "1인 칸막이 좌석 (여성전용) a,a");
		ForWomen.setVisible(false);
		done(account);

	}

	public void forMen(Account account) {
		ReservationManager bm = new ReservationManager(account);

		JFrame ForMen = new JFrame();
		ForMen.setSize(360, 600);
		bar.setBounds(0, 0, 360, 53);
		bar.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		bar.setText("1인 칸막이 좌석 (남성전용)");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		panel.add(bar);
		panel.setBackground(new Color(249, 242, 242));
		ForMen.add(panel);
		ForMen.setLocationRelativeTo(null);
		ForMen.setVisible(true);
		ForMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
				JOptionPane.PLAIN_MESSAGE, null, bm.getSeatsFM(), "1인 칸막이 좌석 (남성전용) b,a");
		ForMen.setVisible(false);
		done(account);

	}

	public void open(Account account) {
		ReservationManager bm = new ReservationManager(account);

		JFrame open = new JFrame();
		open.setSize(360, 600);
		bar.setBounds(0, 0, 360, 53);
		bar.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		bar.setText("1인 오픈형 좌석");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		panel.add(bar);
		panel.setBackground(new Color(249, 242, 242));
		open.add(panel);
		open.setLocationRelativeTo(null);
		open.setVisible(true);
		open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
				JOptionPane.PLAIN_MESSAGE, null, bm.getSeatsFO(), "1인 오픈형 좌석 c,a");
		open.setVisible(false);
		done(account);

	}

	public void studyRoom(Account account) {
		ReservationManager bm = new ReservationManager(account);

		JFrame study = new JFrame();
		study.setSize(360, 600);
		study.setLocationRelativeTo(null);
		bar.setBounds(0, 0, 360, 53);
		bar.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		bar.setText("스터디룸");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);

		panel.add(bar);
		panel.setLayout(null);
		panel.setBackground(new Color(249, 242, 242));

		study.add(panel);
		study.setVisible(true);
		study.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		yourSeat = (String) JOptionPane.showInputDialog(null, "예약 하고자 하는 방을 선택하세요.", "스터디룸 예약",
				JOptionPane.PLAIN_MESSAGE, null, bm.getRooms(), "스터디룸 A (최대 4인)");
		study.setVisible(false);
		done(account);
	}

	public void done(Account account) {
		 Book bk = new Book();
		 bk.setYourDate(yourDate);
		 bk.setYourSeat(yourSeat);
		 FileWriter fw = null;
		 
		 try {
			fw = new FileWriter(new File("YourBook.txt"));
			
			fw.append(yourDate);
			fw.append(",");
			fw.append(yourSeat);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.flush();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		JOptionPane.showMessageDialog(null, "  선택하신 일자 [ 2021년 " + yourDate + " ] 에, \n  예약하신 좌석 [ " + yourSeat
				+ " ] 으로 예약 되었습니다. \n  예약 취소 및 수정은 예약 정보 확인 탭에서 가능합니다.", "예약 완료", JOptionPane.PLAIN_MESSAGE);
		new MenuChoice(account);
	}

	public void checkBooking(Account account) {

		FileReader fr = null;
		try {
			fr = new FileReader("YourBook.txt");
			
			int readCharNo;
			char[] cbuf = new char[100];
			String data = null;
			while((readCharNo = fr.read(cbuf))!=-1) {
				data = new String(cbuf,0,readCharNo);
			}
				StringTokenizer st = new StringTokenizer(data,",");
				String array[] = new String[st.countTokens()];
				
				int i = 0 ;
				while(st.hasMoreElements()) {
					array[i++] = st.nextToken();
				}
				i=0;
				
				//버튼들
				JButton modify = new JButton("예약 변경");
				JButton cancel = new JButton("예약 취소");
				JButton prev = new JButton("< 뒤로가기");
				
				bSearch.setSize(360, 600);
				
				bar.setBounds(0, 0, 360, 53);
				bar.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
				bar.setText("예약 내역");
				bar.setForeground(Color.white);
				bar.setHorizontalTextPosition(JLabel.CENTER);
				bar.setVerticalTextPosition(JLabel.CENTER);
				
				panel.setLayout(null);
				panel.setBackground(new Color(249, 242, 242));
				
				JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
				image.setBounds(145, 80, 54, 54);				
				
			JLabel bInfo = new JLabel("<html>" + account.getName().toString() + "님께서는 [" + array[i++] + "] 에" + "<br>" + "["
					+ array[i++] + "] 좌석을" + "<br>" +"예약하셨습니다.</html>");
			bInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			bInfo.setSize(270, 130);
			bInfo.setLocation(70, 125);

			prev.setSize(70, 40);
			prev.setLocation(10,500);
			
			modify.setSize(270, 50);
			modify.setLocation(40, 240);

			cancel.setSize(270, 50);
			cancel.setLocation(40, 310);
			
			panel.add(bar);
			panel.add(prev);
			panel.add(image);
			panel.add(bInfo);
			panel.add(modify);
			panel.add(cancel);
			bSearch.add(panel);
			bSearch.setLocationRelativeTo(null);
			bSearch.setVisible(true);
			bSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			modify.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton modify = (JButton) e.getSource();
					if (modify.getText().equals("예약 변경")) {
						JOptionPane.showMessageDialog(null, "기존 예약은 삭제되었으며 재 예약을 위해 예약화면으로 돌아갑니다.", "예약 변경",
								JOptionPane.PLAIN_MESSAGE);
						bSearch.setVisible(false);
						new BookView(account);

					}
				}

			});

			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton cancel = (JButton) e.getSource();
					if (cancel.getText().equals("예약 취소")) {
						FileWriter fw = null;
						 
						 try {
							fw = new FileWriter("YourBook.txt");
							

						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}finally {
							try {
								fw.close();
							} catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
						JOptionPane.showMessageDialog(null, "예약 취소가 완료되었습니다.", "예약 취소", JOptionPane.PLAIN_MESSAGE);
						bSearch.setVisible(false);
						new Book(account).setYourDate(null);
						new Book(account).setYourSeat(null);
						new MenuChoice(account);
					}
				}

			});

			prev.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton prev = (JButton) e.getSource();
					if (prev.getText().equals("< 뒤로가기")) {
						new MenuChoice(account);

					}

				}

			});
	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch(NullPointerException e1) {
			JOptionPane.showMessageDialog(
					null,
					 "예약 이후 예약정보 확인이 가능합니다.", 
					 "예약 정보가 없습니다", 
					 JOptionPane.PLAIN_MESSAGE, 
					 null); 
				new MenuChoice(account);
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
		
		
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}