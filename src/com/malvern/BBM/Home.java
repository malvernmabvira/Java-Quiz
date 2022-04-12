package com.malvern.BBM;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
		
		if(e.getSource() == pdf) {
			
			/*try {
				
				Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + 
				"ECO_3_lecture_6_Introduction_to_the_Branch_and_Bound_Method.pdf");
				
			}catch(Exception error) {
				
				JOptionPane.showMessageDialog(null, "There is a problem with opening file!!", "Error", JOptionPane.ERROR_MESSAGE);
				
			}*/
			BufferedInputStream in = null;
	        FileOutputStream fout = null;
	        try { 
	            in = new BufferedInputStream(getClass().getResource("ECO_3_lecture_6_Introduction_to_the_Branch_and_Bound_Method.pdf").openStream());
	            fout = new FileOutputStream("ECO_3_lecture_6_Introduction_to_the_Branch_and_Bound_Method.pdf");
	            byte data[] = new byte[1024];
	            int count;
	            while ((count = in.read(data, 0, 1024)) != -1) {
	                fout.write(data, 0, count);
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(Applet.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                if ( in != null)
	                    in.close();
	                if (fout != null) {
	                    fout.close();
	                    if (Desktop.isDesktopSupported()) {
	                        File file = new File(System.getProperty("user.dir")+"\\ECO_3_lecture_6_Introduction_to_the_Branch_and_Bound_Method.pdf");
	                        Desktop.getDesktop().open(file);
	                    }
	                }
	            }
	            catch (IOException ex) {
	                Logger.getLogger(Applet.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
		}
		
		
		if(e.getSource() == quiz) {
			frame.dispose();
			new Quiz();
		}
		
	}

}
