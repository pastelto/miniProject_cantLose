package com.kh.project.reservation.view.Board;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class CancelMemo extends JDialog { // 메모 작성 중 취소시 경고 메세지
	
	JLabel label1 = new JLabel("취소 하시겠습니까?");// 다이얼로그 문구
	JLabel label2 = new JLabel("(작성하신 메모가 저장되지 않습니다.)"); // 경고메세지
	JButton okBtn = new JButton("확인"); // 버튼 1
	JButton noBtn = new JButton("취소"); // 버튼 2

	boolean result;
	
	
	
}

