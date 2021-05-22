package com.kh.project.reservation.view.Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.view.MenuChoice;

public class MList extends JFrame {
	private JList<String> TitleList = new JList<String>();
	private JList<String> DateList = new JList<String>();
	private DefaultListModel<String> TitleModel = new DefaultListModel<String>();
	private DefaultListModel<String> DateModel = new DefaultListModel<String>();;
	private Vector<JTextField> v1 = new Vector<JTextField>();
	private Vector<JTextArea> v2 = new Vector<JTextArea>();
	private int index;
	// 화면 정중앙 맞추기
	int xL, yL;
	Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit객체를 얻는다.
	Dimension screenSize = tk.getScreenSize();// 화면의 크기를 구한다.

	public MList(Account account) {
		super("MList");

		this.setTitle("내 노트 리스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(360, 600);
		// 화면 정중앙
		xL = screenSize.width / 2 - this.getWidth() / 2;
		// y좌표구하기
		yL = screenSize.height / 2 - this.getHeight() / 2;

		setLocation(xL, yL); // 구한 좌표로 위치 지정

		// 상단바 로고
		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InitialScreen is = new InitialScreen(account);
		setContentPane(is);

		this.setResizable(false);
		this.setVisible(true);
	}

	private class InitialScreen extends JPanel {
		private JButton WriteBtn, DeleteBtn, editBtn, backBtn;
		private JLabel titleLabel, timeLabel;

		public InitialScreen(Account account) {
			this.setSize(360, 600);
			this.setLayout(null);
			this.setLocation(getLocation());
			this.setBackground(new Color(249, 242, 242));

//			JLabel label = new JLabel("내 노트");
//			label.setBounds(20, 20, 450, 50);
//			label.setForeground(new Color(249, 242, 242));
//			label.setHorizontalAlignment(JLabel.CENTER);
//			add(label);

			JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
			bar.setBounds(0, 0, 360, 53);
			bar.setText("내 노트  ");
			bar.setHorizontalTextPosition(JLabel.CENTER);
			bar.setVerticalTextPosition(JLabel.CENTER);

			// 상단바 메뉴 폰트
			Font font = new Font("맑은 고딕", Font.BOLD, 20);
			// 폰트
			bar.setFont(font);

			TitleList.setBounds(10, 90, 210, 335);

			DateList.setBounds(220, 90, 110, 335);
			DateList.setEnabled(false);

			add(TitleList);
			add(DateList);

			titleLabel = new JLabel("제목");
			titleLabel.setBounds(90, 52, 100, 53);
			timeLabel = new JLabel("작성 시간");
			timeLabel.setBounds(240, 52, 100, 53);
			add(titleLabel);
			add(timeLabel);

			WriteBtn = new JButton("글쓰기");
			WriteBtn.setBounds(30, 440, 80, 30);

			editBtn = new JButton("수정");
			editBtn.setBounds(130, 440, 80, 30);

			DeleteBtn = new JButton("삭제");
			DeleteBtn.setBounds(230, 440, 80, 30);

			backBtn = new JButton("뒤로가기");
			backBtn.setBounds(230, 500, 90, 30);

			add(WriteBtn);
			add(editBtn);
			add(DeleteBtn);
			add(backBtn);
			add(bar);

			WriteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (v1.size() == 20) {
						JOptionPane.showMessageDialog(null, "더 이상 글을 쓸 수 없습니다.", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					Screen s = new Screen(account, "새 글 쓰기");
					setContentPane(s);
				}
			});

			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (TitleList.isSelectionEmpty() == false) {
						index = TitleList.getSelectedIndex();
						Screen s = new Screen(account, "수정");
						setContentPane(s);
					}
				}
			});

			DeleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (TitleList.isSelectionEmpty() == false) {
						int choice = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "Delete",
								JOptionPane.OK_CANCEL_OPTION);
						if (choice == JOptionPane.YES_OPTION) {
							v1.remove(TitleList.getSelectedIndex());
							v2.remove(TitleList.getSelectedIndex());

							DateModel.remove(TitleList.getSelectedIndex());
							DateList.setModel(DateModel);

							TitleModel.remove(TitleList.getSelectedIndex());
							TitleList.setModel(TitleModel);
						} else {
							return;
						}
					}
				}
			});

			backBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MenuChoice(account);
				}
			});
		}

		private void setIconImage(BufferedImage read) {
			// TODO Auto-generated method stub

		}

	}

	private class Screen extends JPanel { // 글 작성 및 수정 GUI
		private JLabel label;
		private JTextField Title;
		JTextArea memo = new JTextArea(); // 메모 내용
		JButton saveM = new JButton("저장"); // 글 저장
		private time t = new time();
		private Error err = new Error();
		JLabel titleLabel = new JLabel("제목");
		JButton back = new JButton("취소"); // 뒤로가기 (or 메뉴)

		public Screen(Account account, String str) {
			this.setSize(360, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(null);
			this.setBackground(new Color(249, 242, 242));

			JLabel bar = new JLabel(new ImageIcon("images/bar.png"));
			bar.setBounds(0, 0, 360, 53);

			// 상단바 메뉴 폰트
			Font font = new Font("맑은 고딕", Font.BOLD, 20);
			// 폰트
			bar.setFont(font);

			label = new JLabel(str);
			label.setBounds(0, 0, 360, 53);
//			label.setForeground(new Color(249, 242, 242));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setFont(font);

			Title = new JTextField();
			Title.setLocation(60, 80);
			Title.setSize(240, 30);
			Title.setText("이곳에 20자 이내 제목을 입력하세요.");

			memo = new JTextArea();
			memo.setLocation(20, 130);
			memo.setSize(300, 300);
			memo.setToolTipText("이곳에 메모를 입력하세요"); // 커서 올리면 가이드
			memo.setLineWrap(true);
			

			// 제목 패널1
			titleLabel.setLocation(20, 50);
			titleLabel.setSize(50, 100);
			add(titleLabel);

			saveM = new JButton("저장하기");

			// 2. 버튼 위치
			saveM.setBounds(90, 450, 150, 30);
			back.setBounds(230, 500, 90, 30);

			add(label);
			add(Title);
//			add(sp);
			add(saveM);
			add(memo);
			add(back);
			add(titleLabel);
			add(bar);

			if (label.getText().equals("새 글 쓰기")) {
				saveM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Title.getText().length() == 0 || memo.getText().length() == 0) {
							err.errorMessage();
							return;
						}

						String format_time = t.FormatTime();

						TitleModel.addElement(Title.getText());
						TitleList.setModel(TitleModel);

						DateModel.addElement(format_time);
						DateList.setModel(DateModel);

						newMemo();
						JOptionPane.showMessageDialog(null, "메모가 저장되었습니다!", "저장완료", JOptionPane.INFORMATION_MESSAGE);
						
						setVisible(false);
						
						v1.add(Title);
						v2.add(memo);

						InitialScreen is = new InitialScreen(account);
						setContentPane(is);
					}

					private void newMemo() {
						String t = Title.getText();
						String fileTitle = t + ".txt";
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(fileTitle));
							bw.write(memo.getText());
							bw.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						
					}
				});
			}

			if (label.getText().equals("수정")) {
				Title.setText(v1.get(index).getText());
				memo.setText(v2.get(index).getText());

				saveM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Title.getText().length() == 0 || memo.getText().length() == 0) {
							err.errorMessage();
							return;
						} else {
							String format_time = t.FormatTime();

							TitleModel.set(index, Title.getText());
							TitleList.setModel(TitleModel);

							DateModel.set(index, format_time);
							DateList.setModel(DateModel);
							
							editMemo();
							JOptionPane.showMessageDialog(null, "메모가 저장되었습니다!", "저장완료", JOptionPane.INFORMATION_MESSAGE);
							
							v1.set(index, Title);
							v2.set(index, memo);

							InitialScreen is = new InitialScreen(account);
							setContentPane(is);
						}
					}

					private void editMemo() {
						String t = Title.getText();
						String fileTitle = t + ".txt";
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(fileTitle, true));
							bw.write(memo.getText());
							bw.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						
					}
						
					
				});
			}

			// 마우스 효과
			back.addMouseListener(new MouseAdapter() { // 메모 취소 후 메모 목록으로 돌아가기
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						JOptionPane.showMessageDialog(null, "메모가 취소되었습니다!", "취소", JOptionPane.WARNING_MESSAGE);
						new MList(account);
						setVisible(false);
					}
				}

			});

		}

		private void setLocationRelativeTo(Object object) {
			// TODO Auto-generated method stub

		}

		private void setIconImage(BufferedImage read) {
			// TODO Auto-generated method stub

		}

		private class Error {
			public void errorMessage() {
				JOptionPane.showMessageDialog(null, "제목과 내용을 입력하십시오", "Message", JOptionPane.ERROR_MESSAGE);
			}
		}

		private class time {
			public String FormatTime() {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Calendar time = Calendar.getInstance();
				String format_time = format.format(time.getTime());

				return format_time;
			}
		}
	}

//	public static void main(String[] args) {
//		new MList();
//	}
}
