package com.malvern.BBM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home implements ActionListener {
	
	JFrame frame = new JFrame("BBM");
	JLabel label = new JLabel("Branch And Bound Simulator");
	JButton pdf = new JButton("Theoretical Material");
	JButton quiz = new JButton("Start Quiz");
	
	Home(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setResizable(true);
		
		label.setBounds(100, 50, 300, 100);
		label.setFont(new Font("Arial", Font.ITALIC,20));
		
		pdf.setBounds(50, 300, 150, 50);
		pdf.setFocusable(false);
		pdf.setFont(new Font("Arial", Font.ITALIC,13));
		pdf.addActionListener(this);
		
		quiz.setBounds(250, 300, 150, 50);
		quiz.setFocusable(false);
		quiz.setFont(new Font("Arial", Font.ITALIC,13));
		quiz.addActionListener(this);
		
		frame.add(quiz);
		frame.add(pdf);
		frame.add(label);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
