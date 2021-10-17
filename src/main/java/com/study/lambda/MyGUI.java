package com.study.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyGUI extends JFrame{
	private JTextField name=new JTextField("Please enter your name");
	private JTextField response=new JTextField("Greeting");
	private JButton button=new JButton("Say Hi");
	
	public MyGUI() {
		String greeting="Hello, %s!";//區域變數
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				response.setText(String.format(greeting, name.getText()));//取得區域變數與屬性
				//greeting="Anything else";//修改區域變數
			}
		});
	}

}
