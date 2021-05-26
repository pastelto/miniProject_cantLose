package com.kh.project.reservation.view.Memo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.project.reservation.controller.MemoManager;
import com.kh.project.reservation.model.vo.Account;
import com.kh.project.reservation.model.vo.Memo;
import com.kh.project.reservation.view.MenuChoice;

public class MyMemo extends JFrame {

	private JLabel bar; 
	private JPanel mc = new JPanel();
	private JButton saveM; // 글 저장
	private JButton back; // 뒤로가기 (or 메뉴)
	private JTextArea memo = new JTextArea();

	private MemoManager mm = new MemoManager();
	private Memo m = new Memo();
	String str = "";

	public MyMemo(Account account) {
		super("MyMemo");

		// 프레임
		this.setTitle("내 노트 리스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(360, 600);

		// 패널
		mc.setBackground(new Color(249, 242, 242));
		mc.setLayout(null);
		mc.setSize(360, 600);

		// 화면 정중앙 맞추기
		int xL, yL;
		Toolkit tk = Toolkit.getDefaultToolkit(); // 구현된 Toolkit객체를 얻는다.
		Dimension screenSize = tk.getScreenSize();// 화면의 크기를 구한다.
		// 화면 정중앙
		xL = screenSize.width / 2 - this.getWidth() / 2;
		// y좌표구하기
		yL = screenSize.height / 2 - this.getHeight() / 2;

		setLocation(xL, yL); // 구한 좌표로 위치 지정

		// 메뉴 타이틀
		String accountName = account.getName().toString();
		this.setTitle("내 노트 ");

		bar = new JLabel(new ImageIcon("images/bar.png"));
		bar.setBounds(0, 0, 360, 53);
		bar.setText(accountName + "님의 노트 ");
		bar.setForeground(Color.white);
		bar.setHorizontalTextPosition(JLabel.CENTER);
		bar.setVerticalTextPosition(JLabel.CENTER);
		mc.add(bar);

		// 상단바 메뉴 폰트
		Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
		bar.setFont(font2);

		// 상단바 로고
		try {
			this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		memo.setLocation(20, 80);
		memo.setSize(300, 350);
		memo.setToolTipText("이곳에 메모를 입력하세요"); // 커서 올리면 가이드
		memo.setLineWrap(true);

		// 버튼
		saveM = new JButton("저장하기");
		saveM.setForeground(Color.white); 
		saveM.setBackground(new Color(220, 118, 112)); 
		back = new JButton("뒤로가기");
		back.setForeground(Color.white); 
		back.setBackground(new Color(220, 118, 112)); 
		
		// 2. 버튼 위치
		saveM.setBounds(90, 450, 150, 30);
		back.setBounds(230, 500, 90, 30);

		// 붙여넣기
		mc.add(bar);
		mc.add(memo);
		mc.add(saveM);
		mc.add(back);

		// 상단바 로고
        try {
           this.setIconImage(ImageIO.read(new File("images/logo.PNG")));
        } catch (IOException e) {
           e.printStackTrace();
        }
		
		this.add(mc);

		String str = mm.callMyMemo(account);
		if (!str.equals("")) {
			memo.setText(str);
		}

		// 버튼
		saveM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					String memoS = memo.getText();
					mm.saveMemo(account, memoS);
					JOptionPane.showMessageDialog(null, "    메모가 저장되었습니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				saveM.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				saveM.setBackground(new Color(220, 118, 112)); // 버튼색
			} 
		});

		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					JOptionPane.showMessageDialog(null, "       메뉴로 돌아갑니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					new MenuChoice(account);
					setVisible(false);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setBackground(new Color(128, 128, 128)); // 버튼색
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setBackground(new Color(220, 118, 112)); // 버튼색
			} 
			
		});
		
		

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}
