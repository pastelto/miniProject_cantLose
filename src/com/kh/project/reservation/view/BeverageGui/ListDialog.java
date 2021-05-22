package com.kh.project.reservation.view.BeverageGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListDialog extends JFrame{
	
	public ListDialog() {
		
		setTitle("장바구니 물을거야");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mc = new JPanel();
		setContentPane(mc);
		
		JButton ok = new JButton("OK");
		JButton no = new JButton("NO");
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		mc.add(ok);
		mc.add(no);
		
		this.add(mc);
		
		this.setSize(300,100);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
	
	
}


 




