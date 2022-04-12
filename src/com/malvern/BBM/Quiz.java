package com.malvern.BBM;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {
	
	String [] questions = {
			
			"What is branch and bound method?",
			"Which of the following statement is true about rules of branching?",
			"Which of the following is not used in branching?"
	};
	
	String [][] options = {
			{"It is a method of storing data.", "It is a method used for solving optimization problems.",
				"It is method used for project management"},
			{"Q1 ∪…∪ Qn = Q; Qi ≠⊘", "Q1 ⋂…⋂ Qn = Q; Qi ≠⊘", "Q1 ∪…∪ Qn = Q; Qi = ⊘"},
			{"Last In First Out(LIFO)", "The most costful branch", "First In First Out(FIFO)"}
	};
	
	char answers[] = {
			'B', 'A', 'B'
			
	};
	
	char guess; char answer; int index; int correct_guesses; int result;
	int total_questions = questions.length;
	int seconds = 45;
	
	JFrame frame = new JFrame("Quiz");
	JTextArea textArea = new JTextArea();
	JRadioButton answerA = new JRadioButton();
	JRadioButton answerB = new JRadioButton();
	JRadioButton answerC = new JRadioButton();
	JLabel secondsLeft = new JLabel();
	JLabel Timer = new JLabel();
	JLabel mark = new JLabel("Your score is:");
	JTextField Score = new JTextField();
	JTextField Percentage = new JTextField();
	JButton home = new JButton("Back to home page");
	
	Timer time = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			seconds--;
			secondsLeft.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}
		 
	 });
	
	Quiz(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,700);
		frame.setLayout(null);
		frame.setResizable(true);
		
		textArea.setBounds(20, 50, 500, 100);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial", Font.ITALIC,25));
		textArea.setEditable(false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(answerA);
		group.add(answerB);
		group.add(answerC);
		
		answerA.setBounds(20, 200, 500, 50);
		answerA.setFont(new Font("Arial", Font.ITALIC,18));
		answerA.addActionListener(this);
		
		answerB.setBounds(20, 250, 500, 50);
		answerB.setFont(new Font("Arial", Font.ITALIC,18));
		answerB.addActionListener(this);
		
		answerC.setBounds(20, 300, 500, 50);
		answerC.setFont(new Font("Arial", Font.ITALIC,18));
		answerC.addActionListener(this);
		
		secondsLeft.setBounds(400,510,100,100);
		secondsLeft.setFont(new Font("Mv Boli", Font.BOLD,60));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		
		Timer.setBounds(400,475,100,25);
		Timer.setBackground(new Color(0x1c2541));
		Timer.setForeground(new Color(0xd00000));
		Timer.setFont(new Font("Mv Boli", Font.BOLD,17));
		Timer.setHorizontalAlignment(JTextField.CENTER);
		Timer.setText("Time left");
		
		mark.setBounds(150,150,250,50);
		mark.setBackground(new Color(0x000000));
		mark.setForeground(new Color(0xfca311));
		mark.setFont(new Font("Mv Boli", Font.BOLD,30));
		mark.setHorizontalAlignment(JTextField.CENTER);
		mark.setVisible(false);
		
		Score.setBounds(225,225,200,100);
		Score.setBackground(new Color(0x1c2541));
		Score.setForeground(new Color(255,215,0));
		Score.setFont(new Font("Mv Boli", Font.BOLD,50));
		Score.setBorder(BorderFactory.createBevelBorder(1));
		Score.setHorizontalAlignment(JTextField.CENTER);
		Score.setEditable(false);
		Score.setVisible(false);
		
		Percentage.setBounds(225,325,200,100);
		Percentage.setBackground(new Color(0x1c2541));
		Percentage.setForeground(new Color(255,215,0));
		Percentage.setFont(new Font("Mv Boli", Font.BOLD,50));
		Percentage.setBorder(BorderFactory.createBevelBorder(1));
		Percentage.setHorizontalAlignment(JTextField.CENTER);
		Percentage.setEditable(false);
		Percentage.setVisible(false);
		
		home.setBounds(150, 600, 150, 50);
		home.setFocusable(false);
		home.setFont(new Font("Arial", Font.ITALIC,13));
		home.setVisible(false);
		home.addActionListener(this);
		
		frame.add(home);
		frame.add(Percentage);
		frame.add(Score);
		frame.add(mark);
		frame.add(Timer);
		frame.add(secondsLeft);
		frame.add(answerC);
		frame.add(answerB);
		frame.add(answerA);
		frame.add(textArea);
		frame.setVisible(true);
		
		nextQuestion();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home) {
			frame.dispose();
			new Home();
		}
		
		if(e.getSource() == answerA ) {
			answer = 'A';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		displayAnswer();
		
		if(e.getSource()==home) {
			frame.dispose();
			new Home();
		}
	}
	
	public void nextQuestion() {
		
		if(index >= total_questions) {
			results();
		}
		else {
			textArea.setText(questions[index]);
			answerA.setText(options[index][0]);
			answerB.setText(options[index][1]);
			answerC.setText(options[index][2]);
			time.start();
		}
		
	}
	
	public void displayAnswer() {
		
		time.stop();
		if(answers[index] != 'A') 
			answerA.setForeground(new Color(0xd00000));
		if(answers[index] != 'B') 
			answerB.setForeground(new Color(0xd00000));
		if(answers[index] != 'C') 
			answerC.setForeground(new Color(0xd00000));
		
		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				answerA.setForeground(new Color(0,0,0));
				answerB.setForeground(new Color(0,0,0));
				answerC.setForeground(new Color(0,0,0));
				
				answer = ' ';
				seconds = 45;
				secondsLeft.setText(String.valueOf(seconds));
				index++;
				nextQuestion();				
			}
			 
		 });
		 pause.setRepeats(false);
		 pause.start();
		
		
	}
	
	public void results() {
		
		textArea.setVisible(false);
		secondsLeft.setVisible(false);
		Timer.setVisible(false);
		answerA.setVisible(false);
		answerB.setVisible(false);
		answerC.setVisible(false);
		
		mark.setVisible(true);
		Score.setVisible(true);
		Percentage.setVisible(true);
		home.setVisible(true);
		
		result =(int)((correct_guesses/(double)total_questions) * 100);
		Score.setText(String.valueOf(correct_guesses) +"/" + String.valueOf(total_questions));
		Percentage.setText(String.valueOf(result) + "%");
		
		
	}

}
