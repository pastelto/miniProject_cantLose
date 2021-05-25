package com.kh.project.reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.project.reservation.controller.ReservationManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.TicketGui.TicketGui;

public class BookView extends JFrame implements ActionListener {

	private String yourDate;
	private String yourSeat;

	JLabel bar = new JLabel(new ImageIcon("images/bar.png"));

	public BookView() {
	}

	public BookView(Account account) {
		ReservationManager bm = new ReservationManager(account);

	

		if (bm.OneSeat(account) == true || bm.StdRoom(account) == true) {

			
			JFrame viewDao = new JFrame();
			JPanel panel = new JPanel();
			JButton prev = new JButton("< 뒤로");
			
			
			prev.setForeground(Color.white);
			prev.setBackground(new Color(220, 118, 112)); // 버튼색
			prev.setSize(70, 40);
			prev.setLocation(10, 60);
			prev.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

				@Override
				public void mouseEntered(MouseEvent e) {
					prev.setBackground(new Color(128, 128, 128)); // 버튼색
				}

				@Override
				public void mouseExited(MouseEvent e) {
					prev.setBackground(new Color(220, 118, 112)); // 버튼색
				}

			});
			prev.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton prev = (JButton) e.getSource();
					if (prev.getText().equals("< 뒤로")) {
						viewDao.setVisible(false);
						new MenuChoice(account);
					}
				}
			});
			viewDao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			viewDao.setVisible(true);
			viewDao.setSize(360, 600);
			viewDao.setLocationRelativeTo(null);
			JLabel C = new JLabel(new ImageIcon("WangsImages/C.png"));

			// 상단바 로고
			try {
				viewDao.setIconImage(ImageIO.read(new File("images/logo.PNG")));
			} catch (IOException e) {
				e.printStackTrace();
			}

			bar.setBounds(0, 0, 360, 53);
			bar.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			bar.setText("예약일 선택");
			bar.setForeground(Color.white);
			bar.setHorizontalTextPosition(JLabel.CENTER);
			bar.setVerticalTextPosition(JLabel.CENTER);

			C.setSize(360, 600);
			C.setLocation(1, 25);
			C.setHorizontalTextPosition(JLabel.CENTER);
			C.setVerticalTextPosition(JLabel.CENTER);

			panel.add(prev);
			viewDao.add(panel);
			panel.add(bar);
			panel.add(C);
			panel.setLayout(null);
			panel.setBackground(new Color(249, 242, 242));

			SimpleDateFormat format1 = new SimpleDateFormat("MM월 DD일");
			Date now = new Date();
			String[] selDate = new String[32];
			int date = now.getDate();
			// String time1 = format1.format(now);
			int d = 1;
			for (int i = 0; i <= 31; i++) {
				if (i == 0) {
					selDate[i] = "날짜를 선택하세요.";
				} else if (date < 32) {
					selDate[i] = "5월 " + (date++) + "일";

				} else {
					selDate[i] = "6월 " + (d++) + "일";

				}
			}

			yourDate = (String) JOptionPane.showInputDialog(null, "오늘 기준으로 하단에 보이는 날짜만 선택이 가능합니다.", " ",
					JOptionPane.PLAIN_MESSAGE, null, selDate, "날짜를 선택하세요.");

			if (yourDate.equals("날짜를 선택하세요.")) {
				JOptionPane.showMessageDialog(null, "날짜만 선택이 가능합니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
				yourDate = null;

				yourDate = (String) JOptionPane.showInputDialog(null, "오늘 기준으로 하단에 보이는 날짜만 선택이 가능합니다.", " ",
						JOptionPane.PLAIN_MESSAGE, null, selDate, "날짜를 선택하세요.");
			}

			viewDao.setVisible(false);
			cSeat(account);

		} else {
			JOptionPane.showMessageDialog(null, "이용권 구매 이후 예약 가능합니다.", "이용권이 없습니다", JOptionPane.PLAIN_MESSAGE, null);

			new TicketGui(account);
		}

	}

	public void cSeat(Account account) {

		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JFrame seat = new JFrame();
		JPanel panel = new JPanel();
		JButton prev = new JButton("< 뒤로");
		prev.setForeground(Color.white);
		prev.setBackground(new Color(220, 118, 112)); // 버튼색
		prev.setSize(70, 40);
		prev.setLocation(10, 60);
		
		// 상단바 로고
					try {
						seat.setIconImage(ImageIO.read(new File("images/logo.PNG")));
					} catch (IOException e) {
						e.printStackTrace();
					}
		prev.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				prev.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				prev.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});
		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton prev = (JButton) e.getSource();
				if (prev.getText().equals("< 뒤로")) {
					seat.setVisible(false);
					new BookView(account);
				}
			}
		});
		JButton block = new JButton("1인 칸막이 좌석");
		block.setForeground(Color.white);

		JButton open = new JButton("1인 오픈형 좌석");
		open.setForeground(Color.white);

		JButton company = new JButton("스터디룸");
		company.setForeground(Color.white);


		seat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		seat.setVisible(true);
		seat.setSize(360, 600);
		seat.setLocationRelativeTo(null);

		bar.setBounds(0, 0, 360, 53);
		bar.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bar.setText("좌석을 선택하세요.");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);
		seat.add(bar);
		panel.setLayout(null);
		panel.setBackground(new Color(249, 242, 242));

		block.setLocation(40, 170);
		block.setSize(270, 50);
		block.setBackground(new Color(220, 118, 112)); // 버튼색

		open.setLocation(40, 240);
		open.setSize(270, 50);
		open.setBackground(new Color(220, 118, 112)); // 버튼색

		company.setLocation(40, 310);
		company.setSize(270, 50);
		company.setBackground(new Color(220, 118, 112)); // 버튼색

		panel.add(prev);
		seat.add(panel);
		seat.add(block);
		seat.add(open);
		seat.add(company);
		seat.add(panel);

		block.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				block.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				block.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});
		open.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				open.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				open.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});
		company.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

			@Override
			public void mouseEntered(MouseEvent e) {
				company.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				company.setBackground(new Color(220, 118, 112)); // 버튼색
			}

		});

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
		JFrame ForWomen = new JFrame();
		ReservationManager bm = new ReservationManager(account);

		try {
			ForWomen.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel panel = new JPanel();
		ForWomen.setTitle("1인 칸막이 좌석 (여성전용)");
		ForWomen.setSize(360, 600);
		JLabel W = new JLabel(new ImageIcon("WangsImages/W.png"));

	
		W.setSize(360, 600);
		W.setLocation(1, 25);
		W.setHorizontalTextPosition(JLabel.CENTER);
		W.setVerticalTextPosition(JLabel.CENTER);

		panel.add(W);
		panel.setBackground(new Color(249, 242, 242));
		ForWomen.add(panel);
		ForWomen.setLocationRelativeTo(null);
		ForWomen.setVisible(true);
		ForWomen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
				JOptionPane.PLAIN_MESSAGE, null, bm.takenF(account), "좌석을 선택하세요");

		if (yourSeat.equals("예약된 좌석입니다.")) {
			JOptionPane.showInputDialog(null, "선택하신 좌석은 예약 되었습니다. 다시 선택해주세요", "경고!", JOptionPane.PLAIN_MESSAGE);
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenF(account), "좌석을 선택하세요");

		}

		else if (yourSeat.equals("좌석을 선택하세요")) {
			JOptionPane.showMessageDialog(null, "좌석만 선택이 가능합니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenF(account), "좌석을 선택하세요");

		} else if (yourSeat.equals("예약된 좌석입니다.")) {
			JOptionPane.showMessageDialog(null, "예약된 좌석입니다.", "경고!", JOptionPane.PLAIN_MESSAGE);
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenF(account), "좌석을 선택하세요");

		}
		ForWomen.setVisible(false);
		done(account);
	}

	public void forMen(Account account) {
		JFrame ForMen = new JFrame();
		ReservationManager bm = new ReservationManager(account);

		try {
			ForMen.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		ForMen.setTitle("1인 칸막이 좌석 (남성전용)");
		ForMen.setSize(360, 600);

		JLabel M = new JLabel(new ImageIcon("WangsImages/M.png"));


		M.setSize(360, 600);
		M.setLocation(1, 25);
		M.setHorizontalTextPosition(JLabel.CENTER);
		M.setVerticalTextPosition(JLabel.CENTER);

		panel.add(M);
		panel.setBackground(new Color(249, 242, 242));
		ForMen.add(panel);
		ForMen.setLocationRelativeTo(null);
		ForMen.setVisible(true);
		ForMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
				JOptionPane.PLAIN_MESSAGE, null, bm.takenM(account), "좌석을 선택하세요");

		if (yourSeat.equals("좌석을 선택하세요")) {
			JOptionPane.showMessageDialog(null, "좌석만 선택이 가능합니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenM(account), "좌석을 선택하세요");

		} else if (yourSeat.equals("예약된 좌석입니다.")) {
			JOptionPane.showMessageDialog(null, "예약된 좌석입니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
			// yourSeat = null;
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenM(account), "좌석을 선택하세요");

		}
		ForMen.setVisible(false);
		done(account);
	}

	public void open(Account account) {
		JFrame open = new JFrame();

		try {
			open.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JPanel panel = new JPanel();
		open.setTitle("1인 오픈형 좌석");
		open.setSize(360, 600);

		JLabel O = new JLabel(new ImageIcon("WangsImages/O.png"));

		O.setSize(360, 600);
		O.setLocation(1, 25);
		O.setHorizontalTextPosition(JLabel.CENTER);
		O.setVerticalTextPosition(JLabel.CENTER);

		panel.add(O);
		panel.setBackground(new Color(249, 242, 242));
		open.add(panel);
		open.setLocationRelativeTo(null);
		open.setVisible(true);
		open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ReservationManager bm = new ReservationManager(account);
		yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
				JOptionPane.PLAIN_MESSAGE, null, bm.takenO(account), "좌석을 선택하세요");

		if (yourSeat.equals("좌석을 선택하세요")) {
			JOptionPane.showMessageDialog(null, "좌석만 선택이 가능합니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenO(account), "좌석을 선택하세요");

		} else if (yourSeat.equals("예약된 좌석입니다.")) {
			JOptionPane.showMessageDialog(null, "예약된 좌석입니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenO(account), "좌석을 선택하세요");

		}
		open.setVisible(false);
		done(account);
	}

	public void studyRoom(Account account) {
		JFrame study = new JFrame();
		ReservationManager bm = new ReservationManager(account);
		try {
			study.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (bm.StdRoom(account) == true) {

			// 상단바 로고
			try {
				this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
			} catch (IOException e) {
				e.printStackTrace();
			}

			JPanel panel = new JPanel();

			study.setSize(360, 600);
			study.setLocationRelativeTo(null);
			bar.setBounds(0, 0, 360, 53);
			bar.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			bar.setText("스터디룸");
			bar.setForeground(Color.white);
			bar.setHorizontalTextPosition(JLabel.CENTER);
			bar.setVerticalTextPosition(JLabel.CENTER);

			JLabel S = new JLabel(new ImageIcon("WangsImages/S.png"));

			S.setSize(360, 600);
			S.setLocation(1, 25);
			S.setHorizontalTextPosition(JLabel.CENTER);
			S.setVerticalTextPosition(JLabel.CENTER);

			panel.add(S);

			panel.add(bar);
			panel.setLayout(null);
			panel.setBackground(new Color(249, 242, 242));

			study.add(panel);
			study.setVisible(true);
			study.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
					JOptionPane.PLAIN_MESSAGE, null, bm.takenR(account), "좌석을 선택하세요");

			if (yourSeat.equals("좌석을 선택하세요")) {
				JOptionPane.showMessageDialog(null, "좌석만 선택이 가능합니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
				yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
						JOptionPane.PLAIN_MESSAGE, null, bm.takenR(account), "좌석을 선택하세요");

			} else if (yourSeat.equals("예약된 좌석입니다.")) {
				JOptionPane.showMessageDialog(null, "예약된 좌석입니다.", "다시 선택하세요", JOptionPane.PLAIN_MESSAGE);
				yourSeat = (String) JOptionPane.showInputDialog(null, "하단에 보이는 좌석은 선택 가능합니다.", "예약 좌석 선택",
						JOptionPane.PLAIN_MESSAGE, null, bm.takenR(account), "좌석을 선택하세요");

			}
			study.setVisible(false);
			done(account);

		} else {
			JOptionPane.showMessageDialog(null, "이용권 구매 이후 예약 가능합니다.", "스터디룸 이용권이 없습니다", JOptionPane.PLAIN_MESSAGE,
					null);

			new TicketGui(account);
		}

	}

	public void done(Account account) {
		ReservationManager bm = new ReservationManager(account);
		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		account.setYourDate(yourDate);
		account.setYourSeat(yourSeat);
		bm.check(account);


		if (yourSeat.contains("여")) {
			bm.takenF(account);
		} else if (yourSeat.contains("남")) {
			bm.takenM(account);

		} else if (yourSeat.contains("오")) {
			bm.takenO(account);

		} else if (yourSeat.contains("스")) {
			bm.takenR(account);
		}

		System.out.println(yourDate + " " + yourSeat);

		JOptionPane.showMessageDialog(null, "  선택하신 일자 [ 2021년 " + yourDate + " ] 에, \n  예약하신 좌석 [ " + yourSeat
				+ " ] 으로 예약 되었습니다. \n  예약 취소 및 수정은 예약 정보 확인 탭에서 가능합니다.", "예약 완료", JOptionPane.PLAIN_MESSAGE);
		new MenuChoice(account);
	}

	public void checkBooking(Account account) {


		JFrame bSearch = new JFrame();

		// 상단바 로고
		try {
			bSearch.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			JPanel panel = new JPanel();

			JButton modify = new JButton("예약 변경");
			modify.setForeground(Color.white);

			JButton cancel = new JButton("예약 취소");
			cancel.setForeground(Color.white);

			JButton prev = new JButton("< 뒤로");
			prev.setForeground(Color.white);

			bSearch.setSize(360, 600);
			modify.setBackground(new Color(220, 118, 112)); // 버튼색
			cancel.setBackground(new Color(220, 118, 112)); // 버튼색
			prev.setBackground(new Color(220, 118, 112)); // 버튼색

			bar.setBounds(0, 0, 360, 53);
			bar.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			bar.setText("예약 내역");
			bar.setForeground(Color.white);
			bar.setHorizontalTextPosition(JLabel.CENTER);
			bar.setVerticalTextPosition(JLabel.CENTER);

			panel.setLayout(null);
			panel.setBackground(new Color(249, 242, 242));

			JLabel image = new JLabel(new ImageIcon("images/humanIcon3.png"));
			image.setBounds(145, 80, 54, 54);
			JLabel bInfo = new JLabel("<html>" + account.getName().toString() + "님께서는 [" + account.getYourDate() + "] 에"
					+ "<br>" + "[" + account.getYourSeat() + "] 좌석을" + "<br>" + "예약하셨습니다.</html>");

			bInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			bInfo.setSize(270, 130);
			bInfo.setLocation(70, 125);

			prev.setSize(70, 40);
			prev.setLocation(10, 500);

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

			prev.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

				@Override
				public void mouseEntered(MouseEvent e) {
					prev.setBackground(new Color(128, 128, 128)); // 버튼색
				}

				@Override
				public void mouseExited(MouseEvent e) {
					prev.setBackground(new Color(220, 118, 112)); // 버튼색
				}

			});
			modify.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

				@Override
				public void mouseEntered(MouseEvent e) {
					modify.setBackground(new Color(128, 128, 128)); // 버튼색
				}

				@Override
				public void mouseExited(MouseEvent e) {
					modify.setBackground(new Color(220, 118, 112)); // 버튼색
				}

			});
			cancel.addMouseListener(new MouseAdapter() { // 마우스 올리면 버튼 색상 변경됨

				@Override
				public void mouseEntered(MouseEvent e) {
					cancel.setBackground(new Color(128, 128, 128)); // 버튼색
				}

				@Override
				public void mouseExited(MouseEvent e) {
					cancel.setBackground(new Color(220, 118, 112)); // 버튼색
				}

			});

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
						account.setYourDate("예약 내역이 없습니다.");
						account.setYourSeat("예약 내역이 없습니다.");

						JOptionPane.showMessageDialog(null, "예약 삭제가 완료되었습니다.", "예약 삭제", JOptionPane.PLAIN_MESSAGE);
						bSearch.setVisible(false);
						new MenuChoice(account);
					}
				}
			});

			prev.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton prev = (JButton) e.getSource();
					if (prev.getText().equals("< 뒤로")) {
						bSearch.setVisible(false);
						new MenuChoice(account);
					}
				}
			});

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "예약 이후 예약정보 확인이 가능합니다.", "예약 정보가 없습니다", JOptionPane.PLAIN_MESSAGE,
					null);
			new BookView(account);
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}